package vital;

public class weight implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	int MIN = 0;
	int MAX = 240;
	VitalSensor sensor = new VitalSensor("weight");
	
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
