

package server.controller;

import servidor.DTO.CancionDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorRespaldoInt extends Remote
{
     public boolean registrarCancionRespaldo(CancionDTO objCancion)  throws RemoteException;
}
