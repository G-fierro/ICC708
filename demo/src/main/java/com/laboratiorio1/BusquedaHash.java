package com.laboratiorio1;
import java.util.HashSet;
import java.util.Set;

public class BusquedaHash {
    public static boolean buscar(int[] arr, int target) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.contains(target);
    }
}