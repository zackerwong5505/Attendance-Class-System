package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


import logic.Student;
import logic.University;




public class ViewStudentDetail extends JFrame  implements ActionListener {
	
	private ViewAllStudent prevScreen;
	private JPanel contentPane;
	private University uni;
	private JButton btnBack = new JButton("Back");
	private Student student;
	
	public ViewStudentDetail(ViewAllStudent prevScreen, Student student) {
		this.student = student;
		this.prevScreen = prevScreen;
		
		setTitle("Student Information");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon(student.getPhoto());
		JLabel image = new JLabel(icon);
		
		JPanel p1 = new JPanel();
		p1.add(image);
		p1.setBounds(220, 20 , 200, 200);
		contentPane.add(p1);
		
		JLabel title = new JLabel("Student Information");
		title.setBounds(70, 50, 120, 16);
		contentPane.add(title);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setBounds(54, 100, 88, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblstudentid = new JLabel();
		lblstudentid.setBounds(164, 100, 56, 16);
		contentPane.add(lblstudentid);
		lblstudentid.setText(student.getStudentID());
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setBounds(54, 140, 88, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblstudentname = new JLabel();
		lblstudentname.setBounds(164, 140, 56, 16);
		contentPane.add(lblstudentname);
		lblstudentname.setText(student.getName());
		
		JLabel lblStudentPoint = new JLabel("Student Point");
		lblStudentPoint.setBounds(54, 180, 88, 16);
		contentPane.add(lblStudentPoint);
		
		JLabel lblstudentpoint = new JLabel("");
		lblstudentpoint.setBounds(164, 180, 56, 16);
		contentPane.add(lblstudentpoint);
		lblstudentpoint.setText(String.valueOf(student.getPoint()));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(301, 230, 97, 25);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		prevScreen.setVisible(true);
	}
}
