package checkTest1;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class checkServer {

	public static void main(String[] args)  {
		try
		{
			@SuppressWarnings("rawtypes")
			serverImplemention server =new serverImplemention();
			LocateRegistry.createRegistry(7029);
			Naming.bind("rmi://localhost:7029/server", server);
		}catch(RemoteException e){
			System.out.println("RemoteException");
			e.printStackTrace();
			
		} catch (MalformedURLException eURL) {
			// TODO Auto-generated catch block
			eURL.printStackTrace();
		} catch (AlreadyBoundException eABE) {
			// TODO Auto-generated catch block
			eABE.printStackTrace();
		}
		
}
		
	

}
