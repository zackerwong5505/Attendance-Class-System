package data;

public class TempStudentRecord {
	private String studentID;
	private String name;
	private String password;
	private String photo;
	private int point;
	
	public TempStudentRecord(String i, String n, String pw,String ph,int p) {
		studentID = i;
		name = n;
		password = pw;
		photo = ph;
		point =p;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	public String getPhoto() {
		return photo;
	}
	public int getPoint(){
		return point;
	}
}
