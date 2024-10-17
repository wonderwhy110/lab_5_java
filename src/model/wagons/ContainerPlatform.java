package model.wagons;

import model.products.Product;
import model.storage.Storage;
import view.View;

public class ContainerPlatform extends Wagon {
    private int numСontainer; // количество
    private double width; // ширина конт
    ContainerPlatform(){
        super();
        this.numСontainer=0;
        this.width=0;


    }
    public ContainerPlatform(double w, int i, int n, double wi){
        super(w,i);
        this.numСontainer=n;
        this.width=wi;
    }
    public double getWidth(){
        return width;
    }
    public void load( Storage stack){

            for (int i=0; i< stack.getArr().size() ; i++){
                int x= stack.getArr().get(i).GetInd();
                if (x==1){
                    this.addProd(stack.getArr().get(i));
                    View.print(this.getArr().get(0).getName() + " загружается в вагон");
                    stack.getArr().remove(i);
                    this.addNumСontainer(1);
                    i-=1;
                }
            }

    }
    public  void addProd(Product pr){
        this.prod.add(pr);

    }
    public void addNumСontainer (int j){
        this.numСontainer+=j;
    }


}
