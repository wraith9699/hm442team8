import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.ServerException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import vital.VitalParser;

import commonFiles.BedsideSystem;
import commonFiles.NurseStation;
import commonFiles.Vital;

import commonFiles.Patient;


//Functions:
//display all current patient vitals
//display specific vital trend
//register to registry server (done)
//send patient object to server (done)
//set patient's info (done)
//enable/disable sensors
//set Timer
//accept patient assignment from server (done)

//Note: All Alarms, Calls, and Vital updates are sent with the Patient object, which is sent at the time the sensors update the Patient's info


public class BedsideSystemImpl extends UnicastRemoteObject implements BedsideSystem{

	
	//Constants
	static final String NURSE_STATION = "nurse-station";
	
	//Attributes
	private NurseStation nurseStation;
	
	private Patient patient = null;
	private String bedID;
	
	private Status currentStatus;
	public enum Status { IDLE, CALLING, ALARMED};
	
	private VitalParser sensorArray;
	private BedsideUpdateManager bsManager;
	
	public static void main(String[] args) throws IOException {
		
		ArrayList <BedsideSystem> beds = new ArrayList();
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
			beds.add(new BedsideSystemImpl("Dante" + i, "bd" + i));
			bedsideMonitorMainGUI GUI = new bedsideMonitorMainGUI((BedsideSystemImpl) beds.get(i)); 
			GUI.setVisible(true);
		}
		
		

	}
	
	//Constructors
	/**
	 * Creates new bedside with patient
	 * 
	 * @param patientName
	 * @param bedID
	 * @throws IOException
	 */
	public BedsideSystemImpl (String patientName, String bedID) throws IOException{
		
		getNurseStation();
		
		this.bedID = bedID;
		patient = new Patient(patientName, bedID);
		
		registerBedside();
		nurseStation.updateBedsideLookup(bedID);
		
		sensorArray = new VitalParser();
		bsManager = new BedsideUpdateManager(this);
	}
	
	/**
	 * Creates new empty bedside
	 * 
	 * @param bedID
	 * @throws IOException
	 */
	public BedsideSystemImpl (String bedID) throws IOException{
		
		getNurseStation();
		
		this.bedID = bedID;
		
		registerBedside();
		nurseStation.updateBedsideLookup(bedID);
		
		sensorArray = new VitalParser();
		bsManager = new BedsideUpdateManager(this);
	}
	
	/**
	 * Bedside registers itself in the RMI registry
	 * 
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public void registerBedside() throws RemoteException, MalformedURLException{
		Naming.rebind(this.bedID, this);
	}
	
	

	//Public
	/**
	 * Looks up remote nurse station using RMI registry
	 * 
	 * @throws RemoteException
	 */
	public void getNurseStation() throws RemoteException{
		if (nurseStation == null){
			try{
				System.setSecurityManager( new RMISecurityManager());
				Registry registry = LocateRegistry.getRegistry();
				nurseStation = (NurseStation) registry.lookup(NURSE_STATION);
			} catch (NotBoundException e){
	            throw new ServerException("Could not access nurse station", e);
	         } catch (IOException e){
	            throw new ServerException("Could not load jndi.properties", e);
	         }
	         
		}
	}
	
	/* (non-Javadoc)
	 * @see commonFiles.BedsideSystem#acceptPatient(java.lang.String, java.lang.String)
	 */
	public boolean acceptPatient(String name, String id){
		if (isEmpty()){
			patient = new Patient(name, id);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Periodically called to update all patient's vitals and 
	 * check for critical status.
	 * 
	 * @param vitalData
	 * @throws RemoteException
	 */
	public void updateVitals(HashMap vitalData) throws RemoteException{
		patient.updateCurrentVitals(vitalData);
		for (Object i : patient.getVitals().keySet().toArray()){
			Vital currentVital = (Vital) patient.getVitals().get(i);
			if (currentVital.isCritical()){
				System.out.println(bedID + " alarm triggered!");
				activateAlarm();
			}
		}
	}

	/**
	 * Notifies Nurse station of update.
	 * Currently non-functional.  Deprecated?
	 * 
	 * @throws RemoteException
	 */
	public void updateNurseStation() throws RemoteException{
		//nurseStation.updatePatientInfo(patient);
	}

	
	/**
	 * Sets bedside status to calling and triggers nurse station notification.
	 * Currently triggers alarm instead of notification, will be modified in 
	 * future releases.
	 * 
	 * @throws RemoteException
	 */
	public void callNurse() throws RemoteException{
		setStatus(Status.CALLING);
		nurseStation.alarmTrigger(bedID);
	}
	
	/**
	 * Sets bedside status to alarmed and trigger nurse station alarm
	 * 
	 * @throws RemoteException
	 */
	public void activateAlarm() throws RemoteException{
		setStatus(Status.ALARMED);
		nurseStation.alarmTrigger(bedID);
	}
	
	/* (non-Javadoc)
	 * @see commonFiles.BedsideSystem#resetAlarm()
	 */
	public void resetAlarm() throws RemoteException{
		setStatus(Status.IDLE);
	}
	
	/**
	 * Resets bedside status.  Method is private because it can only 
	 * be reset from the bedside.
	 * 
	 */
	private void resetCall(){
		setStatus(Status.IDLE);
	}

	
	/* (non-Javadoc)
	 * @see commonFiles.BedsideSystem#dischargePatient()
	 */
	public void dischargePatient() throws RemoteException{
		patient = null;
		updateNurseStation();
	}
	
	/* (non-Javadoc)
	 * @see commonFiles.BedsideSystem#isEmpty()
	 */
	public boolean isEmpty(){
		return patient == null;
	}
	
	// Getters and Setters
	
	public VitalParser getSensorArray() {
		return sensorArray;
	}

	public Patient getPatient() {
		return patient;
	}

	public String getBedNumber() {
		return bedID;
	}

	public void setBedNumber(int bedNumber) {
		this.bedID = bedID;
	}

	public Status getCurrentStatus() {
		return currentStatus;
	}
	
	public void setStatus(Status newStatus){
		currentStatus = newStatus;
	}
	
}
