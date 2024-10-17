package model;
import model.arr.CreateArray;
import model.wagons.Wagon;
import view.View;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class ObjectsList {
    private List<Wagon> wagons;
    private final String filename = "data.ser"; // Файл для сохранения

    public ObjectsList() {
        this.wagons = new ArrayList<>();
        //readFromFile();
    }

    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            wagons = (List<Wagon>) ois.readObject();
            System.out.println("Чтение объектов успешно:");
            for (Wagon wagon : wagons) {
                View.print(wagon.toStr());
            }
        } catch (FileNotFoundException e) {
            View.print("Файл не найден, будет создан новый.");
        } catch (IOException | ClassNotFoundException e) {
            View.print("Ошибка при чтении из файла: " + e.getMessage());
        }
    }

    public void put() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        View.print("Введите айди(1-4) вагона: ");

        int i = scanner.nextInt();
        View.print("Введите вес вагона: ");
        double w = scanner.nextDouble();
        scanner.nextLine();

        View.print("Введите название продукта: ");
        String name = scanner.nextLine();
        View.print("Введите вес продукта: ");
        double w_t = scanner.nextDouble();
        wagons.add(new Wagon(w,i,w_t,name));
        //saveToFile();
        System.out.println("Вагон добавлен.");
    }

    public void change(int index) {
        if (index < 0 || index >= wagons.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        View.print("Введите айди(1-4) вагона: ");
        int i = scanner.nextInt();
        View.print("Введите вес вагона: ");
        double w = scanner.nextDouble();
        scanner.nextLine();
        View.print("Введите название продукта: ");
        String name = scanner.nextLine();
        View.print("Введите вес продукта: ");
        double w_t = scanner.nextDouble();

        wagons.set(index, new Wagon(w,i,w_t,name));
        //saveToFile();
        System.out.println("Вагон изменен.");
    }

    public void del(int index) {
        if (index < 0 || index >= wagons.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        wagons.remove(index);
        //saveToFile();
        System.out.println("Вагон удален.");
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(wagons);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }
    
    public List<Wagon> getArr(){
        return wagons;
        
    }
    public void clearList(){
        wagons.clear();

    }

    public void autoTest(Config config) {
        config.writeLog("Запуск программы с режимом автотестов.");
        readFromFile();
        config.writeLog("прочитано " + this.wagons.size()+" объектов из базы данных ");
        CreateArray cr= new CreateArray();
        List<Wagon> arr1 = cr.CreateArrayList(10);
        for (Wagon  w: arr1){
            this.wagons.add(w);
        }
        config.writeLog("добавлено 10 объектов ");
        int index=(int) ( Math.random() * this.wagons.size());
        del(index);
        config.writeLog("удален объект с индексом " + index);
        saveToFile();
        config.writeLog("записанно " + this.wagons.size()+" объектов в базу данных ");
        config.writeLog("Конец автотестов ");





    }
}