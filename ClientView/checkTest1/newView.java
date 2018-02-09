package checkTest1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class newView {

	JFrame frame;
	private JTextField textFiled_cid;
	private JTextField textField_participant;
	private JTextField textField_title;

	
	/**
	 * Create the application.
	 */
	public newView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 655, 268);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConferenceId = new JLabel("conference id\uFF1A");
		lblConferenceId.setBounds(10, 10, 101, 15);
		panel.add(lblConferenceId);
		
		textFiled_cid = new JTextField();
		textFiled_cid.setBounds(156, 7, 66, 21);
		panel.add(textFiled_cid);
		textFiled_cid.setColumns(10);
		
		JLabel lblParticipant = new JLabel("participant\uFF1A");
		lblParticipant.setBounds(334, 10, 89, 15);
		panel.add(lblParticipant);
		
		textField_participant = new JTextField();
		textField_participant.setBounds(456, 7, 66, 21);
		panel.add(textField_participant);
		textField_participant.setColumns(10);
		
		JLabel lblRoom = new JLabel("Room:");
		lblRoom.setBounds(10, 59, 54, 15);
		panel.add(lblRoom);
		
		JComboBox Room = new JComboBox();
		Room.setBounds(156, 56, 66, 21);
		for(int n = 001; n <005 ; n++)
		      Room.addItem(Integer.toString(n));
		panel.add(Room);
		
		JLabel lblTitle = new JLabel("title:");
		lblTitle.setBounds(334, 59, 54, 15);
		panel.add(lblTitle);
		
		textField_title = new JTextField();
		textField_title.setBounds(456, 56, 66, 21);
		panel.add(textField_title);
		textField_title.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 129, 635, 29);
		panel.add(panel_1);
		
		JLabel lblStarttime = new JLabel("startTime:");
		lblStarttime.setBounds(0, 0, 75, 29);
		panel_1.add(lblStarttime);
		
		JComboBox startYear = new JComboBox();
		startYear.setBounds(65, 0, 61, 29);
		for(int i = 2007; i < 2018; i++)
		      startYear.addItem(Integer.toString(i));
		panel_1.add(startYear);
		
		JLabel label_6 = new JLabel("year");
		label_6.setBounds(136, 0, 38, 29);
		panel_1.add(label_6);
		
		JComboBox startMonth = new JComboBox();
		startMonth.setBounds(179, 0, 52, 29);
		for(int j = 1; j < 13; j++)
			startMonth.addItem(Integer.toString(j));
		panel_1.add(startMonth);
		
		JLabel label_7 = new JLabel("month");
		label_7.setBounds(236, 0, 52, 29);
		panel_1.add(label_7);
		
		JComboBox startDay = new JComboBox();
		startDay.setBounds(293, 0, 52, 29);
		for(int j = 1; j < 32; j++)
			startDay.addItem(Integer.toString(j));
		panel_1.add(startDay);
		
		JLabel label_8 = new JLabel("day");
		label_8.setBounds(350, 0, 52, 29);
		panel_1.add(label_8);
		
		JComboBox startHour = new JComboBox();
		startHour.setBounds(407, 0, 52, 29);
		for(int j = 00; j < 25; j++)
			startHour.addItem(Integer.toString(j));
		panel_1.add(startHour);
		
		JLabel label_9 = new JLabel("hour");
		label_9.setBounds(464, 0, 52, 29);
		
		panel_1.add(label_9);
		
		JComboBox startMinute = new JComboBox();
		startMinute.setBounds(521, 0, 52, 29);
		for(int j = 00; j < 61; j++)
			startMinute.addItem(Integer.toString(j));
		panel_1.add(startMinute);
		
		JLabel label_10 = new JLabel("minute");
		label_10.setBounds(578, 0, 57, 29);
		panel_1.add(label_10);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 179, 635, 29);
		panel.add(panel_2);
		
		JLabel lblEndtime = new JLabel("endTime:");
		lblEndtime.setBounds(0, 0, 60, 29);
		panel_2.add(lblEndtime);
		
		JComboBox endYear = new JComboBox();
		endYear.setBounds(64, 0, 60, 29);
		for(int n = 2007; n < 2018; n++)
		      endYear.addItem(Integer.toString(n));
		panel_2.add(endYear);
		
		JLabel label_1 = new JLabel("year");
		label_1.setBounds(134, 0, 40, 29);
		panel_2.add(label_1);
		
		JComboBox endMonth = new JComboBox();
		endMonth.setBounds(179, 0, 52, 29);
		for(int k = 1; k < 13; k++)
		      endMonth.addItem(Integer.toString(k));
		panel_2.add(endMonth);
		
		JLabel label_2 = new JLabel("month");
		label_2.setBounds(236, 0, 52, 29);
		panel_2.add(label_2);
		
		JComboBox endDay = new JComboBox();
		endDay.setBounds(293, 0, 52, 29);
		for(int n = 1; n < 32; n++)
		      endDay.addItem(Integer.toString(n));
		panel_2.add(endDay);
		
		JLabel label_3 = new JLabel("day");
		label_3.setBounds(350, 0, 52, 29);
		panel_2.add(label_3);
		
		JComboBox endHour = new JComboBox();
		endHour.setBounds(407, 0, 52, 29);
		for(int n = 00; n < 25; n++)
		      endHour.addItem(Integer.toString(n));
		panel_2.add(endHour);
		
		JLabel label_4 = new JLabel("hour");
		label_4.setBounds(464, 0, 52, 29);
		panel_2.add(label_4);
		
		JComboBox endMinute = new JComboBox();
		endMinute.setBounds(521, 0, 52, 29);
		for(int n = 00; n < 25; n++)
		      endMinute.addItem(Integer.toString(n));
		panel_2.add(endMinute);
		
		JLabel label_5 = new JLabel("minute");
		label_5.setBounds(578, 0, 57, 29);
		panel_2.add(label_5);
		
		JLabel lblReminding = new JLabel("New label");
		lblReminding.setBounds(279, 346, 93, 30);
		frame.getContentPane().add(lblReminding);
		
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Starttime=(String) startYear.getSelectedItem()+"-"+startMonth.getSelectedItem()+"-"+startDay.getSelectedItem()+" "+startHour.getSelectedItem()+":"+startMinute.getSelectedItem();
				String Endtime=(String) endYear.getSelectedItem()+"-"+endMonth.getSelectedItem()+"-"+endDay.getSelectedItem()+" "+endHour.getSelectedItem()+":"+endMinute.getSelectedItem();
				String cid=textFiled_cid .getText();
				String title=textField_title.getText();
				String rid=(String)"00"+Room.getSelectedItem();
				String partic=textField_participant.getText();
				
				String Reminding=null;
				
				try
				{
					RomoteCallInterface New=(RomoteCallInterface)Naming.lookup("rmi://localhost:7029/server");
					Reminding=New.New(cid, title, rid, partic, Starttime, Endtime);
					lblReminding.setText(Reminding);
					
					
				} 
				catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNew.setBounds(279, 288, 93, 23);
		frame.getContentPane().add(btnNew);
	}
}
