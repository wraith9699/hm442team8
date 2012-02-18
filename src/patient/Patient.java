package patient;

import java.util.ArrayList;

public class Patient {
	private String name;
	private ArrayList<Vital> vitalList = new ArrayList<Vital>();

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
}
