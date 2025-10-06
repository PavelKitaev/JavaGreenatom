package work2.Vector;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Random;


public class Vector {
    private double x = 0;
    private double y = 0;
    private double z = 0;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(ArrayList<Double> vector) {
        if (vector.size() == 3) {
            this.x = vector.get(0);
            this.y = vector.get(1);
            this.z = vector.get(2);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getLength() {
        return abs(sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2)));
    }

    public double getScalar(double xB, double yB, double zB) {
        return (x * xB) + (y * yB) + (z * zB);
    }

    public double getScalar(Vector vectorB) {
        return (x * vectorB.getX()) + (y * vectorB.getY()) + (z * vectorB.getZ());
    }

    public ArrayList<Double> getMultiply(double xB, double yB, double zB) {
        ArrayList<Double> res = new ArrayList<Double>();
        res.add(y * zB - z * yB);
        res.add((x * zB - z * xB) * (-1));
        res.add(x * yB - y * xB);

        return res;
    }

    public ArrayList<Double> getMultiply(Vector vectorB) {
        ArrayList<Double> res = new ArrayList<Double>();
        res.add(y * vectorB.getZ() - z * vectorB.getY());
        res.add((x * vectorB.getZ() - z * vectorB.getX()) * (-1));
        res.add(x * vectorB.getY() - y * vectorB.getX());

        return res;
    }

    public double getAngle(double xB, double yB, double zB) {
        double scalar = getScalar(xB, yB, zB);
        double lengthA = getLength();
        double lengthB = abs(sqrt(pow(xB, 2) + pow(yB, 2) + pow(zB, 2)));

        return acos(scalar / (lengthA * lengthB));
    }

    public double getAngle(Vector vectorB) {
        double scalar = getScalar(vectorB.getX(), vectorB.getY(), vectorB.getZ());
        double lengthA = getLength();
        double lengthB = abs(sqrt(pow(vectorB.getX(), 2) + pow(vectorB.getY(), 2) + pow(vectorB.getZ(), 2)));

        return acos(scalar / (lengthA * lengthB));
    }

    public ArrayList<Double> getSum(Vector vectorB) {
        ArrayList<Double> res = new ArrayList<Double>();

        res.add(x + vectorB.getX());
        res.add(y + vectorB.getY());
        res.add(z + vectorB.getZ());

        return res;
    }

    public ArrayList<Double> getSum(double xB, double yB, double zB) {
        ArrayList<Double> res = new ArrayList<Double>();

        res.add(x + xB);
        res.add(y + yB);
        res.add(z + zB);

        return res;
    }

    public ArrayList<Double> getDiff(Vector vectorB) {
        ArrayList<Double> res = new ArrayList<Double>();

        res.add(x - vectorB.getX());
        res.add(y - vectorB.getY());
        res.add(z - vectorB.getZ());

        return res;
    }

    public ArrayList<Double> getDiff(double xB, double yB, double zB) {
        ArrayList<Double> res = new ArrayList<Double>();

        res.add(x - xB);
        res.add(y - yB);
        res.add(z - zB);

        return res;
    }

    public static ArrayList<Vector> getVectors(int size) {
        ArrayList<Vector> vectors = new ArrayList<Vector>();

        Random random = new Random(System.currentTimeMillis());

        if (size > 0){
            for (int i = 0; i < size; ++i) {
                vectors.add(new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble()));
            }
        }
         return vectors;
    }
}
