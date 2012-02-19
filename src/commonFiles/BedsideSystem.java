package commonFiles;

public interface BedsideSystem {
	public boolean acceptPatient(String name, String id);
	public Patient getPatient();
	public boolean isEmpty();
}
