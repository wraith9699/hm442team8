package vital;

/*
 * @author Daniel J. Smith
 */

public class BloodPressure implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	int MIN = 60;
	int MAX = 160;
	
	VitalSensor sensor = new VitalSensor("bloodpressure");
	
	@Override
	public int getValue(int rawMeasure) {
		int realValue = MIN + ((MAX - MIN) * (rawMeasure/100) );
		return realValue;
	}

	public int getValue(){
		int realValue = sensor.read();
		return getValue(realValue);
	}
	
}
