package vital;

import java.util.ArrayList;
import java.util.HashMap;

import vital.VitalData;

/*
 * @author Daniel J. Smith
 * 
 * Main interface for the Vitals / Sensors subsystem. 
 * NOTE: We don't *really* have sensors ($$$), but we do have a simulation:
 * To change the sensors' output, in VitalSensor  un-comment the desired
 * return statement. For general / exhibitionary use, the HOLDING type is 
 * probably good. 
 */

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
	}
	
	public HashMap getVitals(){
		
		//ArrayList<VitalData> vitalSensors = new ArrayList<VitalData>();
		ArrayList<VitalData> vitals = new ArrayList<VitalData>();
		HashMap vitalMap = new HashMap();
		
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
			} else {
				//defaults to weight measurement
				vital = new VitalType(new weight());
			}
			int result = vital.getValue();
			VitalData datum = new VitalData(vitalName, result);
			vitals.add(datum);
		}
		
		for(int i = 0; i < vitals.size(); i++){
			VitalData vd = vitals.get(i);
			String vitalName = vd.getName();
			int vitalValue = vd.getValue();
			vitalMap.put(vitalName, vitalValue);
		}
		
		return vitalMap;
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
	
	public int getValue(){
		return vitalStrategy.getValue();
	}
}