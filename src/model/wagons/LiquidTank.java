package model.wagons;

import model.storage.Storage;
import view.View;

import java.util.Objects;

public class LiquidTank extends Wagon {
    private String isDanger;//тип жидкости
    private double liters; // объем жидкости в литрах

    LiquidTank(){
        super();
        this.isDanger="";
        this.liters =0;

    }
    public LiquidTank(double w, int i, String d, double li){
        super(w,i);
        this.isDanger=d;
        this.liters =li;

    }
    public void load(Storage stack){
        boolean flag=true;
        for (int i=0; i< stack.getArr().size() ; i++){
            int x= stack.getArr().get(i).GetInd();

            if (x != 2 || !flag) {
                continue;
            }
            else{

            }
            if (Objects.equals(stack.getArr().get(i).getDangerous(), this.getDangerous())){
                this.addProd(stack.getArr().get(i));
                View.print(this.getArr().get(0).getName() + " загружается в вагон");
                stack.getArr().remove(i);
                i-=1;


            }
            flag=false;

        }

    }
    public String getDangerous() {
        return isDanger;
    }

}
