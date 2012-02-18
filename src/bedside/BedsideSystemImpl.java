package bedside;
import java.util.ArrayList;

import LogF.LogFile;

import patient.Patient;
import patient.Vital;

//The concrete implementation class for the bedside system.

public class BedsideSystemImpl implements BedsideSystem {

	private boolean isAlarmed;
	private boolean isCalled; 
	private Patient patient;
	@Override
	public void getVitals() {
		// TODO Auto-generated method stub
		ArrayList<Vital> vitals = patient.getVitals();
		for( Vital v : vitals ){
			String output = v.getName() + " " + v.getCurrentValue();
			LogFile.getInstance().writeToFile( output );
		}
	}

	public void getVital( Vital vital ){
		//String output = patient.getVital( vital );
		//LogFile.getInstance().writeToFile(output );
	}
	@Override
	public void setTimerPeriods(int period) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startSensors() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePatientVital() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetAlarm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void triggerAlarm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void TriggerCall() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetCall() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getVital() {
		// TODO Auto-generated method stub
		
	}

}
