package servidor.Repositorios;

import java.util.ArrayList;
import servidor.DTO.BurgerDTO;

public class BurgerRepository implements BurgerRepositoryInt
{  
    private final ArrayList<BurgerDTO> listBurgers;
    
    public BurgerRepository()
    {
        this.listBurgers= new ArrayList();
    }

    private BurgerDTO calculatePrice(BurgerDTO objBurger){
        ValuesDefault objValues;
        //calculo el precio de la hamburguesa
        float price = 0.0f;
        switch (objBurger.getSizeBurger().toLowerCase()){
            case "pequeño":
                objBurger.setPrice(ValuesDefault.SMALL.getPrice() +
                        ValuesDefault.EXTRA.getPrice() * objBurger.getExtraAmount());
                break;
            case "mediana":
                objBurger.setPrice(ValuesDefault.MEDIUM.getPrice() +
                        ValuesDefault.EXTRA.getPrice() * objBurger.getExtraAmount());
                break;
            case "grande":
                objBurger.setPrice(ValuesDefault.BIG.getPrice() +
                        ValuesDefault.EXTRA.getPrice() * objBurger.getExtraAmount());
                break;
        }
        return objBurger;
    }
    @Override
    public boolean registerBurger(BurgerDTO objBurger) {
        boolean flag;
        objBurger = calculatePrice(objBurger);
        //impresion de datos
        System.out.println("Hamburguesa registrada: " + objBurger.getId());
        System.out.println("Ingredientes extras: " + objBurger.getExtraAmount());
        System.out.println("Precio: " + objBurger.getPrice());
        flag = this.listBurgers.add(objBurger);
        return flag;
    }
}
