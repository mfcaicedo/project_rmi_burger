package server.controller;

import cliente.controladores.CookCallbackInt;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ControllerManagementNotificationsInt extends Remote{
    public void registerReferenceCook(CookCallbackInt objReferencia) throws RemoteException;
}
