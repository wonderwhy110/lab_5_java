package model.products;

public class Liquid extends Product {
    private double liters;
    private String IsDanger;

    public Liquid() {
        super();
        this.liters = 0;
        this.IsDanger = "";
    }

    public Liquid(String na, double w, int i, double l, String d) {
        super(na, w, i);
        this.liters = l;
        this.IsDanger = d;

    }

    public String getDangerous() {
        return IsDanger;
    }
    public String toStr() {
        return "Название " + super.getName() + " Вес " + this.getWeight() + " объем в литрах: "+ liters + " безопасность: " + IsDanger;
    }

}
