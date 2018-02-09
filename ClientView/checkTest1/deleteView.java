package checkTest1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class deleteView {

	JFrame frame;
	private JPasswordField passwordField_P;
	private JTextField textField_U;
	private JTextField textField_C;

	
	/**
	 * Create the application.
	 */
	public deleteView() {
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
		panel.setBounds(62, 10, 310, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("please certify your identity:");
		lblNewLabel.setBounds(10, 10, 215, 15);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 42, 54, 15);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 81, 54, 15);
		panel.add(lblPassword);
		
		passwordField_P = new JPasswordField();
		passwordField_P.setBounds(110, 78, 174, 21);
		panel.add(passwordField_P);
		
		textField_U = new JTextField();
		textField_U.setBounds(110, 39, 174, 21);
		panel.add(textField_U);
		textField_U.setColumns(10);
		
		JLabel lblCid = new JLabel("Cid:");
		lblCid.setBounds(10, 126, 54, 15);
		panel.add(lblCid);
		
		textField_C = new JTextField();
		textField_C.setBounds(110, 120, 174, 21);
		panel.add(textField_C);
		textField_C.setColumns(10);
		
		JLabel lblReminding = new JLabel("");
		lblReminding.setBounds(162, 219, 93, 15);
		frame.getContentPane().add(lblReminding);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String User=textField_U.getText();
				
				@SuppressWarnings("deprecation")
				String Password=passwordField_P.getText();
				String Cid=textField_C.getText();
				
                String Reminding=null;
				
				try
				{
					RomoteCallInterface delete=(RomoteCallInterface)Naming.lookup("rmi://localhost:7029/server");
					Reminding=delete.delete(User, Password, Cid);
					
					lblReminding.setText(Reminding);
					
					
				} 
				catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} /*catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		btnYes.setBounds(162, 172, 93, 23);
		frame.getContentPane().add(btnYes);
		
	
	}
}
