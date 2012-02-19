package commonFiles;

//Test

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public void updateCurrentVitals(ArrayList vitalData){
		((Vital) vitalList.get("bloodPressure")).setCurrent((Integer) vitalData.get(0));
		((Vital) vitalList.get("bodyTemperature")).setCurrent((Integer) vitalData.get(1));
		((Vital) vitalList.get("heartRate")).setCurrent((Integer) vitalData.get(2));
		((Vital) vitalList.get("respiratoryRate")).setCurrent((Integer) vitalData.get(3));
		((Vital) vitalList.get("weight")).setCurrent((Integer) vitalData.get(4));
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
