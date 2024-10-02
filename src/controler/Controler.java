package controler;
import model.*;
import model.products.*;
import model.storage.Storage;
import view.View;
import model.arr.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controler {
    public Controler() {
    }
    public void contr() {

        CreateArray cr= new CreateArray();
        List<Wagon> arr1 = cr.CreateArrayList(10);
        List<Wagon> arr2 = cr.CreateArrayList(100);
        List<Wagon> arr3 = cr.CreateArrayList(1000);
        List<Wagon> arr4 = cr.CreateArrayList(10000);
        List<Wagon> arr5 = cr.CreateArrayList(100000);

        CreateMap cr2= new CreateMap();
        Map<Integer,Wagon> d1 = cr2.CreateMap(10);
        Map<Integer,Wagon> d2 = cr2.CreateMap(100);
        Map<Integer,Wagon> d3 = cr2.CreateMap(1000);
        Map<Integer,Wagon> d4 = cr2.CreateMap(10000);
        Map<Integer,Wagon> d5 = cr2.CreateMap(100000);


        /*
        for (int x = 0; x < arr1.size(); x++) {
            View.print(arr1.get(x).toStr());
        }
        */

    }
}
