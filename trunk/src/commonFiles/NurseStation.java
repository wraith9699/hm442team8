package commonFiles;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import commonFiles.Patient;

public interface NurseStation extends Remote{

	public ArrayList<Patient> getPatientList() throws RemoteException;
	
	public void admitPatient(String name, int id) throws RemoteException;
	
	public void updatePatientInfo(Patient p) throws RemoteException;
	
	public void acknowledgeVitalAlarm(Patient p) throws RemoteException;
}
