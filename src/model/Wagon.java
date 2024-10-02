package model;
import model.products.Product;
import model.storage.Storage;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
    private static int num;
    private double weight; // вес вагона
    private int id; // 1-контейнер, 2-для жидкости 3-для сыпуч  4-для авто
    List<Product> prod=new ArrayList<Product>();

    public  ArrayList<Product> getArr(){
        return (ArrayList<Product>) this.prod;
    }
    public void addProd(Product pr){
        this.prod.add(pr);

    }
    Wagon() {
        this.id = 0;
        this.weight=0;
        num=0;

    }
    //конструктор с параметром — устанавливает значение свойства Temp
    public Wagon(double w, int m) {

        this.weight=w;
        this.id=m;

        num+=1;
    }
    public Wagon(double w, int m, double we,String name) {

        this.weight=w;
        this.id=m;
        num+=1;
        this.prod.add(new Product(name, we, m));

    }
    public double GetWeight() {
        return weight;
    }

    public String toStr(){
        String s= "вес: " + Double.toString(weight) + ", id: " + id;
        for (Product i:this.prod){
            s+=i.toStr();
        }
        return s;
    }
    public int GetId(){
        return id;
    }
    public void load(Storage stack){}
    public double getWidth() {
        return 0;
    }
    public void addNumСontainer (int j){
    }
    public String getDangerous() {
        return "";
    }

    protected String getType() {
        return "";
    }

    protected void addCar(int i) {
    }
    protected void addTruck(int i) {

    }
}
