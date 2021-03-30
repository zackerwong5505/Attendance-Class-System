package data;

public class TempClassRecord {
	private String name;
	private String code;
	private String duration;
	private int numberofstudent;
	private String secretcode;
	private boolean check;
	
	public TempClassRecord(String name, String code, String duration,
			int numberofstudent) {
		
		this.name = name;
		this.code = code;
		this.duration = duration;
		this.numberofstudent = numberofstudent;
		this.secretcode = getSecretCode();
		this.check = false;
	}
	private String getSecretCode() {
		// TODO Auto-generated method stub
		return secretcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getNumberofstudent() {
		return numberofstudent;
	}
	public void setNumberofstudent(int numberofstudent) {
		this.numberofstudent = numberofstudent;
	}
	public boolean getCheck(){
		return check;
	}
	public void setCheck(boolean a){
		this.check = a;;
	}
	

}
