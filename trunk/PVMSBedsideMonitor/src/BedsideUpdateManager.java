import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class BedsideUpdateManager {
	
	Timer sensorTimer;
	
	public BedsideUpdateManager(BedsideSystemImpl bedsideSystem){
		sensorTimer = new Timer();
		sensorTimer.scheduleAtFixedRate(new SensorPoll(bedsideSystem), new Date(), 500);
	}
	
	

}

class SensorPoll extends TimerTask {
	
	private BedsideSystemImpl bedside;
	
	public SensorPoll (BedsideSystemImpl bedsideSystem){
		this.bedside = bedsideSystem;
	}
	
	public void run() {
		bedside.updateVitals(bedside.getSensorArray().getVitals());
	}
}