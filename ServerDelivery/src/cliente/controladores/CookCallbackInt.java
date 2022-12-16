

package cliente.controladores;

import servidor.DTO.BurgerDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface CookCallbackInt extends Remote
{
    public void notifyRegisterNewBurger(BurgerDTO objBurger) throws RemoteException;
}
