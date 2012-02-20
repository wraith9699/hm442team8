package commonFiles;

//Test

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import vital.VitalData;

public class Patient implements Serializable {
	private String name;
	private String patientID;
	private HashMap vitalList = new HashMap();

	public Patient(String name, String patientID){
		this.name = name;
		this.patientID = patientID;
		vitalList.put("BLOOD_PRESSURE", new Vital("bPressure", 0));
		vitalList.put("BODY_TEMPERATURE", new Vital("bPressure", 0));
		vitalList.put("HEART_RATE", new Vital("hRate", 0));
		vitalList.put("RESPIRATORY_RATE", new Vital("rRate", 0));
		vitalList.put("WEIGHT", new Vital("weight", 0));
	}
	
	public Patient(String name, String patientID, HashMap vitals){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = vitals;
	}
	
	public void updateCurrentVitals(HashMap vitalData){
		for (Object i : vitalData.keySet().toArray()){
			vitalList.put(i, vitalData.get(i));
			System.out.println("Patient " + name + " " + i + " = " + vitalData.get(i));
		}
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
	
	public String getName(){
		return name;
	}
	
}
