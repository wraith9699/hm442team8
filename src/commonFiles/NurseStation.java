package commonFiles;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import commonFiles.Patient;

public interface NurseStation extends Remote{
	
	public void updateBedsideLookup(String id)throws RemoteException;
	
	public void acknowledgeVitalAlarm(Patient p)throws RemoteException;
	
	public void alarmTrigger(String bedID) throws RemoteException;
}
