import java.io.IOException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import commonFiles.Patient;
import commonFiles.NurseStation;
import commonFiles.BedsideSystem;

public class NurseStationImpl extends UnicastRemoteObject implements NurseStation{

	//The Nurses Station needs to:
	// 1 - Create and store patient objects
	// 2 - Assign patient objects to bedside systems (includes all alarms)
	// 3 - Receive patient objects as updates from bedside systems
	// 4 - Send vital alarm acknowledgements
	// 5 - Provide Patient's Data for Display
	
	
	private static final long serialVersionUID = 1L;
	
	private HashMap<String,Patient> patientMap;
	private HashMap<String,BedsideSystem> bedsideMap;
	
	//Default Constructor
	public NurseStationImpl() throws RemoteException{
		patientMap = new HashMap<String,Patient>();
		bedsideMap = new HashMap<String,BedsideSystem>();
	}
	
	//Methods that need to be implemented:
	
	//Gather all of the Patients into an ArrayList for display
	public ArrayList<Patient> getPatientList(){
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.addAll(patientMap.values());
		return patientList;
	}
	
	//Create Patient Object, and store it in the patientList, and attempt to send Patient to an available Bedside System
	public void admitPatient(String name, String id){
		Patient newPatient = new Patient(name, id);
		patientMap.put(id, newPatient);
		//TODO: Attempt to send Patient to an available Bedside System.
	}
	
	
	//Receive Patient Object via RMI
	public void updatePatientInfo(Patient p){
		patientMap.put(p.getID(),p);
	}
	
	//Send Vital Alarm Acknowledgement via RMI
	public void acknowledgeVitalAlarm(BedsideSystem bs){
		
	}
	
	public void lookupBedsides(String[] id){
		try{
			System.setSecurityManager(new RMISecurityManager());
			Registry registry = LocateRegistry.getRegistry();
			for(int i = 0; i < id.length; i++){
				bedsideMap.put(id[i], (BedsideSystem)registry.lookup(id[i]));
			}
		}
		catch(Exception e){
			System.err.println("Something went wrong while getting the bedsides.");
		}
	}
}
