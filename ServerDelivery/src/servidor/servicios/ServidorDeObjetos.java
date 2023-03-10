/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;


import server.controller.ControladorGestorRespaldoInt;
import servidor.utilidades.UtilidadesRegistroC;
import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.BurgerRepository;
import server.controller.ControllerManagementNotificationsImpl;
import server.controller.ControllerManagementBurgerImpl;


public class ServidorDeObjetos
{

    //creo el objeto remoto de la interfaz ControladorGestorRespaldoInt
    private static ControladorGestorRespaldoInt objRemoto;
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        BurgerRepository objRepository = new BurgerRepository();
        ControllerManagementNotificationsImpl objRemoteCooks = new ControllerManagementNotificationsImpl();

        //consulto el objRemoto del servidor de respaldo
        //objRemoto = (ControladorGestorRespaldoInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
          //      2021, "objServicioGestionRespaldo");

        ControllerManagementBurgerImpl objRemoteBurger = new ControllerManagementBurgerImpl(
                objRepository, objRemoteCooks);

        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoteBurger, direccionIpRMIRegistry,
                   numPuertoRMIRegistry, "objServiceBurger");
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoteCooks,
                   direccionIpRMIRegistry, numPuertoRMIRegistry,
                   "objServiceCook");

        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
