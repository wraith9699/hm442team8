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
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList beds = new ArrayList();
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
			beds.add(new BedsideSystemImpl("bd" + i));
		}

	}
	
	//Constructor
	public BedsideSystemImpl (String patientName, String bedID) throws IOException{
		getNurseStation();
		this.bedID = bedID;
		patient = new Patient(patientName, bedID);
		registerBedside();
	}
	
	public BedsideSystemImpl (String bedNumber) throws IOException{
		getNurseStation();
		this.bedID = bedID;
		registerBedside();
	}
	
	public void registerBedside() throws RemoteException, MalformedURLException{
		Naming.rebind(bedID, this);
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
	
	public void updateVitals(){
		patient.setVitalList(vitals);
	}
	
	public void updateNurseStation() throws RemoteException{
		nurseStation.updatePatientInfo(patient);
	}
	
	public void callNurse() throws RemoteException{
		setStatus(Status.CALLING);
		updateNurseStation();
	}
	
	public void resetBedside() throws RemoteException{
		setStatus(Status.IDLE);
		updateNurseStation();
	}
	
	public void activateAlarm() throws RemoteException{
		setStatus(Status.ALARMED);
		updateNurseStation();
	}
	
	public void setStatus(Status newStatus){
		currentStatus = newStatus;
	}
	
	public boolean isEmpty(){
		return patient == null;
	}
	
	
}
