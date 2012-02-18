package patient;

import java.util.Queue;

import commonFiles.Vital;

public class VitalTrend {

	private int measurementPeriod;
	private Queue<Vital> vitalQueue;
		
	public VitalTrend( int measurementPeriod, Queue<Vital> vitalQueue){
		this.measurementPeriod = measurementPeriod;
		this.vitalQueue = vitalQueue;
	}
	
	public void addVitalMeasurment( Vital newVital){
		vitalQueue.add( newVital );
	}
	
	public void removeQueue( Vital rmVital ){
		vitalQueue.remove(rmVital);
	}
	
	public void clearVitalMeasurements(){
		vitalQueue.clear();
	}
	
	public void setMeasurementPeriod( int measurementPeriod ){
		this.measurementPeriod = measurementPeriod; 
	}
}
