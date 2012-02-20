package commonFiles;

import java.io.Serializable;

public class Vital implements Serializable {
	private String name;
	private int currentValue;
	private int highValue;
	private int lowValue;
	private int highHigh;
	private int lowLow;
	private VitalTrend trend;
	public Vital( String name, int currentValue ){
		this.name = name;
		this.currentValue = currentValue;
	}
	
	public Vital( String name, int high, int low, int highHigh, int lowLow){
		this.name = name;
		this.highValue = high; this.lowValue = low; this.highHigh = highHigh; this.lowLow = lowLow;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCurrentValue(){
		return currentValue;
	}
	
	public int getHigh(){
		return highValue;
	}
	
	public int getLow(){
		return lowValue;
	}
	
	public int getHighHigh(){
		return highHigh;
	}
	
	public int getLowLow(){
		return lowLow;
	}
	
	public void setHigh( int high){
		this.highValue = high;
	}
	
	public void setLow( int low ){
		this.lowValue = low;
	}
	
	public void setHighHigh( int highHigh){
		this.highHigh = highHigh;
	}
	
	public void setLowLow( int lowLow){
		this.lowLow = lowLow;
	}
	
	public VitalTrend getVitalTrend(){
		return trend;
	}
	
	public void setCurrent( int currentValue ){
		this.currentValue = currentValue;
	}
	
	public boolean isHigh(){
		return currentValue > highValue;
	}
	
	public boolean isLow(){
		return currentValue < lowValue;
	}
	
	public boolean isHighHigh(){
		return currentValue > highHigh;
	}
	
	public boolean isLowLow(){
		return currentValue < lowLow;
	}
	
	public boolean isCritical(){
		return isLowLow() || isHighHigh();
	}
}