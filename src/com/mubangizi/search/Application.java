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
                    Object list[] = List.elements();
                    if (new LinearSearch().search(list, jin.next())) {
                        System.out.println("[\tFOUND A MATCH IN LIST\t\t]");
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

        public boolean search(Object[] array, Object item) {
            if (array != null) {
                if (array[0].equals(item)) {
                    return true;
                }
                return search(array, item, 0);
            }
            return false;
        }

        private boolean search(Object[] array, Object item, int index) {
            if (index < array.length) {
                if (array[index++].equals(item)) {
                    return true;
                }
                return search(array, item, index);
            }
            return false;
        }
    }
}
