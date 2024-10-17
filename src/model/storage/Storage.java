package model.storage;
import model.products.Product;

import java.util.ArrayList;
import java.util.List;
public class Storage {
    static List<Product> stack=new ArrayList<Product>();
    public Storage(){
        stack= new ArrayList<Product>();
    }
    public static void addProd(Product prod){
        stack.add(prod);
    }
    public  ArrayList<Product> getArr(){
        return (ArrayList<Product>) stack;
    }
/*
    public void load(Wagon wag){
        int x=wag.GetId();
        if  (x==1) {
            for (int i=0; i< stack.size(); i++){
                if (i==1){
                    wag.addProd(stack.get(i));
                    stack.remove(i);
                    View.print(stack.get(i).GetName() + " загружается в вагон");
                }
            }



        }
    }
*/

}
