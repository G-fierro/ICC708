package com.laboratiorio1;
import java.util.Arrays;

public class BusquedaBinaria {
    public static boolean buscar(int[] arr, int target) {
        
        //datos ordenados
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}