package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawGraf extends JComponent
{
    int xg[] =  {10/100+20,100/100+20,1000/100+20, 10000/100+20,100000/100+20};
    int yg[] =  new int[5];
    int yg2[] =  new int[5];
    int ng =5;

    @Override
    protected void paintComponent(Graphics gh) {

        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 700, 20, 200);
        drp.drawLine(20, 700, 1000, 700);
        drp.setColor(Color.BLUE);
        gh.drawString("add- синий", 400, 20); // Заголовок графика
        drp.drawPolyline(xg, yg, ng);
        drp.setColor(Color.RED);
        drp.drawPolyline(xg, yg2, ng);
        gh.drawString("remove- красный", 400, 30); // Заголовок графика

        // Подписи к осям
        gh.setColor(Color.BLACK); // Цвет для подписей
        gh.drawString("Ось Y(время)", 5, 20); // Подпись оси Y
        gh.drawString("Ось X(Колличество элементов)", 500, 750); // Подпись оси X
    }
    public void set_y(int y[],int y2[]){
     this.yg=y;
     this.yg2=y2;
    }
}