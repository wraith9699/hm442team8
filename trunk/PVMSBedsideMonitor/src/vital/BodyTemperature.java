package vital;

public class BodyTemperature implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	int MIN = 90;
	int MAX = 110;
	VitalSensor sensor = new VitalSensor("bodytemperature");
	
	
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
