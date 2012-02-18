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
	
	public Patient admitPatient(PatientInfo info) throws IOException{
	}
}
