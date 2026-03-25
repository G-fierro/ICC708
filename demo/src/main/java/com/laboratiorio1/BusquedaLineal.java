package com.laboratiorio1;
public class BusquedaLineal {
    public static boolean buscar(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}