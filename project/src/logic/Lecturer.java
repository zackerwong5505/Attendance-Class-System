package logic;

public class Lecturer {
	private String lecturerID;
	private String name;
	private String password;
	
	public Lecturer(String i, String n, String p) {
		lecturerID = i;
		name = n;
		password = p;
	}
	
	public String getName() {
		return name;
	}
}
