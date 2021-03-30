package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import logic.Student;
import logic.Tutorclass;
import logic.University;

public class InsrtCode extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSubmit;
	private JLabel lblInsertCoding;
	private JTextField textField;
	private JButton btnBack;
	private University uni;
	private ViewAllRegClass prevScreen;
	private Tutorclass tclass;
	private Student student;
	

	public InsrtCode(ViewAllRegClass prevScreen,Tutorclass tclass,Student student) {
		
		this.prevScreen = prevScreen;
		this.tclass = tclass;
		this.student = student;
		
		
		setTitle("Insert Code");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 100, 450, 300);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		
		JPanel p1 = new JPanel(new GridLayout(4,1,15,15));
		JLabel secretCode = new JLabel("Secret code : " + tclass.getSecretCode(), SwingConstants.CENTER);
		JLabel lblInsertCode = new JLabel("Insert Code", SwingConstants.CENTER);
	
		textField = new JTextField();
		textField.setColumns(10);
		
		p1.add(secretCode);
		p1.add(lblInsertCode);
		p1.add(textField);
		
		JPanel p2 = new JPanel(new FlowLayout());
		
		btnSubmit = new JButton("Submit");
		btnBack = new JButton("Back");
		
		p2.add(btnSubmit);
		p2.add(btnBack);
		
		p1.add(p2);
		JPanel p3 = new JPanel(new GridBagLayout());
		p3.add(p1);
		
		
		pane.add(p3, BorderLayout.CENTER);
	
		
		btnBack.addActionListener(this);
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnBack) {
			this.setVisible(false);
			prevScreen.setVisible(true);
			
		}else if (obj == btnSubmit){
			String code = textField.getText();
			
			if(code.equals(tclass.getSecretCode().toUpperCase())){
				 student.addPoint();
				 System.out.println(student.getPoint());
				 tclass.setCheck(true);
				 JOptionPane.showMessageDialog(this, "You are success to take the attendance" + tclass.getCheck() ,"Welcome to the class", JOptionPane.INFORMATION_MESSAGE);
				 
				tclass.attendancelist().add(student);
				 
				
				 this.setVisible(false);
				 prevScreen.setVisible(true);
				 
			}
			else{
				JOptionPane.showMessageDialog(this, "Wrong Code"  ,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
			
		
	}
	
	
}
