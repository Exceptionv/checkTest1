package checkTest1;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;



@SuppressWarnings("unused")
public class serverImplemention<PrepareStatement> extends java.rmi.server.UnicastRemoteObject implements RomoteCallInterface ,java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**2017.4.20 log:connect DB BespeakConference to implement sign up
	 * 2017.4.21 log:connect DB BespeakConference to implement sign in
	 */
	
	
	//DB connect object
	private String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=BespeakConference";
	private String userName="sa";
	private String userPwd="847032540";
	private Connection dbConn;
	
	//current user object
	static String currentUserName;
	static String currentUserPassword;
	
	
	
	
	protected serverImplemention() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		//connect DB
		try 
		{
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("successful");
		}
		catch(Exception edb)
		{  
			System.out.println("cannot connect DB!");
			edb.printStackTrace();
		}
		
	}
	
	
	
	
	
	private Object[][] getQueryResult(ResultSet rs) throws Exception {
		   
		   int row=rs.getRow();
		  

	       Object[][] objRowCol=new Object[50][6];
	       int rowcount=0;
	       
	      
	       while(rs.next())
			{
	    	   for(int index=1;index<=6;index++)
				    {
				    	objRowCol[rowcount][index-1]= rs.getObject(index);
					}
				    
				    
				rowcount++;
	    	   
	    	   
				
			}
				
	        return objRowCol;
	        

	    }

	@Override
	
    public String signUp(String username,String password) throws RemoteException {
		// TODO Auto-generated method stub
		
		String registerReminding = "Error!"; 
				
		
		try
		{
			
			CallableStatement  cstmt = dbConn.prepareCall("{?=call dbo.Pro_createaccount(?,?)}");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setNString(2,  username);
			cstmt.setNString(3, password);
			cstmt.execute();
			
			if(cstmt.getInt(1)==1)
			{
				System.out.println("REGISTER SUCCESS!");
				registerReminding="REGISTER SUCCESS!";
			}
			if(cstmt.getInt(1)==0)
			{
				System.out.println("Name Conflict!");
				registerReminding="Name Conflict!";
			}
        }

		catch(java.sql.SQLException ecre)
		{
			System.out.println("Cannot connect DB!");
			registerReminding="Cannot connect DB!";
			ecre.printStackTrace();
		}
		
		return registerReminding;
	}

	@Override
	
	
	public String signIn(String currentUsername, String currentPassword) throws RemoteException {
		String signInReminding="Error!";
		
		try
		{
			
			CallableStatement  cstmt = dbConn.prepareCall("{?=call dbo.Pro_userSignIn(?,?)}");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setNString(2,  currentUsername);
			cstmt.setNString(3, currentPassword);
			cstmt.execute();
			
			if(cstmt.getInt(1)==1)
			{
				System.out.println("Wrong password!");
				signInReminding="Wrong password!";
			}
			if(cstmt.getInt(1)==0)
			{
				currentUserName=currentUsername;
				currentUserPassword=currentPassword;
				signInReminding="Welcome";
			}
        }

		catch(java.sql.SQLException esig)
		{
			System.out.println("Cannot connect DB!");
			signInReminding="Cannot connect DB!";
			esig.printStackTrace();
		}
		
		
		return signInReminding;
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("null")
	@Override
    public Object[][] inquire(String starttime, String endtime) throws Exception {
		 //TableModel result = null;
		 ResultSet rs = null;
		 Object[][] result = null;
		  
		  
		  
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		  Date dateS = df.parse(starttime);
		  Timestamp st = new Timestamp(dateS.getTime());
		  
		  Date dateE = df.parse(endtime);
		  Timestamp et = new Timestamp(dateE.getTime());
	     
	      try
	      {
	    	  PreparedStatement pstmt = dbConn.prepareStatement("{call dbo.Pro_inquiring(?,?,?)}");
	    	  System.out.println(currentUserName);
			  
	    	  pstmt.setNString(1, currentUserName);
			  pstmt.setTimestamp(2,st );
			  pstmt.setTimestamp(3,et);
			  rs = pstmt.executeQuery();
			  if(rs.next())
               {result=getQueryResult(rs);}
			 
              System.out.println("a");
			 
			 }
			  
			  
	      catch (SQLException e)
	      {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	      
	     
		return  result;
	}

	
	
	@Override
	
	public String New(String cid, String title, String rid, String partic, String starttime, String endtime)
			throws RemoteException, ParseException {
		String newReminding="Error!";
		
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dateS = df.parse(starttime);
		Timestamp st = new Timestamp(dateS.getTime());
		  
		Date dateE = df.parse(endtime);
		Timestamp et = new Timestamp(dateE.getTime());
		try
		{
			CallableStatement  cstmt = dbConn.prepareCall("{?=call dbo.Pro_inserting(?,?,?,?,?,?)}");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setNString(2, cid);
			cstmt.setTimestamp(3, st);
			cstmt.setTimestamp(4, et);
			cstmt.setNString(5, title);
			cstmt.setNString(6, rid);
			cstmt.setNString(7, partic);
			cstmt.execute();
			
			if(cstmt.getInt(1)==1)
			{
				System.out.println("logic error");
				newReminding="logic error!";
			}
			if(cstmt.getInt(1)==2)
			{
				System.out.println("conflict!");
				newReminding="conflict!";
			}
			if(cstmt.getInt(1)==0)
			{
				System.out.println("Insert success!");
				newReminding="Insert success!";
			}
		}
		
		catch(java.sql.SQLException esig)
		{
			System.out.println("Cannot connect DB!");
			newReminding="Cannot connect DB!";
			esig.printStackTrace();
		}
		
		return newReminding;
	}

	@Override
	public String delete(String Username, String password,String cid) throws RemoteException {
		// TODO Auto-generated method stub
		String deleteReminding="error!";
		
		try
		{
			CallableStatement  cstmt = dbConn.prepareCall("{?=call dbo.Pro_delete(?,?,?)}");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setNString(2,  Username);
			cstmt.setNString(3, password);
			cstmt.setNString(4, cid);
			cstmt.execute();
			if(cstmt.getInt(1)==1)
			{
				System.out.println("wrong identity!");
				deleteReminding="wrong identity!";
			}
			if(cstmt.getInt(1)==0)
			{
				System.out.println("success!");
				deleteReminding="success!";
			}
		}
		catch(java.sql.SQLException ecre)
		{
			System.out.println("Cannot connect DB!");
			deleteReminding="Cannot connect DB!";
			ecre.printStackTrace();
		}
		
		return deleteReminding;
				
		
	}

}
