package logic;

import java.util.ArrayList;

public class Student {
	private String studentID;
	private String name;
	private String password;
	
	private ArrayList <Tutorclass> course = new ArrayList <Tutorclass>();
	private String photo;
	private int point ; 
	private boolean check ;


	
	
	public Student(String i, String n, String pw,String ph ,int p) {
		studentID = i;
		name = n;
		password = pw;
		this.photo = ph;
		this.check = false;
		this.point = p;
	}
	
	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public String getPhoto() {
		return photo;
	}
	public void regCourse(Tutorclass cl){
		Tutorclass c = new Tutorclass(cl.getName(),cl.getCode(),cl.getDuration(),cl.getNumberofstudent());
		course.add(c);
	}
	public int  addPoint(){
		this.point += 10;
		setPoint(point);
		
		return point;
	}
	public int setPoint(int point) {
		this.point = point;
		
		return point;
	}
	public int getPoint(){
		return point;
	}
	public boolean getCheck(){
		return check;
	}
	public void setCheck(boolean a ){
		this.check = a;
	}


}
