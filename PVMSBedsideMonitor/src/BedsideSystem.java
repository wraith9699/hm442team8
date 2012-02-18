import java.rmi.server.UnicastRemoteObject;


public class BedsideSystem extends UnicastRemoteObject {

	
	//Constants
	static final String NURSE_STATION = "nurse-station";
	
	//Attributes
	NurseStation nurseStation;
	
	Patient patient;
	ArrayList <Vital> patientVitals;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Constructor
	public BedsideSystem (String patientName) throws IOException{
			getNurseStation();
	}
	
	//Public
	public void getVitals(){

	}
	
	public void callNurse(){
		
	}
	
	

}
