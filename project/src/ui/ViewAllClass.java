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




import logic.Tutorclass;
import logic.University;
import logic.Student;


public class ViewAllClass extends JFrame implements ActionListener {
	private LecturerMainMenu prevScreen;
		
	private JButton btnBack ;
	
	private ArrayList<Tutorclass> tutorclassList;
	private JButton[] btnList;
	private Student s;
	
	public ViewAllClass(LecturerMainMenu prevScreen, University uni) {
		this.prevScreen = prevScreen;
		
		tutorclassList = uni.getTutorClass();
		
		btnList = new JButton[tutorclassList.size()];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Class Screen");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("List of Class:"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(tutorclassList.size(), 1));
		
		System.out.println(tutorclassList.size());
		btnBack = new JButton("Back"); 
		for (int i=0; i<tutorclassList.size(); i++) {
			Tutorclass c = tutorclassList.get(i);
			String label = c.getName();			
			
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
					Tutorclass c = tutorclassList.get(i);
					
					this.setVisible(false);
					new ViewClassDetail(this, c, s);
				}
			}	
		}
	}
	}


