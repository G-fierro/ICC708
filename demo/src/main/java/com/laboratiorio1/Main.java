package com.laboratiorio1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        runLinealVsHash();
        runLinealVsBinaria();
    }

    public static void runLinealVsHash() {
        int[] sizes = {100, 1000, 5000, 100000, 200000, 1000000};
        int repeticiones = 20;

        for (int size : sizes) {
            List<Long> tiemposLineal = new ArrayList<>();
            List<Long> tiemposHash = new ArrayList<>();

            for (int i = 0; i < repeticiones; i++) {
                int[] data = GeneradorDatos.generar(size);
                int target = data[size / 2];

                
                long start = System.nanoTime();
                boolean res1 = BusquedaLineal.buscar(data, target);
                long end = System.nanoTime();
                tiemposLineal.add(end - start);

                
                Set<Integer> set = new HashSet<>();
                for (int num : data) set.add(num);

                
                start = System.nanoTime();
                boolean res2 = set.contains(target);
                end = System.nanoTime();
                tiemposHash.add(end - start);
            }

            System.out.println("Size: " + size);
            System.out.println("Lineal promedio: " + promedio(tiemposLineal));
            System.out.println("Hash promedio: " + promedio(tiemposHash));
            System.out.println("----------------------");
        }
    }

    public static void runLinealVsBinaria() {
        int[] sizes = {100, 1000, 5000, 100000, 200000, 1000000};
        int repeticiones = 20;

        for (int size : sizes) {
            List<Long> tiemposLineal = new ArrayList<>();
            List<Long> tiemposBinaria = new ArrayList<>();

            for (int i = 0; i < repeticiones; i++) {
                int[] data = GeneradorDatos.generar(size);
                int target = data[size / 2];

                // 🔹 Preparar datos ordenados (NO medir)
                int[] sorted = Arrays.copyOf(data, data.length);
                Arrays.sort(sorted);

                // 🔹 Lineal (puedes usar sorted si quieres consistencia experimental)
                long start = System.nanoTime();
                boolean res1 = BusquedaLineal.buscar(sorted, target);
                long end = System.nanoTime();
                tiemposLineal.add(end - start);

                // 🔹 Binaria (solo búsqueda)
                start = System.nanoTime();
                boolean res2 = BusquedaBinaria.buscar(sorted, target);
                end = System.nanoTime();
                tiemposBinaria.add(end - start);
            }

            System.out.println("Size: " + size);
            System.out.println("Lineal promedio: " + promedio(tiemposLineal));
            System.out.println("Binaria promedio: " + promedio(tiemposBinaria));
            System.out.println("----------------------");
        }
    }

    private static long promedio(List<Long> lista) {
        Collections.sort(lista);
        return lista.get(lista.size() / 2);
    }
}