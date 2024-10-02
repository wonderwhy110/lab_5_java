package model.products;

public class Bulc extends Product{
    private double density; // плотность
    Bulc(){
        super();
        this.density=0;

    }
    public Bulc(String na, double w, int i, double d){
        super(na,w,i);
        this.density=d;
    }
    public String toStr() {
        return "Название: " + super.getName() + " Вес: " + this.getWeight() + " плотность: "+ density;
    }
}
