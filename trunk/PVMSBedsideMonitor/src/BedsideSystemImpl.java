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
	private enum Status { IDLE, CALLING, ALARMED};
	
	private VitalParser sensorArray;
	private BedsideUpdateManager bsManager;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList beds = new ArrayList();
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
			beds.add(new BedsideSystemImpl("Dante" + i, "bd" + i));
			//((BedsideSystemImpl) beds.get(i)).registerBedside();
			//((BedsideSystemImpl) beds.get(i)).rmiTest();
		}

	}
	
	//Constructor
	public BedsideSystemImpl (String patientName, String bedID) throws IOException{
		getNurseStation();
		this.bedID = bedID;
		patient = new Patient(patientName, bedID);
		registerBedside();
		nurseStation.updateBedsideLookup(bedID);
		sensorArray = new VitalParser();
		bsManager = new BedsideUpdateManager(this);
		this.rmiTest();
	}
	
	public BedsideSystemImpl (String bedID) throws IOException{
		getNurseStation();
		this.bedID = bedID;
		registerBedside();
		nurseStation.updateBedsideLookup(bedID);
		sensorArray = new VitalParser();
		bsManager = new BedsideUpdateManager(this);
		this.rmiTest();
	}
	
	public void registerBedside() throws RemoteException, MalformedURLException{
		//System.out.println(bedID + "\n" + this);
		Naming.rebind(bedID, this);
	}
	
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

	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}

	//Public
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
	
	public boolean acceptPatient(String name, String id){
		if (isEmpty()){
			patient = new Patient(name, id);
			return true;
		}else{
			return false;
		}
	}
	
	public void updateVitals(HashMap vitalData){
		//System.out.println(vitalData);
		patient.updateCurrentVitals(vitalData);
	}
	
	public void updateNurseStation() throws RemoteException{
		//nurseStation.updatePatientInfo(patient);
	}
	
	public void callNurse() throws RemoteException{
		setStatus(Status.CALLING);
		nurseStation.alarmTrigger(bedID);
	}
	
	public void resetAlarm() throws RemoteException{
		setStatus(Status.IDLE);
		;
	}
	
	private void resetCall(){
		setStatus(Status.IDLE);
	}
	
	public void activateAlarm() throws RemoteException{
		setStatus(Status.ALARMED);
		nurseStation.alarmTrigger(bedID);
	}
	
	public void setStatus(Status newStatus){
		currentStatus = newStatus;
	}
	
	public void dischargePatient() throws RemoteException{
		patient = null;
		updateNurseStation();
	}
	
	public boolean isEmpty(){
		return patient == null;
	}
	
	public void rmiTest() throws RemoteException{
		nurseStation.acknowledgeVitalAlarm(patient);
	}
	
	
}
