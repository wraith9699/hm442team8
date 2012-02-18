package vital;

/*
 * @author Daniel J. Smith
 */

public interface VitalAlgorithm {

	//Get the raw (0-100) measurement and
	//convert to the proper measure. 
	int getValue(int rawMeasure);
	int getValue();
}
