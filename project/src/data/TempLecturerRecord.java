package data;

public class TempLecturerRecord {
	private String lecturerID;
	private String name;
	private String password;
	
	public TempLecturerRecord(String i, String n, String p) {
		lecturerID = i;
		name = n;
		password = p;
	}
	
	public String getLecturerID() {
		return lecturerID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
}
