package model.wagons;

import model.storage.Storage;
import view.View;

public class BulkWagon extends Wagon {

    private double capacity; // объемная ёмкость
    BulkWagon(){
        super();
        this.capacity=0;

    }
    public BulkWagon(double w, int i, double c){
        super(w,i);
        this.capacity=c;
    }
    public  void load( Storage stack){
        boolean flag=true;
        for (int i=0; i< stack.getArr().size() ; i++){
            int x= stack.getArr().get(i).GetInd();

            if (x != 3 || !flag) {
                continue;
            }
            else{

                this.addProd(stack.getArr().get(i));
                View.print(this.getArr().get(0).getName() + " загружается в вагон");
                stack.getArr().remove(i);
                i-=1;
                flag=false;
            }


        }

    }

}
