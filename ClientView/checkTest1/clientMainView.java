package checkTest1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class clientMainView {

	JFrame frame;


	/**
	 * Create the application.
	 */
	public clientMainView() {
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
		panel.setBounds(42, 33, 351, 193);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnInquire = new JButton("Inquire");
		btnInquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inquireView window = new inquireView();
				window.frame.setVisible(true);
			}
		});
		panel.add(btnInquire);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newView window = new newView();
				window.frame.setVisible(true);
			}
		});
		panel.add(btnNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteView window = new deleteView();
				window.frame.setVisible(true);
			}
		});
		panel.add(btnDelete);
	}
}
