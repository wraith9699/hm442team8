import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;

import patient.Patient;


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
