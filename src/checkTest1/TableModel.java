package checkTest1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TableModel extends javax.swing.table.AbstractTableModel implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String[] columnTitle={"CID","Title","Room","Participance","Starttime","Endtime"};
	@SuppressWarnings("rawtypes")
	protected Vector data=new Vector(1000,200);;
	private ResultSet r;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TableModel(ResultSet rs)
	{
		try
		{
			
			r=rs;
			
			
			while(r.next())
			{
				
				Vector row =new Vector(30);
				for(int index=1;index<=6;index++)
				{
					row.addElement(r.getObject(index));
					
				}
				
				 row.trimToSize();
				 data.addElement(row);
				 System.out.println(data.size());
			}

			 data.trimToSize();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnTitle.length;
	}
	
	public String getColumnName(int col)
	{
		return columnTitle[col];
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector) data.elementAt(rowIndex)).elementAt(columnIndex);
	}

}
