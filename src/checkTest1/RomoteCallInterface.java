package checkTest1;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

@SuppressWarnings("unused")
public interface RomoteCallInterface extends java.rmi.Remote{
	public String signUp(String Username,String Password) throws RemoteException;
	public String signIn(String currentUsername,String currentPassword)throws RemoteException;
	public Object[][] inquire(String starttime,String endtime)throws RemoteException,ParseException, Exception ;
	public String New(String cid,String title,String rid,String partic,String starttime,String endtime)throws RemoteException,ParseException;
	public String delete(String Username,String password,String cid)throws RemoteException;

}
