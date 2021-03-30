package ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import logic.University;
import logic.Lecturer;

public class LecturerLoginForm extends JFrame implements ActionListener {
	private JTextField txtName = new JTextField(15);
	private JPasswordField txtPwd = new JPasswordField(15);
	private JButton btnBack = new JButton("Back"); 
	private JButton btnSubmit = new JButton("Submit"); 
	
	private MainScreen prevScreen;
	private University lecturer;
	
	public LecturerLoginForm(MainScreen prevScreen, University lecturer) {
		this.prevScreen = prevScreen;
		this.lecturer = lecturer;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lecturer User");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		
		p1.add(new JLabel("Username: "));
		p1.add(txtName);
		p1.add(new JLabel("Password: "));
		p1.add(txtPwd);
		
		JPanel p2 = new JPanel (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		p2.add(p1,c);
		
		JPanel p3 = new JPanel(new GridLayout(1,2));
		p3.add(btnBack);
		p3.add(btnSubmit);
		
		c.gridx = 0;
		c.gridy = 1;
		p2.add(p3, c);
		
		JPanel p4 = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		JLabel question = new JLabel("Please enter your username and the passsword to login. ");
		p4.add(question);
		c.gridx = 0;
		c.gridy = 1;
		p4.add(p2, c);	
		
		JLabel title = new JLabel("Welcome to the Attendance Analyser",SwingConstants.CENTER);
		pane.add(title,BorderLayout.NORTH);
		pane.add(p4, BorderLayout.CENTER);
		
		btnBack.addActionListener(this);
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnBack) {
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
		
		else {
			String username = txtName.getText();
			String password = txtPwd.getText();
					
			if (lecturer.isValidLecturer(username, password)) {	
				Lecturer theLecturer = lecturer.getLecturer(username, password);
				
				this.setVisible(false);
				new LecturerMainMenu(lecturer, theLecturer, prevScreen);
			}
			
			else
				JOptionPane.showMessageDialog(this, "Wrong ID or password"  ,"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}