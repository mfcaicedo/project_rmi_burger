package server.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.BurgerDTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControllerManagementBurgerInt extends Remote
{
    /**
     * Metodo para registrar una hamburguesa en el sistema
     * @param objBurger objeto con los datos de la hamburguesa
     * @return true en caso de ser correcto y false en caso contrario
     * @throws RemoteException para tratar la excepcion de RMI
     */
   public boolean registerBurger(BurgerDTO objBurger)  throws RemoteException;

}
