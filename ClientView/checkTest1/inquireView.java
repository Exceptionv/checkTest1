package checkTest1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.text.ParseException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;



@SuppressWarnings("unused")
public class inquireView implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	JFrame frame;
	
	
	private Object[][] result;
	
	private JTable tableResult;
	

	
	/**
	 * Create the application.
	 */
	public inquireView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 773, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 48, 737, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStarttime = new JLabel(" StartTime:");
		lblStarttime.setBounds(10, 31, 80, 24);
		panel.add(lblStarttime);
		
		JLabel lblEndtime = new JLabel(" EndTime:");
		lblEndtime.setBounds(10, 73, 65, 36);
		panel.add(lblEndtime);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 22, 650, 33);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JComboBox startYear = new JComboBox();
		 for(int i = 2007; i < 2018; i++)
		      startYear.addItem(Integer.toString(i));
		panel_1.add(startYear);
		
		JLabel lblYear = new JLabel("year");
		panel_1.add(lblYear);
		
		
		JComboBox startMonth = new JComboBox();
		for(int j = 1; j < 13; j++)
			startMonth.addItem(Integer.toString(j));
		panel_1.add(startMonth);
		
		JLabel lblMonth = new JLabel("month");
		panel_1.add(lblMonth);
		
		
		JComboBox startDay = new JComboBox();
		for(int k = 1; k < 32; k++)
		      startDay.addItem(Integer.toString(k));
		panel_1.add(startDay);
		
		JLabel lblDay = new JLabel("day");
		panel_1.add(lblDay);
		
		JComboBox startHours = new JComboBox();
		for(int n = 00; n < 25; n++)
		      startHours.addItem(Integer.toString(n));
		panel_1.add(startHours);
		
		JLabel lblHours = new JLabel("hours");
		panel_1.add(lblHours);
		
		JComboBox startMinute = new JComboBox();
		for(int n = 00; n < 61; n++)
		      startMinute.addItem(Integer.toString(n));
		panel_1.add(startMinute);
		
		JLabel lblMinute = new JLabel("minute");
		panel_1.add(lblMinute);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(77, 76, 650, 33);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JComboBox endYear = new JComboBox();
		for(int n = 2007; n < 2018; n++)
		      endYear.addItem(Integer.toString(n));
		panel_2.add(endYear);
		
		JLabel lblNewLabel = new JLabel("year");
		panel_2.add(lblNewLabel);
		
		JComboBox endMonth = new JComboBox();
		for(int k = 1; k < 13; k++)
		      endMonth.addItem(Integer.toString(k));
		panel_2.add(endMonth);
		
		JLabel lblMonth_1 = new JLabel("month");
		panel_2.add(lblMonth_1);
		
		JComboBox endDay = new JComboBox();
		for(int n = 1; n < 32; n++)
		      endDay.addItem(Integer.toString(n));
		panel_2.add(endDay);
		
		JLabel lblDay_1 = new JLabel("day");
		panel_2.add(lblDay_1);
		
		JComboBox endHours = new JComboBox();
		for(int n = 00; n < 25; n++)
		      endHours.addItem(Integer.toString(n));
		panel_2.add(endHours);
		
		JLabel lblHours_1 = new JLabel("hours");
		panel_2.add(lblHours_1);
		
		JComboBox endMinute = new JComboBox();
		for(int n = 00; n < 25; n++)
		      endMinute.addItem(Integer.toString(n));
		panel_2.add(endMinute);
		
		JLabel lblMinute_1 = new JLabel("minute");
		panel_2.add(lblMinute_1);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 224, 737, 285);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Result", null, scrollPane, null);
		
		
		
		
		
		
		
		
		
		JButton btnInqiure = new JButton("inquire");
		btnInqiure.setBounds(315, 197, 93, 23);
		btnInqiure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Starttime=(String) startYear.getSelectedItem()+"-"+startMonth.getSelectedItem()+"-"+startDay.getSelectedItem()+" "+startHours.getSelectedItem()+":"+startMinute.getSelectedItem();
				String Endtime=(String) endYear.getSelectedItem()+"-"+endMonth.getSelectedItem()+"-"+endDay.getSelectedItem()+" "+endHours.getSelectedItem()+":"+endMinute.getSelectedItem();
				
				try {
					RomoteCallInterface inquire=(RomoteCallInterface)Naming.lookup("rmi://localhost:7029/server");
					result=inquire.inquire(Starttime, Endtime);
					
					 
					String title[]={"Cid","Title","Room","participate","startTime","endTime"};
					DefaultTableModel model=new DefaultTableModel(result,title);
					

					 
					
					 
					 tableResult = new JTable(model);     //×Ö¶ÎÃû³Æ
					  
					 scrollPane.setColumnHeaderView(tableResult);
					 
					
					
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		frame.getContentPane().add(btnInqiure);
		
		

		
		
		
		
		
		
		
		
	}
}
