package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import logic.Tutorclass;
import logic.Student;


public class ViewClassDetail extends JFrame implements ActionListener {
	private ViewAllClass prevScreen;
	private ViewAllRegClass prevScreen1;
	
	private JButton btnBack = new JButton("Back");
	
	
	public ViewClassDetail(ViewAllClass prevScreen, Tutorclass tclass ,Student student) {
		this.prevScreen = prevScreen;
		
		final ArrayList<Student> attendancelist = tclass.attendancelist();
		for(Student attendance: attendancelist){
		System.out.println(attendance.getName());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Class Screen");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		JLabel title = new JLabel(" Welcome to the " + tclass.getName() + " class.", SwingConstants.CENTER);
		pane.add(title,BorderLayout.NORTH);
		
		JPanel p1 = new JPanel(new FlowLayout(150));
		JLabel name = new JLabel(" Class name : " + tclass.getName());
		JLabel duration = new JLabel( " Class Duration : " + tclass.getDuration());
		JLabel code = new JLabel (" Class Code : " + tclass.getSecretCode());
		p1.add(name);
		p1.add(duration);
		p1.add(code);
		
		JPanel p2 = new JPanel();
		JLabel attend = new JLabel("Students that had attend the class : " );
		p2.add(attend);
		for(Student attendance: attendancelist){
			JLabel l1 = new JLabel(attendance.getName());
			p2.add(l1);
			}
			
		JPanel p0 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p0.add(p1,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 0;
		c.gridheight = 0;
		p0.add(p2,c);
		
		JPanel p4 = new JPanel(new FlowLayout());
		p4.add(btnBack,SwingConstants.CENTER);
		
		pane.add(p0,BorderLayout.CENTER);
		pane.add(p4, BorderLayout.SOUTH);
		btnBack.addActionListener(this);
		
		

		
		
	}
	
	public ViewClassDetail(ViewAllRegClass prevScreen, Tutorclass c) {
		// TODO Auto-generated constructor stub
		this.prevScreen1 = prevScreen;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Class Screen");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
			
		JPanel p2 = new JPanel();
		p2.add(new JLabel(c.getName()));
		p2.add(new JLabel(c.getSecretCode()));
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p3.add(btnBack);
		
		
		pane.add(p2, BorderLayout.CENTER);
		pane.add(p3, BorderLayout.SOUTH);
		
		btnBack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		prevScreen.setVisible(true);
		
		
		
	}
}
