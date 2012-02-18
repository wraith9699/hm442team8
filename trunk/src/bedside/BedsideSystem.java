package bedside;

//Top-level interface for the bedside system.

public interface BedsideSystem {

	void getVitals();
	void getVital();
	void setTimerPeriods(int period);  //in milliseconds
	//Commands w/ no return
	void startSensors();
	void updatePatientVital();
	void resetAlarm();
	void triggerAlarm();
	void TriggerCall();
	void resetCall();
	
}
