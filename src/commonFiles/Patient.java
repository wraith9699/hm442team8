package commonFiles;

//Test

import java.util.ArrayList;

public class Patient {
	private String name;
	private String patientID;
	private ArrayList<Vital> vitalList = new ArrayList<Vital>();

	public Patient(String name, String patientID){
		this.name = name;
		this.patientID = patientID;
	}
	
	public Patient(String name, String patientID, ArrayList vitals){
		this.name = name;
		this.patientID = patientID;
		this.vitalList = vitals;
	}
	
	public void addVital(Vital newVital){
		vitalList.add(newVital);
	}
	
	public void removeVital(Vital rmVital){
		vitalList.remove(rmVital);
	}
	
	public void updateVital( Vital updatedVital ){
	}
	
	public Vital getVital( Vital desiredVital ){
		return vitalList.get(vitalList.indexOf(desiredVital));
	}
	
	public ArrayList<Vital> getVitals(){
		return vitalList;
	}
	public String getID(){
		return patientID;
	}
	
}
