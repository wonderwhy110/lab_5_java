package controler;
import model.*;
import model.products.*;
import model.storage.Storage;
import view.View;
import model.arr.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controler {
    public Controler() {
    }

    public void contr() {
        int[][] y = new int[5][2];
        int[] y1 = new int[5];
        int[] y2 = new int[5];

// Заполняем новые массивы


        CreateArray cr = new CreateArray();
        y[0] = cr.CreateArrayList(10);
        y[1] = cr.CreateArrayList(100);
        y[2] = cr.CreateArrayList(1000);
        y[3] = cr.CreateArrayList(10000);
        y[4] = cr.CreateArrayList(100000);
        for (int i = 0; i < 5; i++) {
            y1[i] = 700 - y[i][0] / 10;
            y2[i] = 700 - y[i][1] / 10;

        }


        JFrame frame = new JFrame("исследование ArrayList");
        DrawGraf drawGraf = new DrawGraf();
        drawGraf.set_y(y1, y2);

        frame.add(drawGraf);
        frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Центрировать окно
        frame.setSize(1000, 800);
        frame.setVisible(true);
        int[][] yh = new int[5][2];
        int[] y1h = new int[5];
        int[] y2h = new int[5];


        CreateMap cr2 = new CreateMap();
        yh[0] = cr2.CreateMap(10);
        yh[1] = cr2.CreateMap(100);
        yh[2] = cr2.CreateMap(1000);
        yh[3] = cr2.CreateMap(10000);
        yh[4] = cr2.CreateMap(100000);
        for (int i = 0; i < 5; i++) {
            y1h[i] = 700 - yh[i][0] / 10;
            y2h[i] = 700 - yh[i][1] / 10;
        }

            JFrame frame2 = new JFrame("исследование HashMap");
            DrawGraf drawGraf2 = new DrawGraf();
            drawGraf2.set_y(y1h, y2h);

            frame2.add(drawGraf2);
            frame2.pack();
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setLocationRelativeTo(null); // Центрировать окно
            frame2.setSize(1000, 800);
            frame2.setVisible(true);

        /*
        for (int x = 0; x < arr1.size(); x++) {
            View.print(arr1.get(x).toStr());
        }
        */

        }
    }

