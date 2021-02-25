package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{

    /**
     * Time measurement for the add method
     * @param list_array an object of the ArrayList class
     * @param list_link an object of the LinkedList class
     * @param k number of repetitions
     * @return object of the TimerResults class
     */
    public static TimerResults AddTimer (ArrayList <Integer> list_array, LinkedList <Integer> list_link, int k) {
        long t0; int n = 7;
        TimerResults result = new TimerResults();

        t0 = System.currentTimeMillis();
        for (int i = 0; i < k; i++)
            list_array.add(n);
        result.setT_array(System.currentTimeMillis() - t0);

        t0 = System.currentTimeMillis();
        for (int i = 0; i < k; i++)
            list_link.add(n);
        result.setT_link(System.currentTimeMillis() - t0);

        return result;
    }
    /**
     * Time measurement for the get method
     * @param list_array an object of the ArrayList class
     * @param list_link an object of the LinkedList class
     * @param k number of repetitions
     * @return object of the TimerResults class
     */
    public static TimerResults GetTimer (ArrayList <Integer> list_array, LinkedList <Integer> list_link, int k) {
        long t0;
        Object temp;
        TimerResults result = new TimerResults();

        t0 = System.currentTimeMillis();
        for (int i = 0; i < k; i++)
            temp = list_array.get(i);
        result.setT_array(System.currentTimeMillis()- t0);

        t0 = System.currentTimeMillis();
        for (int i = 0; i < k; i++)
            temp = list_link.get(i);
        result.setT_link(System.currentTimeMillis() - t0);
        return result;
    }
    /**
     * Time measurement for the delete method
     * @param list_array an object of the ArrayList class
     * @param list_link an object of the LinkedList class
     * @param k number of repetitions
     * @return object of the TimerResults class
     */
    public static TimerResults DeleteTimer (ArrayList <Integer> list_array, LinkedList <Integer> list_link, int k) {
        long t0; int i;
        TimerResults result = new TimerResults();

        t0 = System.currentTimeMillis();
        for (i = k - 1; i >= 0; i--)
            list_array.remove(i);
        result.setT_array(System.currentTimeMillis() - t0);

        t0 = System.currentTimeMillis();
        for (i = k - 1; i >= 0; i--)
            list_link.remove(i);
        result.setT_link(System.currentTimeMillis() - t0);

        return result;
    }
    /**
     * Output of measurement results as a table for the ArrayList class
     * @param result_add measurement result of the add method
     * @param result_get measurement result of the get method
     * @param result_delete measurement result of the delete method
     * @param k number of repetitions
     */
    public static void ArrayTable (TimerResults result_add, TimerResults result_get, TimerResults result_delete, int k) {
        System.out.println ("ArrayList:");
        System.out.printf ("%-10s%-10s%-10s%n", "Method" + "\t\t\t", "Repetitions" + "\t", "Time");

        // Выводим имя поля
        System.out.printf("%-10s", "add");
        // Выводим значение поля
        //field.setAccessible(true);  // !!! разрешить доступ к значениям полей !!!
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_add.getT_array());
        System.out.println();

        System.out.printf("%-10s", "get");
        // Выводим значение поля
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_get.getT_array());
        System.out.println();

        System.out.printf("%-10s", "delete");
        // Выводим значение поля
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_delete.getT_array());
        System.out.println();
    }
    /**
     * Output of measurement results as a table for the LinkedList class
     * @param result_add measurement result of the add method
     * @param result_get measurement result of the get method
     * @param result_delete measurement result of the delete method
     * @param k number of repetitions
     */
    public static void LinkTable (TimerResults result_add, TimerResults result_get, TimerResults result_delete, int k) {
        System.out.println ("LinkedList:");
        System.out.printf ("%-10s%-10s%-10s%n", "Method" + "\t\t\t", "Repetitions" + "\t", "Time");

        // Выводим имя поля
        System.out.printf("%-10s", "add");
        // Выводим значение поля
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_add.getT_link());
        System.out.println();


        // Выводим имя поля
        System.out.printf("%-10s", "get");
        // Выводим значение поля
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_get.getT_link());
        System.out.println();


        // Выводим имя поля
        System.out.printf("%-10s", "delete");
        // Выводим значение поля
        System.out.printf("%15s", k);
        // Выводим тип поля
        System.out.printf("%10s", result_delete.getT_link());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> list_array = new ArrayList <Integer> ();
        LinkedList <Integer> list_link = new LinkedList <Integer>();
        int k;

        System.out.println ("Enter the number of repetitions:");
        k = in.nextInt();

        TimerResults result_add;
        result_add = AddTimer (list_array, list_link, k);

        TimerResults result_get;
        result_get = GetTimer (list_array, list_link, k);

        TimerResults result_delete;
        result_delete = DeleteTimer (list_array, list_link, k);

        ArrayTable (result_add, result_get, result_delete, k);

        LinkTable (result_add, result_get, result_delete, k);
    }
}
