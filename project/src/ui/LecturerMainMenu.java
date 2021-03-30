package ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import logic.University;
import logic.Lecturer;

public class LecturerMainMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnViewAllStudent = new JButton("View All Student");
	private JButton btnCreateClass = new JButton("Create Class");
	private JButton btnViewAllClass = new JButton("View All Class");
	
	private JButton btnBack ;
	private University uni;
	private Lecturer lecturer;
	private MainScreen prevScreen;
	
	public LecturerMainMenu(University uni, Lecturer lecturer,MainScreen prevScreen) {
		this.uni = uni;
		this.lecturer = lecturer;
		this.prevScreen = prevScreen;
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lecturer Main Menu");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		btnBack = new JButton("Back"); 
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(new JLabel("Welcome back "+lecturer.getName()+"!"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1, 10, 2));
		p2.add(new JLabel("What would you like to do ?"));
		p2.add(btnViewAllStudent);
		p2.add(btnCreateClass);
		p2.add(btnViewAllClass);
		
		
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.add(p2);		
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(btnBack);
		
		pane.add(p1, BorderLayout.NORTH);
		pane.add(p3, BorderLayout.CENTER);
		pane.add(p4,BorderLayout.SOUTH);
		
		
		
		btnViewAllStudent.addActionListener(this);
		btnCreateClass.addActionListener(this);
		btnViewAllClass.addActionListener(this);
		
		btnBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnViewAllStudent) {
			this.setVisible(false);
			new ViewAllStudent (this, uni);
		}
		
		else if (obj == btnCreateClass) {
			this.setVisible(false);
			new CreateTutorClass (this, uni);
		}
		
		else if (obj == btnViewAllClass) {
			this.setVisible(false);
			new ViewAllClass(this, uni);
		}
		
		
		else if (obj == btnBack){
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
	}
}
