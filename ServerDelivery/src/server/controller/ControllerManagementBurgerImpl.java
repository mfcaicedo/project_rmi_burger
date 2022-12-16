
package server.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.DTO.BurgerDTO;
import servidor.Repositorios.BurgerRepositoryInt;


public class ControllerManagementBurgerImpl extends UnicastRemoteObject
        implements ControllerManagementBurgerInt{
    
    private final BurgerRepositoryInt objBurgerRepository;
    private final ControllerManagementNotificationsImpl objReferenciaRemota;
    private final ControladorGestorRespaldoInt objRemoto;
    public ControllerManagementBurgerImpl(BurgerRepositoryInt objCancionesRepository,
                                          ControllerManagementNotificationsImpl objReferenciaRemota,
                                          ControladorGestorRespaldoInt objRemoto) throws RemoteException
    {
        super(); //se asigna un puerto de escucha al OR
        this.objBurgerRepository = objCancionesRepository;
        this.objReferenciaRemota = objReferenciaRemota;
        this.objRemoto = objRemoto;
    }

    @Override
    public boolean registerBurger(BurgerDTO objBurger) throws RemoteException {
        boolean bandera=false;
        if(this.objBurgerRepository.registerBurger(objBurger))
        {
            bandera=true;
            //Enviar la factura del pedido al servidor de facturas
            //this.objRemoto.registrarCancionRespaldo(objBurger);
            //Envio notificacion
            this.objReferenciaRemota.notifyCooks(objBurger);
        }
        
        return bandera;
    }
}
