package vital;

/*
 * @author Daniel J. Smith 
 * Unit testing class for the Vital subsystem.
 */

import java.util.ArrayList;

public class VitalUnitTest {

	public static void main(String args[]) {

		VitalParser parser = new VitalParser();

		ArrayList<VitalData> returnedData = parser.getVitals();

		for (int x = 0; x < 10; x++) {
			System.out.println("Trial #" + (x + 1));
			returnedData = parser.getVitals();
			for (int i = 0; i < returnedData.size(); i++) {
				VitalData data = returnedData.get(i);
				System.out.println(data.getName() + " has a reading of "
						+ data.getValue());
			}

		}

	}

}
