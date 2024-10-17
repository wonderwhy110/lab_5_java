package controler;
import model.*;




import model.products.*;
import model.storage.Storage;
import model.wagons.Wagon;
import view.View;
import model.arr.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Controler {
    private static Config config;

    public Controler() {
    }

    public void contr() {
        config = new Config();
        config.loadConfig();
        if (config.autoTestMode){
            View.print("Выполнение автотестов..");
            ObjectsList Testobjects = new ObjectsList();
            Testobjects.autoTest(config);
        }
        if (config.debugMode) {
            config.writeLog("Запуск программы с режимом отладки.");
        }

        Scanner scanner = new Scanner(System.in);
        View.print("Введите логин: ");
        String inputUsername = scanner.nextLine();
        View.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals(config.username) && inputPassword.equals(config.password)) {
            config.writeLog("Пользователь " + config.username + " вошел в систему.");
            View.print("Добро пожаловать — " + config.username);
            showMenu(scanner);
        } else {
            config.writeLog("Неудачная попытка входа для пользователя: " + inputUsername);
            View.print("Неверный логин или пароль.");
        }

        scanner.close();
    }


    private static void showMenu(Scanner scanner) {
        ObjectsList objectsList = new ObjectsList();
        //Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить вагон");
            System.out.println("2. Изменить вагон");
            System.out.println("3. Удалить вагон");
            System.out.println("4. Просмотр данных");
            System.out.println("5. Чтение из базы данных");
            System.out.println("6. Сохранить в базу данных");

            if (config.userGroup.equals("root")) {
                System.out.println("7. Включить отладку");
                System.out.println("8. Автотесты");
            }
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
                scanner.nextLine(); // очистить буфер после ввода числа
                switch (choice) {
                    case 1:
                        objectsList.put();
                        break;
                    case 2:
                        System.out.print("Введите индекс вагона для изменения: ");
                        int changeIndex = scanner.nextInt();
                        scanner.nextLine();
                        objectsList.change(changeIndex);
                        break;
                    case 3:
                        System.out.print("Введите индекс вагона для удаления: ");
                        int delIndex = scanner.nextInt();
                        objectsList.del(delIndex);
                        config.writeLog("объект с индексом  " + delIndex+" удален ");
                        break;

                    case 4:
                        // Логика для просмотра данных
                        System.out.println("Данные...");
                        for (Wagon e: objectsList.getArr()){
                            View.print(e.toStr());
                        }
                        break;
                    case 5:
                        objectsList.readFromFile();
                        config.writeLog("прочитано " + objectsList.getArr().size()+" объектов из базы данных ");
                        break;

                    case 6:
                        objectsList.saveToFile();
                        config.writeLog("записанно " + objectsList.getArr().size()+" объектов в базу данных ");
                        break;
                    case 7:
                        // Включение режима отладки
                        config.debugMode = true;
                        config.writeLog("Режим отладки включен.");
                        config.updateConfigFile();  // Обновление файла конфигурации

                        break;
                    case 8:

                        config.autoTestMode = true;
                        config.writeLog("Режим автотестов включен.");
                        config.updateConfigFile();  // Обновление файла конфигурации
                        // Автотесты (логика не реализована)
                        System.out.println("Автотесты...");
                        break;
                    case 0:
                        config.writeLog("Пользователь " + config.username + " вышел из системы.");
                        objectsList.clearList();
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте еще раз.");
                }
            }
        }


    }




        /*
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


