package vital;

import java.util.ArrayList;

public class VitalSensor {
	
	ArrayList<VitalData> trackedVitals;
	
	public VitalSensor(){
		trackedVitals = new ArrayList<VitalData>();
		//Add tracked values with default measures.
		trackedVitals.add(new VitalData("Blood Pressure", 0));
		trackedVitals.add(new VitalData("Body Temperature", 0));
		trackedVitals.add(new VitalData("HearthRate", 0));
		trackedVitals.add(new VitalData("RespiratoryRate", 0));
		trackedVitals.add(new VitalData("Weight", 0));
	}
	
	public ArrayList<VitalData> getVitals(){
		
		ArrayList<VitalData> vitals = new ArrayList<VitalData>();
		
		
		
		return vitals;
	}
	
}


//Internal context class for the strategy pattern.
class VitalType {
	
	public VitalAlgorithm vitalStrategy;
	
	public VitalType(VitalAlgorithm vA){
		vitalStrategy = vA;
	}
	
	public int getValue(int rawValue){
		return vitalStrategy.getValue(rawValue);	
	}
}
