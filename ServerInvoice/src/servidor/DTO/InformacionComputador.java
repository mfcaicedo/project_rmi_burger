package servidor.DTO;

import java.util.logging.Level;
import java.util.logging.Logger;


public class InformacionComputador {
    public static String atenderPeticion(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        InformacionDTO informacion = new InformacionDTO();
        GestorPeticion peticion = new GestorPeticion();
        informacion.setNombreUsuario(peticion.getNombreUsuario());
        informacion.setDirUsuario(peticion.getDirectorioInicioUsuario());
        informacion.setProcesos(peticion.getProcesos());
        return ConversorJson.objectToJson(informacion);
    }
}
