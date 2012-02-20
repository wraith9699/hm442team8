//TODO: acknowledgeVitalAlarm

//When an alarm is triggered at the bedside system,it will call a method at the nurses station to trigger and alarm

import java.io.IOException;
import java.rmi.NotBoundException;
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
	
	
	/* Attributes  */
	
	private static final long serialVersionUID = 1L;
	
	//Collection of all the remote references to the bedside systems
	private HashMap<String,BedsideSystem> bedsideMap;
	
	//The amount of milliseconds in between data pulls from the BedsideSystems
	private int pullDelay = 2000;
	
	//The timer to call the data pulls
	private Timer updateClock = new Timer(true);
	
	//The task the timer performs every delay
	private class updateTask extends TimerTask{
		public void run(){
			try{
				if(!getBedList().isEmpty())
					gatherBedsideUpdates();
			} 
			catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println("Updated Patient Information.");
		}	
	}
	private updateTask task;
	
	/* Functions */
	
	//Default Constructor
	public NurseStationImpl() throws RemoteException{
		bedsideMap = new HashMap<String,BedsideSystem>();
		updateClock.schedule(task,0,pullDelay);
	}
	
	//Receive knowledge that a bedside exists.
	public void updateBedsideLookup(String id) throws RemoteException{
		HashMap<String,BedsideSystem> tempBedMap = new HashMap<String,BedsideSystem>();
		try{
			System.setSecurityManager(new RMISecurityManager());
			Registry registry = LocateRegistry.getRegistry();
			tempBedMap.put(id,(BedsideSystem)registry.lookup(id));
			bedsideMap = tempBedMap;
		}
		catch(IOException e){
			System.err.println("IO Exception in update Bedside");
		}
		catch(NotBoundException nbe){
			System.err.println("Not Bound Exception in update Bedside");
		}
	}
	
	//Collect an ArrayList of all the remote references to bedside systems from the map
	public ArrayList<BedsideSystem> getBedList()throws RemoteException{
		ArrayList<BedsideSystem> bedList = new ArrayList<BedsideSystem>();
		if(bedsideMap.isEmpty() != true)
			bedList.addAll(bedsideMap.values());
		return bedList;
	}
	
	//Tell the first available bedside system to create a patient object
	public void admitPatient(String name, String id)throws RemoteException{
		ArrayList<BedsideSystem> bedList = getBedList();
		boolean added = false;
		for(int i = 0; i < bedList.size(); i++){
			//If the bed is vacant and the patient hasn't already been added
			if (bedList.get(i).isEmpty() && added == false){
				bedList.get(i).acceptPatient(name,id);
				added = true;
			}
		}
	}
	
	//Tell the remote reference to a bedside system to discharge its patient
	public void dischargePatient(Patient p)throws RemoteException{
		ArrayList<BedsideSystem> bedList = getBedList();
		for(int i = 0; i < bedList.size(); i++){
			if(bedList.get(i).getPatient() == p)
				bedList.get(i).dischargePatient();
		}
	}
	
	//Pull all the patients from the remote bedside references and store them in a map
	public HashMap<String,Patient> gatherBedsideUpdates()throws RemoteException{
		HashMap<String,Patient> patientMap = new HashMap<String,Patient>();
		ArrayList<BedsideSystem> bedList = getBedList();
		for(int i = 0; i < bedList.size(); i ++){
			Patient temp = bedList.get(i).getPatient();
			if(temp != null)
				patientMap.put(temp.getID(), temp);
		}
		return patientMap;
	}
	
	//Send Vital Alarm Acknowledgement via RMI
	public void acknowledgeVitalAlarm(Patient p)throws RemoteException{
		ArrayList<BedsideSystem> bedList = getBedList();
		if(bedList.size()>1){
			for(int i = 0; i < bedList.size(); i++){
				if(bedList.get(i).getPatient() == p){
					bedList.get(i).resetBedside();
				}
			}
		}
	}
	
	public void alarmTrigger(String id) throws RemoteException{
		ArrayList<BedsideSystem> bedList = getBedList();
		if(bedList.size() > 0){
			for(int i = 0; i < bedList.size(); i++){
				if(bedList.get(i).getBedNumber().equals(id)){
					//call method in gui to trigger alarm
				}
			}
		}
	}
}
