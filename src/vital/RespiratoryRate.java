package vital;

public class RespiratoryRate implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	int MIN = 10;
	int MAX = 40;
	VitalSensor sensor = new VitalSensor("respiratoryrate");
	
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
