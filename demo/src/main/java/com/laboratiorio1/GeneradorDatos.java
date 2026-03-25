package com.laboratiorio1;
import java.util.Random;

public class GeneradorDatos {
    public static int[] generar(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000000);
        }
        
        return arr;
    }
}