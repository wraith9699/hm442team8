import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Main {

	//Default Constructor
	public Main(){
		try{
			//startRegistry();
			startStation();
		}
		catch(Exception e){
			System.out.println("The Nurse's Station could not be started.");
			e.printStackTrace(System.err);
		}
	}
	
	
	//Create the RMI naming Registry
	public void startRegistry()throws Exception{
		try{
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		}
		catch(ExportException ee){
			System.out.println("Registry already exists.");
		}
		catch(RemoteException e){
			System.out.println("Registry could not be created.");
		}
	}
	
	
	//Start the Nurse's Station
	public void startStation()throws Exception{
		NurseStationImpl station = new NurseStationImpl();
		Naming.rebind("nurse-station", station);
	}
	
	
	//Main Executable
	public static void main(String[] args) throws Exception{
		@SuppressWarnings("unused")
		Main m = new Main();
	}
	
}
