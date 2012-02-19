package commonFiles;

//Test

import java.util.HashMap;

public class Patient {
	private String name;
	private String patientID;
	private HashMap vitalList = new HashMap();

	public Patient(String name, String patientID){
		this.name = name;
		this.patientID = patientID;
	}
	
	public Patient(String name, String patientID, HashMap vitals){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = vitals;
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
