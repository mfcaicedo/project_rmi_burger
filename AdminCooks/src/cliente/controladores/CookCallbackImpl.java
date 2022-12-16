package cliente.controladores;

import servidor.DTO.BurgerDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CookCallbackImpl extends UnicastRemoteObject
        implements CookCallbackInt{
    
    public CookCallbackImpl() throws RemoteException
    {
        super();
    }

    @Override
    public void notifyRegisterNewBurger(BurgerDTO objBurger) throws RemoteException {
        System.out.println("=====Nuevo pedido=====");
        System.out.println("Hamburguesa: " + objBurger.getId());
        System.out.println("Tamaño: " + objBurger.getSizeBurger());
        System.out.println("Cantidad extras: " + objBurger.getExtraAmount());
    }
}
