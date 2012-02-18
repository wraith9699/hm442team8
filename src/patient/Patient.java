package patient;

//Test

import java.util.ArrayList;

public class Patient {
	private String name;
	private int patientID;
	private ArrayList<Vital> vitalList = new ArrayList<Vital>();

	public Patient(String name, ArrayList vitalList, int idNumber ){
		this.name = name;
		this.vitalList = vitalList;
		this.patientID = idNumber;
	}
	
	public void addVital( Vital newVital){
		vitalList.add(newVital);
	}
	
	public void removeVital( Vital rmVital){
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
}
