import java.rmi.Naming;
import java.rmi.server.ExportException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	//Default Constructor
	public Main(){
		try{
			startRegistry();
			startStation();
		}
		catch(Exception e){
			System.out.println("The Nurse's Station could not be started.");
		}
	}
	
	
	//Create the RMI naming Registry
	public void startRegistry()throws Exception{
		try{
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		}
		catch(ExportException ee){
			
		}
		catch(Exception e){
			
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
