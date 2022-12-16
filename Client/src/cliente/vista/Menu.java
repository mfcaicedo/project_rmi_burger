package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;

import servidor.DTO.BurgerDTO;
import server.controller.ControllerManagementBurgerInt;


public class Menu {

    private final ControllerManagementBurgerInt objRemoto;

    public Menu(ControllerManagementBurgerInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int option = 0;
        do {
            System.out.println("======Menu=======");
            System.out.println("1. Registrar hamburguesa");
            System.out.println("2. Salir");

            option = UtilidadesConsola.leerEntero();

            switch (option) {
                case 1:
                    Option1();
                    break;
                case 2:
                    System.out.println("Vuelve pronto");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (option != 2);
    }

    private void Option1() {
        try {
            System.out.println("Digite el nombre de la hamburguesa: ");
            String id = UtilidadesConsola.leerCadena();
            System.out.println("Digite el tamaño de la hamburguesa (pequeña, mediana, grande): ");
            String sizeBurger = UtilidadesConsola.leerCadena();
            System.out.println("Digite la cantidad de ingredientes extras: ");
            int extraAmount = UtilidadesConsola.leerEntero();

            boolean value = objRemoto.registerBurger(new BurgerDTO(id, sizeBurger, extraAmount, 0.0f));//invocación del método remoto
            if (value)
                System.out.println("Hamburguesa registrada satisfactoriamente...");
            else
                System.out.println("No se pudo realizar el registro de la hamburguesa...");
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }

}
