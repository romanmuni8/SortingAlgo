package ClosestPair;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;
import java. util. Collection;
import java.util.function.DoubleToIntFunction;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable <Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point p) {
            return p.y==y ?Long.signum(x-p.x): Long.signum(y-p.y);
        }
    }
    //Calculate distnce
    public static double distance (Point p1, Point p2){
        return  Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }

    public static double calculateCase3(ArrayList<Point> arr, int size, double minDistance){
        double minValue =  minDistance;
        for( int i =0; i<size; i++){
            for(int j = i+1; j<Math.min(size,i+1+7);j++){
                double tempDistance = distance(arr.get(i),arr.get(j));
                if(tempDistance<minValue){
                    minValue = tempDistance;
                }
            }
        }
        return minValue;
    }



    // Minimal distance uses this funciton
    public static double closestRecursive(ArrayList <Point> arrX, ArrayList <Point>arrY, int count){
        if( count <=3){
            return bruteForce(arrX, count);
        }
        int mid = count/2;
        Point midPoint = arrX.get(mid);
        ArrayList <Point>  newArrX1 = new ArrayList<>();
        ArrayList <Point> newArrX2 = new ArrayList<>();

        for( int i =0 ; i< mid; i++){
            newArrX1.add(arrX.get(i));
        }
        for( int i =mid ; i< count; i++){
            newArrX2.add(arrX.get(i));
        }
        double distanceLeft = closestRecursive(newArrX1,arrY,mid);
        double distanceRight = closestRecursive(newArrX2, arrY,count-mid);
        double minDistance = Math.min(distanceLeft, distanceRight);
        // Points that lie within the distance d needs to be in this arraylist.
        // We use the list with sorted y.
        // We scan the sliver from the bottom to top.
        // ArrY is sorten hence, arrCase3 will also be sorted.
        ArrayList<Point> arrCase3 = new ArrayList<>();
        for (int i =0; i< count; i++){
            if(Math.abs(arrY.get(i).x)<minDistance){
                arrCase3.add(arrY.get(i));

            }
        }
        double distanceAcross = calculateCase3(arrCase3,arrCase3.size(),minDistance);
        return(Math.min(distanceAcross,minDistance));

    }

    private static double bruteForce(ArrayList<Point> arrX, int count) {
        double min = Long.MAX_VALUE;

        for( int i = 0 ;i<count; i++){
            for ( int j =1 ; j<count; j++){
                if (i!=j)
                min = Math.min(min,distance(arrX.get(i),arrX.get(j)));
            }
        }
       return min;
    }


    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        ArrayList<Point> arrX = new ArrayList<>();
        ArrayList<Point> arrY = new ArrayList<>();
        for( int i =0; i< x.length;i++){
            Point p = new Point(x[i],y[i]);
            arrX.add(p);
            arrY.add(p);
        }
       // Collections.sort(arrX,(a,b)-> (int) (a.x -b.x));
        Collections.sort(arrX);
        Collections.sort(arrY);

        return closestRecursive(arrX, arrY, arrX.size());
    }





    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);

        int n = nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {

            x[i] = nextInt();
            y[i] = nextInt();

        }
        minimalDistance(x, y);
        System.out.printf("Value with 3 digits after decimal point %.3f %n", PI);
        System.out.println(minimalDistance(x,y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}

