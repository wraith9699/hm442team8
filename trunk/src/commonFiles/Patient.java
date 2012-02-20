package commonFiles;

//Test

import java.util.ArrayList;
import java.util.HashMap;

import vital.VitalData;

public class Patient {
	private String name;
	private String patientID;
	private HashMap vitalList = new HashMap();

	public Patient(String name, String patientID){
		this.name = name;
		this.patientID = patientID;
		vitalList.put("bloodPressure", new Vital("bPressure", 0));
		vitalList.put("bodyTemperature", new Vital("bPressure", 0));
		vitalList.put("heartRate", new Vital("hRate", 0));
		vitalList.put("respiratoryRate", new Vital("rRate", 0));
		vitalList.put("weight", new Vital("weight", 0));
	}
	
	public Patient(String name, String patientID, HashMap vitals){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = vitals;
	}
	
	public void updateCurrentVitals(ArrayList <VitalData> vitalData){
		((Vital) vitalList.get("bloodPressure")).setCurrent(vitalData.get(0).getValue());
		//System.out.println("bp set");
		((Vital) vitalList.get("bodyTemperature")).setCurrent(vitalData.get(1).getValue());
		//System.out.println("bt set");
		((Vital) vitalList.get("heartRate")).setCurrent(vitalData.get(2).getValue());
		//System.out.println("hr set");
		((Vital) vitalList.get("respiratoryRate")).setCurrent(vitalData.get(3).getValue());
		//System.out.println("rr set");
		((Vital) vitalList.get("weight")).setCurrent(vitalData.get(4).getValue());
		System.out.println("w set");
	}
	
	public void addVital(Vital newVital){
		vitalList.put(newVital.getName(), newVital);
	}
	
	public void removeVital(Vital rmVital){
		vitalList.remove(rmVital.getName());
	}
	
	public void updateVital( Vital updatedVital ){
	}
	
	public Vital getVital( Vital desiredVital ){
		return (Vital) vitalList.get(desiredVital.getName());
	}
	
	public void setVitalList(HashMap vitals){
		vitalList = vitals;
	}
	
	public HashMap getVitals(){
		return vitalList;
	}
	public String getID(){
		return patientID;
	}
	
}
