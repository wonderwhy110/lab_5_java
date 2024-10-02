package model;
import model.products.Product;

import java.util.ArrayList;
import java.util.List;
public class Train {
    public static String[] getArr;
     List<Wagon> train=new ArrayList<Wagon>();
    public Train(){

    }
    public void addWagon(Wagon wagon){
        train.add(wagon);

    }
    public  ArrayList<Wagon> getArr(){
        return (ArrayList<Wagon>) train;
    }


    // public String getArr(){
      //  return ((Wagon) train).toStr();
    }



