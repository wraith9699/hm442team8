package vital;

import java.util.ArrayList;

//Dummy interface for external data sources

public class VitalSensor {
	
	// This is where the class would get the information from the external
	// physical sensor. Lacking one of those, this is going to be left to
	// languish in unimplemented emptiness. 
	
	String type;
	
	public VitalSensor(String sensorType){
		type = sensorType;
	}
	
	public int read(){
		//Return a reasonable yet random value between 40 and 60.
		return (int) (40 + Math.random()*20);
	}
	
	
}
