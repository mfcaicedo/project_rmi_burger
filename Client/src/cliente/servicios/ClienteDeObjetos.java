package cliente.servicios;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import server.controller.ControllerManagementBurgerInt;

public class ClienteDeObjetos
{

	private static ControllerManagementBurgerInt objRemoto;
        
	public static void main(String[] args) 
        {
            
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
            direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
            numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 
           
            objRemoto = (ControllerManagementBurgerInt) UtilidadesRegistroC.obtenerObjRemoto(
                    direccionIpRMIRegistry,numPuertoRMIRegistry, "objServiceBurger");
            Menu objMenu= new Menu(objRemoto);
            objMenu.ejecutarMenuPrincipal();
            
            
	}
	
	
	
}

