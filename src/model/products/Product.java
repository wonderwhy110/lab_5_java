package model.products;

public class Product {
    private String name;
    private double weight;
    private static int n;
    private int ind; // 1-контейнер, 2-жидкости 3-сыпуч  4-авто
    Product(){
        this.name="";
        this.weight=0;
        this.ind=0;
        n=0;
    }
    public Product(String na, double w, int i){
        this.name=na;
        this.weight=w;
        this.ind=i;
        n+=1;
    }
    public String getName() {
        return name;
    }
    public int GetInd(){
        return ind;
    }
    public double getWeight(){
        return weight;
    }



    public String getDangerous() {
      return "";
    }

    public String toStr() {
        return ", Название: " + this.name + ", Вес груза: " + this.weight;
    }
}
