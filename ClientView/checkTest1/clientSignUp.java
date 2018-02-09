package checkTest1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

import java.io.*;
import java.rmi.*;
import java.net.*;

public class clientSignUp {

	JFrame frame;
	private JTextField textField_U;
	private JTextField textField_P;

	
	/**
	 * Create the application.
	 */
	public clientSignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(75, 32, 306, 144);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(13, 22, 74, 15);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(13, 92, 74, 15);
		panel.add(lblPassword);
		
		textField_U = new JTextField();
		textField_U.setBounds(97, 19, 174, 21);
		panel.add(textField_U);
		textField_U.setColumns(10);
		
		textField_P = new JTextField();
		textField_P.setBounds(97, 89, 174, 21);
		panel.add(textField_P);
		textField_P.setColumns(10);
		
		JLabel lblwarningOfN = new JLabel("the length of your name must be under 6 ");
		lblwarningOfN.setBounds(10, 50, 259, 15);
		panel.add(lblwarningOfN);
		
		JLabel lblwarningOfP = new JLabel("the length of password must between 6 to 20");
		lblwarningOfP.setBounds(10, 117, 286, 15);
		panel.add(lblwarningOfP);
		
		JButton btnSignupNow = new JButton("SignUp Now!");
		btnSignupNow.setBounds(161, 186, 121, 23);
		frame.getContentPane().add(btnSignupNow);
		
		JLabel remindingMessage = new JLabel("");
		remindingMessage.setBounds(161, 218, 121, 23);
		frame.getContentPane().add(remindingMessage);
		
		
		btnSignupNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField_U.getText();
				String password=textField_P.getText();
				
				String reminding=null;
				
				try {
					RomoteCallInterface signup=(RomoteCallInterface)Naming.lookup("rmi://localhost:7029/server");
					reminding=signup.signUp(username,password);
					
					remindingMessage.setText(reminding);
					
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	}
}
