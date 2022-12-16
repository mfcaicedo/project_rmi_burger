package cliente.servicios;


import cliente.controladores.CookCallbackImpl;
import cliente.utilidades.UtilidadesRegistroC;
import server.controller.ControllerManagementNotificationsInt;

import java.rmi.RemoteException;


public class ClienteDeObjetos
{

	private static ControllerManagementNotificationsInt objRemoto;
        
	public static void main(String[] args) throws RemoteException 
        {
            
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
            direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
            numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 
           
            objRemoto = (ControllerManagementNotificationsInt) UtilidadesRegistroC.obtenerObjRemoto(
                    direccionIpRMIRegistry,numPuertoRMIRegistry, "objServiceCook");
                
            CookCallbackImpl objRemoteCook = new CookCallbackImpl();
            
            objRemoto.registerReferenceCook(objRemoteCook);
            
	}
	
	
	
}

