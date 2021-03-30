package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





import logic.Student;

import logic.University;


public class ViewAllStudent extends JFrame implements ActionListener {
	private LecturerMainMenu prevScreen;
		
	private JButton btnBack ;
	
	private ArrayList<Student> studentList;
	private JButton[] btnList;
	
	
	public ViewAllStudent(LecturerMainMenu prevScreen, University uni) {
		this.prevScreen = prevScreen;
		
		studentList = uni.getAllStudent();
		
		btnList = new JButton[studentList.size()];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Student Screen");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("List of Student:"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(studentList.size(), 1));
		
		System.out.println(studentList.size());
		btnBack = new JButton("Back"); 
		for (int i=0; i<studentList.size(); i++) {
			Student s = studentList.get(i);
			String label = s.getName();			
			
			JButton btnView = new JButton(label);
			
			btnView.addActionListener(this);
			btnList[i] = btnView;
			
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			p.add(new JLabel((i+1)+"."));
			p.add(btnView);
			
			p2.add(p);
		}
			
			JPanel p3 = new JPanel();
			p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
			p3.add(btnBack);
			
			pane.add(p1, BorderLayout.NORTH);
			pane.add(p2, BorderLayout.CENTER);
			pane.add(p3, BorderLayout.SOUTH);
			
			btnBack.addActionListener(this);
		
	}
	


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	Object obj = e.getSource();
		
		if (obj == btnBack) {
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
		
		else {
			for (int i=0; i<btnList.length; i++) {
				if (obj == btnList[i]) {
					Student s = studentList.get(i);
					
					this.setVisible(false);
					new ViewStudentDetail(this, s);
				}
			}	
		}
	}
	}


