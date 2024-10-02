package model.products;

public class Container extends Product{
    private double height;
    private double capicity;
    public Container(){
        super();
        this.height=0;
        this.capicity=0;

    }
    public Container(String na, double w, int i, double h, double c) {
        super(na,w,i);
        this.height=h;
        this.capicity=c;
    }
    public String toStr() {
        return "Название: " + super.getName() + " Вес: " + this.getWeight() + " высота: "+ height + " емкость: " + capicity;
    }

}
