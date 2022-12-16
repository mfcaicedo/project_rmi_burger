/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;


import server.controller.ControladorGestorRespaldoImpl;
import server.controller.ControladorGestorRespaldoInt;
import servidor.utilidades.UtilidadesRegistroS;

import java.rmi.RemoteException;

import servidor.Repositorios.CancionRepository;


public class StartServer {
    private static ControladorGestorRespaldoInt objRemoto;
    public static void main(String args[]) throws RemoteException {

        System.out.println("iniciar servidor");

    }
}
