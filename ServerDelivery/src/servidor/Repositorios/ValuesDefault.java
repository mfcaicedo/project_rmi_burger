package servidor.Repositorios;

public enum ValuesDefault {
    SMALL(14000), MEDIUM(16000), BIG(20000), EXTRA(3000);
    private final int price;
    ValuesDefault(int v){price = v;}
    int getPrice(){return price;}
}
