package model.products;

public class Car extends Product{
    private String type; //грузовой или легковой
    private String brand;
    public Car(){
        super();
        this.type="";
        this.brand="";
    }
    public Car(String na, double w, int i, String t, String b){
        super(na,w,i);
        this.type=t;
        this.brand=b;
    }
    public String getType(){
        return type;
    }
    public String toStr() {
        return "Название: " + super.getName() + " Вес: " + this.getWeight() + " тип: "+ type + " марка: "+ brand;
    }
}
