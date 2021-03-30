package data;

import java.util.ArrayList;

public class DatabaseManager {
	
	private TempLecturerRecord lecturer;
	private TempStudentRecord student;
	private TempClassRecord tclass;
	private ArrayList <TempStudentRecord> studentlist = new ArrayList<TempStudentRecord>();
	private ArrayList <TempClassRecord> classlist = new ArrayList<TempClassRecord>();

	
	public DatabaseManager() {
		lecturer = new TempLecturerRecord("S111111", "DR.Ali", "123");
		studentlist.add(new TempStudentRecord("A111111","Victor","1234","img/b001.jpg",0));
		studentlist.add(new TempStudentRecord("A222222","Zack","1234","img/b001.jpg",0));
		studentlist.add(new TempStudentRecord("A333333","Soonfk","1234","img/b001.jpg",0));
		studentlist.add(new TempStudentRecord("A444444","Henry","1234","img/b001.jpg",0));
		studentlist.add(new TempStudentRecord("A555555","Troy","1234","img/b001.jpg",0));
		
		classlist.add(new TempClassRecord("sss","ss2","332",1));
		
		
	}
	
	public boolean verifyLecturer(String id, String pwd) {
		if (lecturer.getLecturerID().equals(id) && lecturer.getPassword().equals(pwd))
			return true;
		
		return false;
	}
	public boolean verifyStudent(String id, String pwd) {
		for( TempStudentRecord s : studentlist){
		if (s.getStudentID().equals(id) && s.getPassword().equals(pwd))
			return true;
		}
		return false;
		
	}
	
	public TempLecturerRecord getLecturer(String id, String pwd) {
		if (lecturer.getLecturerID().equals(id) && lecturer.getPassword().equals(pwd))
			return lecturer;
	
		return null;
	}
	public TempStudentRecord getStudent(String id, String pwd) {
		for( TempStudentRecord s : studentlist){
		if (s.getStudentID().equals(id) && s.getPassword().equals(pwd))
			
			return s;
		}
		return null;
	}
	public ArrayList<TempStudentRecord> getAllStudent() {
		return studentlist;
	}
	public ArrayList<TempClassRecord> getAllClass(){
		return classlist;
	}
}

