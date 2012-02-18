import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;

import patient.Patient;

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
	
	Patient patient;
	
	private enum status { IDLE, CALLING, ALARMED};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Constructor
	public BedsideSystem (String patientName) throws IOException{
		getNurseStation();
	}
	
	public BedsideSystem () throws IOException{
		getNurseStation();
	}
	
	//Public
	public void getNurseStation(){
		
	}
	
	public void getVitals(){

	}
	
	public void updateNurseStation(){
		
	}
	
	public void callNurse(){
		
	}
	
	public void acknowledgeCall(){
		
	}
	
	public void activateAlarm(){
		
	}
	
	public void resetAlarm(){
		
	}
	

	
	
}
