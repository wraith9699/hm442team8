import java.io.IOException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import commonFiles.Patient;
import commonFiles.NurseStation;

public class NurseStationImpl extends UnicastRemoteObject implements NurseStation{

	//The Nurses Station needs to:
	// 1 - Create and store patient objects
	// 2 - Assign patient objects to bedside systems (includes all alarms)
	// 3 - Receive patient objects as updates from bedside systems
	// 4 - Send vital alarm acknowledgements
	// 5 - Provide Patient's Data for Display
	
	//HashMap of all the patients in the system
	private HashMap patientMap = new HashMap();
	//HashMap of all the remote bedside systems
	private HashMap bedsideMap = new HashMap();
	
	//Default Constructor
	public NurseStationImpl() throws RemoteException{
		patientMap = new HashMap();
	}
	
	//Methods that need to be implemented:
	
	//Gather all of the Patients into an ArrayList for display
	public ArrayList getPatientList(){
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.addAll(patientMap.values());
		return patientList;
	}
	
	//Create Patient Object, and store it in the patientList, and attempt to send Patient to an available Bedside System
	public void admitPatient(String name, int id){
		Patient newPatient = new Patient(name, id);
		patientMap.put(id, newPatient);
		//TODO: Attempt to send Patient to an available Bedside System.
	}
	
	
	//Receive Patient Object via RMI
	public void updatePatientInfo(Patient p){
		patientMap.put(p.getID(),p);
	}
	
	//Send Vital Alarm Acknowledgement via RMI
	public void acknowledgeVitalAlarm(Patient p){
		
	}
	
	public void lookupBedsides(String[] id){
		try{
			System.setSecurityManager(new RMISecurityManager());
			Registry registry = LocateRegistry.getRegistry();
			for(int i = 0; i < id.length; i++){
				bedsideMap.put(id[i], (BedsideSystem)registry.lookup(id[i]));
			}
		}
	}
}
