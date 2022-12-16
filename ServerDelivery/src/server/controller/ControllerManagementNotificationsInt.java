package server.controller;

import cliente.controladores.CookCallbackInt;
import java.rmi.RemoteException;
import java.rmi.Remote;


public interface ControllerManagementNotificationsInt extends Remote{
    public void registerReferenceCook(CookCallbackInt objReferencia) throws RemoteException;
}
