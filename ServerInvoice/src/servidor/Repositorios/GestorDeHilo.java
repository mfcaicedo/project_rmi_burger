package servidor.Repositorios;

import co.edu.unicauca.servicios.InformacionComputador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestorDeHilo extends Thread{
    private Socket objSocketCliente;
       
    public GestorDeHilo(Socket objSocket){
        this.objSocketCliente = objSocket;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("id del hilo generado:"+Thread.currentThread().getId());
            System.out.println("Atendiendo hilo de cliente");
            DataInputStream flujoEntrada;
            DataOutputStream flujoSalida;
            String message;            
            flujoEntrada=new DataInputStream(objSocketCliente.getInputStream());
            flujoSalida=new DataOutputStream(objSocketCliente.getOutputStream());
                message = flujoEntrada.readUTF();//se bloquea el servidor
                if(message.equals("caracteristicas")){
                    message = InformacionComputador.atenderPeticion();
                    flujoSalida.writeUTF(message);
                }
            
            message = InformacionComputador.atenderPeticion();                  
            if(message.equals("caracteristicas")){
                     flujoSalida.writeUTF(message);
            } 
            objSocketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
