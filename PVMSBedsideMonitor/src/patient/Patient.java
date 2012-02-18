package patient;

//Test

import java.util.ArrayList;

import commonFiles.Vital;

public class Patient {
	private String name;
	private ArrayList<Vital> vitalList = new ArrayList<Vital>();

	public Patient(String name){
		this.name = name;
	}
	
	public Patient(String name, ArrayList vitalList ){
		this.name = name;
		this.vitalList = vitalList;
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
