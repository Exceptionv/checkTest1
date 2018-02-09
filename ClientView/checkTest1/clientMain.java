package checkTest1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class clientMain {

	JFrame frame;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private JTextField textField_U;
	private JTextField textField_P;



	/**
	 * Create the application.
	 */
	public clientMain() {
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
		panel_1.setBounds(50, 68, 334, 103);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setBounds(6, 26, 65, 15);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(6, 66, 70, 15);
		panel_1.add(lblPassword);
		
		textField_U = new JTextField();
		textField_U.setBounds(70, 23, 189, 21);
		panel_1.add(textField_U);
		textField_U.setColumns(10);
		
		textField_P = new JTextField();
		textField_P.setBounds(70, 63, 189, 21);
		panel_1.add(textField_P);
		textField_P.setColumns(10);
		panel.setBounds(50, 172, 334, 45);
		frame.getContentPane().add(panel);
		
		JLabel lblBespeckConferenceSystem = new JLabel("Bespeck Conference System");
		lblBespeckConferenceSystem.setBounds(131, 26, 174, 32);
		frame.getContentPane().add(lblBespeckConferenceSystem);
		
		JLabel lblSignInReminding = new JLabel("");
		lblSignInReminding.setBounds(175, 227, 105, 25);
		frame.getContentPane().add(lblSignInReminding);
		
		JButton btnSignin = new JButton("SignIn");
		
		
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField_U.getText();
				String password=textField_P.getText();
				String reminding=null;
                String a="Welcome";
				try {
					RomoteCallInterface signin=(RomoteCallInterface)Naming.lookup("rmi://localhost:7029/server");
					reminding=signin.signIn(username,password);
					
					if(reminding.equals(a))
					{
						System.out.println(reminding);
						clientMainView window = new clientMainView();
						window.frame.setVisible(true);
					}
					
					
					lblSignInReminding.setText(reminding);
					
				
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
		panel.add(btnSignin);
		
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientSignUp su = new clientSignUp();
				su.frame.setVisible(true);
				
			}
		});
		panel.add(btnSignup);
		
		
	}
}
