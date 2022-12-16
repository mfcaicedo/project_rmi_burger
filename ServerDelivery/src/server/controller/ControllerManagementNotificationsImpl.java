package server.controller;

import cliente.controladores.CookCallbackInt;
import servidor.DTO.BurgerDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ControllerManagementNotificationsImpl extends UnicastRemoteObject
        implements ControllerManagementNotificationsInt {

    private final List<CookCallbackInt> referencesCooks;
    
    public ControllerManagementNotificationsImpl() throws RemoteException
    {
        super();
        this.referencesCooks= new ArrayList();
    }

    @Override
    public void registerReferenceCook(CookCallbackInt objReferencia) throws RemoteException {
        this.referencesCooks.add(objReferencia);
    }
    
    public void notifyCooks(BurgerDTO objBurger)
    {
        this.referencesCooks.forEach(e->{
            try {
                e.notifyRegisterNewBurger(objBurger);
            } catch (RemoteException ex) {
                
            }
        });
    }
}
