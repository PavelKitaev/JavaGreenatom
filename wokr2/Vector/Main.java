package wokr2.Vector;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> vectorACoords = new ArrayList<Double>();
        vectorACoords.add(2.0);
        vectorACoords.add(3.0);
        vectorACoords.add(4.0);

        Vector vectorA = new Vector(vectorACoords);
        Vector vectorB = new Vector(7, 8, 9);

        System.out.println("Ветор А: (" + vectorA.getX() + ", " + vectorA.getY() + ", " + vectorA.getZ() + ")");
        System.out.println("Ветор А: (" + vectorB.getX() + ", " + vectorB.getY() + ", " + vectorB.getZ() + ")\n");
        System.out.println("Длина вектора А: " + vectorA.getLength());
        System.out.println("Длина вектора B: " + vectorB.getLength() + "\n");
        System.out.println("Скалярное поизведение A * B: " + vectorA.getScalar(vectorB));
        System.out.println("Произведение A * B: " + vectorA.getMultiply(vectorB));
        System.out.println("Улог между A и B: " + vectorA.getAngle(vectorB));
        System.out.println("Сумма А и В: " + vectorA.getSum(vectorB));
        System.out.println("Разность А и В: " + vectorA.getDiff(vectorB));

        ArrayList<Vector> vectors = Vector.getVectors(10);
        System.out.println("Генерация случайных векторов. \nРазмер: " + vectors.size());

        for (int i = 0; i < vectors.size(); ++i) {
            Vector temp = vectors.get(i);
            System.out.println("Вектор " + i + ": (" + temp.getX() + ", " + temp.getY() + ", " + temp.getZ() + ")");
        }

    }
}
