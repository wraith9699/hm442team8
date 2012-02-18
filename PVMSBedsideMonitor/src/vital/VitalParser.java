package vital;

import java.util.ArrayList;

public class VitalParser {

	String BLOOD_PRESSURE = "Blood Pressure";
	String BODY_TEMPERATURE = "Body Temperature";
	String HEART_RATE = "Heart Rate";
	String RESPIRATORY_RATE = "Respiratory Rate";
	String WEIGHT = "Weight";
	
	ArrayList<VitalData> vitalSensors;
	VitalType bp;
	VitalType bt;
	VitalType hr;
	VitalType rr;
	VitalType we;
	
	public VitalParser(){
		vitalSensors = new ArrayList<VitalData>();
		//Add tracked values with default measures.
		vitalSensors.add(new VitalData(BLOOD_PRESSURE, 0));
		vitalSensors.add(new VitalData(BODY_TEMPERATURE, 0));
		vitalSensors.add(new VitalData(HEART_RATE, 0));
		vitalSensors.add(new VitalData(RESPIRATORY_RATE, 0));
		vitalSensors.add(new VitalData(WEIGHT, 0));
		/*
		bp = new VitalType(new BloodPressure());
		bt = new VitalType(new BodyTemperature());
		hr = new VitalType(new HeartRate());
		rr = new VitalType(new RespiratoryRate());
		we = new VitalType(new weight());
		*/
	}
	
	public ArrayList<VitalData> getVitals(){
		
		ArrayList<VitalData> vitalSensors = new ArrayList<VitalData>();
		
		int v = vitalSensors.size();
		for(int i = 0; i < v; i++){
			String vitalName = vitalSensors.get(i).getName();
			VitalType vital;
			if(vitalName.equals(BLOOD_PRESSURE)){
				vital = new VitalType(new BloodPressure());
			} else if(vitalName.equals(BODY_TEMPERATURE)){
				vital = new VitalType(new BodyTemperature());
			} else if(vitalName.equals(HEART_RATE)){
				vital = new VitalType(new HeartRate());
			} else if(vitalName.equals(RESPIRATORY_RATE)){
				vital = new VitalType(new RespiratoryRate());
			} else if(vitalName.equals(WEIGHT)){
				vital = new VitalType(new weight());
			}
			//int 
		}
		
		return new ArrayList<VitalData>();
		//return vitals;
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