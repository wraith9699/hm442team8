package vital;

import java.util.ArrayList;

//Dummy interface for external data sources

public class VitalSensor {

	// This is where the class would get the information from the external
	// physical sensor. Lacking one of those, this is going to be left to
	// languish in unimplemented emptiness.

	String type;

	public VitalSensor(String sensorType) {
		type = sensorType;
	}

	public int read() {
		// several return types are included for the sake of the tester.

		// HOLDING - Fairly flat
		// Returns a value between 48 and 52, for a flat and yet
		// slightly variable vital.
		return (int) (48.0 + Math.random() * 4.0);

		// REASONABLE - Jumpy but reasonable-ish
		// Return a reasonable yet random value between 40 and 60.
		// System.out.println(returner);
		// return (int) (40.0 + Math.random()*20.0);

		// CRAZY - Totally random
		// Return a completely random value between 0 and 100.
		// return (int) (Math.random()*100.0);

		// CRITICAL - Will usually trigger an alarm
		// Return an extremely high value.
		// return (int) (90.0 + Math.random()*10.0)

	}

}
