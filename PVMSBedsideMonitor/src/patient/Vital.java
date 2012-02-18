package patient;

public class Vital {
	private String name;
	private int currentValue;
	private int highValue;
	private int lowValue;
	private int highHigh;
	private int lowLow;
	private VitalTrend trend;
	private boolean isHigh;
	private boolean isLow;
	private boolean isHighHigh;
	private boolean isLowLow; 
	public Vital( String name, int currentValue ){
		this.name = name;
		this.currentValue = currentValue;
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
	
	public boolean getIsHigh(){
		return isHigh;
	}
	
	public boolean getIsLow(){
		return isLow;
	}
	
	public void setIsHigh( boolean isHigh){
		this.isHigh = isHigh;
	}
	
	public void setIsLow( boolean isLow ){
		this.isLow = isLow;
	}
	
	public void setIsHighHigh( boolean isHighHigh ){
		this.isHighHigh = isHighHigh;
	}
	
	public void setIsLowLow( boolean isLowLow ){
		this.isLowLow = isLowLow;
	}
	
	public void setCurrent( int currentValue ){
		this.currentValue = currentValue;
	}
	
	public boolean getisHighHigh(){
		return isHighHigh;
	}
	
	public boolean getisLowLow(){
		return isLowLow;
	}
}
