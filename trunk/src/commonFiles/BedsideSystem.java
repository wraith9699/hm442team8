package commonFiles;

import java.rmi.RemoteException;

public interface BedsideSystem {
	public boolean acceptPatient(String name, String id)throws RemoteException;
	public Patient getPatient()throws RemoteException;
	public boolean isEmpty()throws RemoteException;
	public void dischargePatient() throws RemoteException;
}
