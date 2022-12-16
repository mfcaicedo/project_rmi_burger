

package server.controller;

import servidor.DTO.BurgerDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorRespaldoInt extends Remote
{
     public boolean registrarCancionRespaldo(BurgerDTO objBurger)  throws RemoteException;
}
