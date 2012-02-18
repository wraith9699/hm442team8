import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class NurseStationImpl extends UnicastRemoteObject{

	//The Nurses Station needs to:
	// 1 - Create and store patient objects
	// 2 - Assign patient objects to bedside systems (includes all alarms)
	// 3 - Receive patient objects as updates from bedside systems
	// 4 - Send vital alarm acknowledgements
	// 5 - 
	
	
	HashMap patientMap;
	
	
	//Default Constructor
	public NurseStationImpl() throws RemoteException{
		patientMap = new HashMap();
	}
	
	//Methods that need to be implemented:
	
	//Gather all of the Patients into an ArrayList for display
	
	//Create Patient Object, and store it in the patientList, and attempt to send Patient to an available Bedside System
	public void admitPatient(String name, int id){
		Patient newPatient = new Patient(name, id);
		patientMap.put(id, newPatient);
		//TODO: Attempt to send Patient to an available Bedside System.
	}
	
	
	//Receive Patient Object via RMI
	public void updatePatientInfo(Patient p){
		patientMap.put(p.getID,p);
	}
	
	//Send Vital Alarm Acknowledgement
	public void acknowledgeVitalAlarm(Patient p){
		
	}

}
