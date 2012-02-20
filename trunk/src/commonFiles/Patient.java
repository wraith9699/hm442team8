package commonFiles;

//Test

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import vital.VitalData;

public class Patient implements Serializable {
	private String name;
	private String patientID;
	private HashMap <String, Vital> vitalList;

	public Patient(String name, String patientID){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = new HashMap();
		vitalList.put("Blood Pressure", new Vital("bPressure", 119, 111, 121, 109));
		vitalList.put("Body Temperature", new Vital("bTemperature", 101, 94, 104, 90));
		vitalList.put("Heart Rate", new Vital("hRate", 104, 56, 106, 54));
		vitalList.put("Respiratory Rate", new Vital("rRate", 29, 21, 31, 19));
		vitalList.put("Weight", new Vital("weight", 250, 111, 300, 109));
	}
	
	public Patient(String name, String patientID, HashMap vitals){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = vitals;
	}
	
	public void updateCurrentVitals(HashMap <String, Integer> vitalData){
		for (Object i : vitalData.keySet().toArray()){
			//System.out.println(i + " " + vitalList.get(i));
			vitalList.get(i).setCurrent(vitalData.get(i));
			//put(i, vitalData.get(i));
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
