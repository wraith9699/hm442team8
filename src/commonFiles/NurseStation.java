package commonFiles;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import commonFiles.Patient;

public interface NurseStation extends Remote{
	
	public void updatePatientInfo(Patient p) throws RemoteException;
	
	public boolean isEmpty() throws RemoteException;
	
}
