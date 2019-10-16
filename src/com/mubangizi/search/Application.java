package com.mubangizi.search;

import com.mubangizi.list.LinearLinkedList;
import com.mubangizi.list.LinearLinkedListImpl;
import java.util.Scanner;

/**
 *
 * @author Ian Mubangizi
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        LinearLinkedList<Object> List = new LinearLinkedListImpl();
//        String List[] = {"Ian", "Mubangizi", "20", "Student"};
//        System.out.println(new LinearSearch().search(List, 20));
//        System.out.println(new LinearSearch().search(List, "45"));
//        System.out.println(new LinearSearch().search(List, "Ian"));
//        System.out.println(new LinearSearch().search(List, "Mubangizi"));

        System.out.println("[\tUse [Q] -> Quit / [A] -> Add & [S] -> Search\t]");
        while (true) {
            System.out.print("[INPUT [Q] - [A] - [S]]: ");
            String input = jin.next();
            if (input.matches("Q") | input.matches("q")) {
                break;
            }
            if (input.matches("A") | input.matches("a")) {
                System.out.print("[INPUT DATA TO ADD]: ");
                List.add(jin.next());
            }
            if (input.matches("S") | input.matches("s")) {
                if (List.elements() != null) {
                    System.out.print("[INPUT DATA TO SEARCH]: ");
                    Object list[] = new Object[List.elements().length];
                    for (int i = 0; i < List.elements().length; i++) {
                        list[i] = List.elements()[i].getData();
                    }
                    if (new LinearSearch().search(list, jin.next())) {
                        System.out.println("[\tFOUND A MATCH IN LIST\t]");
                    } else {
                        System.out.println("[\tNO MATCH IN LIST\t\t]");
                    }
                } else {
                    System.out.println("[\tADD ITEMS IN ORDER TO SEARCH\t]");
                }
            }
        }
    }

    static class LinearSearch {

        private int index = 0;

        public boolean search(Object[] array, Object item) {
            if (array != null && index < array.length) {
                if (array[index++].equals(item)) {
                    return true;
                }
                return search(array, item);
            }
            return false;
        }
    }
}
