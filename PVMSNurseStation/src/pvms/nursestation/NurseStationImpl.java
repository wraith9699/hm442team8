package pvms.nursestation;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class NurseStationImpl extends UnicastRemoteObject{

	ArrayList<Patient> patientList;
	
	
	//Default Constructor
	public NurseStationImpl() throws RemoteException{
	}
	
	
	//Gather all of the Patients into an ArrayList
	public Collection getAllPatients(){
		ArrayList patientList = new ArrayList(patients.keySet());
		return patientList;
	}
	
	
	//Methods that need to be implemented:
	
	//Create Patient Object, and store it in the patientList
	public Patient admitPatient(){
		Patient newPatient = new Patient();
		patientList.
	}
	
	
	//Assign Patient to Bedside via Registry
	//Receive Patient Object via RMI
	//Send Vital Alarm Acknowledgement
	//Display All Patients and All Vitals and All Alarms
	
	
	public Patient admitPatient(PatientInfo info) throws IOException{
	}
}
