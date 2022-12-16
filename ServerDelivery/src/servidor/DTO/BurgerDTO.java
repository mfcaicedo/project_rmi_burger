package servidor.DTO;

import java.io.Serializable;

public class BurgerDTO implements Serializable
{	
    private String id;
    private String sizeBurger;
    private int extraAmount;
    private float price;

    public BurgerDTO(String id, String sizeBurger, int extraAmount, float price) {
        this.id = id;
        this.sizeBurger = sizeBurger;
        this.extraAmount = extraAmount;
        this.price = price;

    }
    public BurgerDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSizeBurger() {
        return sizeBurger;
    }

    public void setSizeBurger(String sizeBurger) {
        this.sizeBurger = sizeBurger;
    }

    public int getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(int extraAmount) {
        this.extraAmount = extraAmount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
