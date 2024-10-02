package model;

import model.storage.Storage;
import view.View;

import java.util.Objects;

public class CarPlatform extends Wagon{
    private int trucksNum; //кол-во грузовиков
    private int carNum; //кол-во легковых авто
    public CarPlatform(int i, int i1){
        super();
        this.trucksNum=0;
        this.carNum=0;

    }
    public CarPlatform(double w, int i, int t, int c){
        super(w,i);
        this.trucksNum=t;
        this.carNum=c;

    }

    public  void load( Storage stack) {

        for (int i = 0; i < stack.getArr().size(); i++) {
            int x = stack.getArr().get(i).GetInd();
            if (x == 4) {
                this.addProd(stack.getArr().get(i));
                View.print(this.getArr().get(0).getName() + " загружается в вагон");
                stack.getArr().remove(i);
                if (Objects.equals("легковой", this.getType())) {
                    this.addCar(1);
                }
                else{
                    this.addTruck(1);
                }

                i -= 1;
            }
        }
    }
    public void addCar (int j){
        this.carNum+=j;
    }
    public void addTruck (int j){
        this.trucksNum+=j;
    }



}
