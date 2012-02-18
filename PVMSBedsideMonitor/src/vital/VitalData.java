package vital;

public class VitalData {

	private String name;
	private int value;
	
	public VitalData(){
		name = "";
		value = 0;
	}
	
	public VitalData(String newName, int newValue){
		name = newName;
		value = newValue;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public void setValue(int newValue){
		value = newValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
}
