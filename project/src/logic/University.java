package logic;

import java.util.ArrayList;

import data.DatabaseManager;
import data.TempLecturerRecord;

import data.TempStudentRecord;

public class University {
	private String name;
	private Lecturer lecturer;
	private Student student;
	private ArrayList <Tutorclass> tutorclassList = new ArrayList <Tutorclass>(); 
	private DatabaseManager db = new DatabaseManager();
	
	public University(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isValidLecturer(String id, String pwd) {
		return db.verifyLecturer(id, pwd);
	}
	
	public Lecturer getLecturer(String id, String pwd) {
		TempLecturerRecord tempLecturer = db.getLecturer(id, pwd);
		lecturer = new Lecturer(tempLecturer.getLecturerID(), tempLecturer.getName(), tempLecturer.getPassword());
		return lecturer;
	}
	public boolean isValidStudent(String id, String pwd) {
		return db.verifyStudent(id, pwd);
	}
	
	public Student getStudent(String id, String pwd) {
		TempStudentRecord tempStudent = db.getStudent(id, pwd);
		student = new Student(tempStudent.getStudentID(), tempStudent.getName(), tempStudent.getPassword(), tempStudent.getPhoto(),tempStudent.getPoint());
		return student;
		
	}
	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		ArrayList<TempStudentRecord> studentRegister = db.getAllStudent();
		
		for (TempStudentRecord tempStudent : studentRegister) {
			Student student = new Student(tempStudent.getStudentID(), tempStudent.getName(), tempStudent.getPassword(), tempStudent.getPhoto(),tempStudent.getPoint());
			studentList.add(student);
		}
		
		return studentList;		
	}
	
	public ArrayList <Tutorclass> getTutorClass(){
		
		return tutorclassList;
	}
	public void createClass(String name , String code , String duration ,int number ){
		Tutorclass c = new Tutorclass(name , code , duration , number);
		tutorclassList.add(c);
	}
	
}
