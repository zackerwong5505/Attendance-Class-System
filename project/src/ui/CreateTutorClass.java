package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Tutorclass;
import logic.University;

public class CreateTutorClass extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_code;
	private JTextField txt_duration;
	private JTextField txt_noofstudent;
	private University uni;
	private LecturerMainMenu prevScreen;
	private JButton btn_create;
	private JButton btn_back;
	private String code;

	public CreateTutorClass(LecturerMainMenu prevScreen, University uni) {
		this.uni = uni;
		this.prevScreen = prevScreen;

		setTitle("Create a new class");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Course Name : ");
		label.setBounds(106, 32, 86, 16);
		contentPane.add(label);

		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(197, 29, 116, 22);
		contentPane.add(txt_name);

		JLabel lblCoursecode = new JLabel("Course Code : ");
		lblCoursecode.setBounds(106, 78, 86, 16);
		contentPane.add(lblCoursecode);

		txt_code = new JTextField();
		txt_code.setColumns(10);
		txt_code.setBounds(197, 75, 116, 22);
		contentPane.add(txt_code);

		JLabel lblCourseduration = new JLabel("Duration (Hours) : ");
		lblCourseduration.setBounds(85, 124, 120, 16);
		contentPane.add(lblCourseduration);

		txt_duration = new JTextField();
		txt_duration.setColumns(10);
		txt_duration.setBounds(197, 121, 116, 22);
		contentPane.add(txt_duration);

		JLabel lblNoofstudent = new JLabel("No of Students : ");
		lblNoofstudent.setBounds(95, 169, 120, 16);
		contentPane.add(lblNoofstudent);

		txt_noofstudent = new JTextField();
		txt_noofstudent.setColumns(10);
		txt_noofstudent.setBounds(197, 166, 116, 22);
		contentPane.add(txt_noofstudent);

		btn_create = new JButton("Create Class");

		
		btn_create.setBounds(90, 215, 110, 25);
		contentPane.add(btn_create);
		
		btn_back = new JButton("back");
		btn_back.setBounds(250, 215, 97, 25);
		contentPane.add(btn_back);
		btn_create.addActionListener(this);
		btn_back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj == btn_create) {
			uni.createClass(txt_name.getText(), txt_code.getText(),
					txt_duration.getText(),
					Integer.parseInt(txt_noofstudent.getText()));
			for (Tutorclass c : uni.getTutorClass()) {
				System.out.println(c.getCode());
				code = c.getSecretCode();
			}
			JOptionPane.showMessageDialog(this, "Secret Code is " +  code);
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
		if (obj == btn_back) {
			this.setVisible(false);
			prevScreen.setVisible(true);
			
		}

	}
}
