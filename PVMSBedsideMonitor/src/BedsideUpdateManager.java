


import java.rmi.RemoteException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class BedsideUpdateManager {
	
	Timer sensorTimer;
	
	public BedsideUpdateManager(BedsideSystemImpl bedsideSystem){
		sensorTimer = new Timer();
		sensorTimer.scheduleAtFixedRate(new SensorPoll(bedsideSystem), new Date(), 2000);
	}
	
	

}

class SensorPoll extends TimerTask {
	
	private BedsideSystemImpl bedside;
	
	public SensorPoll (BedsideSystemImpl bedsideSystem){
		this.bedside = bedsideSystem;
	}
	
	public void run() {
		//System.out.println(bedside.getSensorArray().getVitals());
		try {
			bedside.updateVitals(bedside.getSensorArray().getVitals());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}