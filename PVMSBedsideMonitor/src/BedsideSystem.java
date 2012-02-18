import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.ServerException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import commonFiles.NurseStation;

import commonFiles.Patient;


//Functions:
//display all current patient vitals
//display specific vital trend
//register to registry server
//send patient object to server
//set patient's info
//enable/disable sensors
//set Timer
//accept patient assignment from server

//Note: All Alarms, Calls, and Vital updates are sent with the Patient object, which is sent at the time the sensors update the Patient's info


public class BedsideSystem extends UnicastRemoteObject {

	
	//Constants
	static final String NURSE_STATION = "nurse-station";
	
	//Attributes
	NurseStation nurseStation;
	
	Patient patient = null;
	
	Status currentStatus;
	
	private enum Status { IDLE, CALLING, ALARMED};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Constructor
	public BedsideSystem (String patientName) throws IOException{
		nurseStation = getNurseStation();
	}
	
	public BedsideSystem () throws IOException{
		nurseStation = getNurseStation();
	}
	
	//Public
	public NurseStation getNurseStation() throws RemoteException{
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
	
	public void acceptPatient(Patient newPatient){
		if (isEmpty()){
			patient = newPatient;
		}
	}
	
	public void getVitals(){

	}
	
	public void updateNurseStation(){
		
	}
	
	public void callNurse(){
		setStatus(Status.CALLING);
		updateNurseStation();
	}
	
	public void resetBedside(){
		setStatus(Status.IDLE);
		updateNurseStation();
	}
	
	public void activateAlarm(){
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
