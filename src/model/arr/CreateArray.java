package model.arr;
import model.Wagon;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.time.*;
import model.*;
import java.util.ArrayList;
import java.util.List;
public class CreateArray {
   public String getProd(int k){
       Map<Integer, String[]> items = new HashMap <Integer, String[]>();
       String[] arr1 = {"большой контейнер","контейнер"};
       String[] arr2 = {"Молоко", "Топливо", "Химикаты", "Нефть"};
       String[] arr3 = {"Песок", "Цемент", "Уголь", "Зерно","гравий"};
       String[] arr4 = {"Легковой автомобиль", "Грузовой автомобиль", "Мотоциклы", "Автобус"};
       items.put(1, arr1);
       items.put(2, arr2);
       items.put(3, arr3);
       items.put(4, arr4);
       Random random = new Random();
       String[] arr=items.get(k);
       String name=arr[random.nextInt(arr.length)];
       return name;
   }
   public CreateArray(){}

    public ArrayList CreateArrayList(int n){
        List<Wagon> arr=new ArrayList<Wagon>();
        double cur_time=0;
        double d_time=0;
        ArrayList<Integer> d_times = new ArrayList<Integer>();

        for (int i=0; i<n; i++){
            Wagon wag=randWagon();
            cur_time=System.nanoTime();
            arr.add(wag);
            d_time=(int)(System.nanoTime()-cur_time);
            d_times.add((int) d_time);

        }
        MyLogger file = loadList(d_times,  n);
        int r= (int) (n*0.1);
        int s= 0;
        for (int i=0; i< r; i++){
            int ind =(int) (Math.random() * (n-i) );
            cur_time=System.nanoTime();
            arr.remove(ind);
            d_time=(int)(System.nanoTime()-cur_time);
            file.log("remove, ID = "+ (ind) + ", " + d_time);
            s+=d_time;


        }
        file.log("removeTotalCount = " + r);
        file.log("removeTotalTime = " + s);
        file.log("removeMedianTime = " + s/r);
        file.log("Finish program");

        return (ArrayList<Wagon>) arr;

    }

    public Wagon randWagon() {
        double weight=Math.random()*300 +100;
        int id= (int) (( Math.random() * 4) + 1);
        double w = Math.random()*400 +100;
        String name=getProd(id);
        Wagon wag=new Wagon(weight,id,w,name );
        return wag;
    }

    public MyLogger loadList(ArrayList<Integer> d_times, int n){
        MyLogger x=new MyLogger("LogList");
        int sum=0;
        LocalDate today = LocalDate.now();
        x.log("Start program: " + today);
        x.log("ArrayList");

        for (int i=0; i<n; i++){
            x.log("add, ID = "+ (i+1) + "," + d_times.get(i));
            sum += d_times.get(i);

        }
        x.log("addTotalCount =" + n);
        x.log("addTotalTime =" + sum);
        x.log("addMediumTime =" + sum/n);
        return x;
    }




}
