package vital;

public class HeartRate implements VitalAlgorithm {

	//TODO: This should be re-designed to pull min/max data for the vital from
	//the patient. These are included as placeholders.
	int MIN = 0;
	int MAX = 200;
	
	@Override
	public int getValue(int rawMeasure) {
		int realValue = MIN + ((MAX - MIN) * (rawMeasure/100) );
		return realValue;
	}

}
