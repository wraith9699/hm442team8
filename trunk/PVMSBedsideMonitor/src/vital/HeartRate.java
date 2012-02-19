package vital;

public class HeartRate implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	double MIN = 0;
	double MAX = 200.0;
	VitalSensor sensor = new VitalSensor("heartrate");
	
	@Override
	public int getValue(double rawMeasure) {
		int realValue = (int) (MIN + ((MAX - MIN) * (rawMeasure/100) ));
		return realValue;
	}

	public int getValue(){
		double realValue = sensor.read();
		return getValue(realValue);
	}
	
}
