/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class SearchController {

    public void CreateArray() {

    }

    public void LinerSearch() {
        Scanner sc = new Scanner(System.in);
        int search;
        int n = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter number of Array: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    throw new InputMismatchException("Invalid input. Number of array must be an integer.");
                }
                validInput = true;

            } catch (Exception e) {
                System.err.println("Invalid input. Number of array must be an integer.");
                sc.nextLine();
            }
        }
        int array[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
        System.out.print("Enter search value: ");
        search = sc.nextInt();
        System.out.print("The array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
        }
        int indexFound;
        for (int i = 0; i < n; i++) {
            if (array[i] == search) {
                indexFound = i;
                System.out.println("Found " + search + " at index: " + indexFound);
            } else {
                //System.out.println("Can not find value.");
            }
        }
    }

    public void BinarySearch() {
        Scanner sc = new Scanner(System.in);
        int sort;
        int n = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter number of Array: ");
            try {
                n = sc.nextInt();
                if(n <= 0) {
                    throw  new InputMismatchException("Invalid input. Number of array must be an integer.");
                }
                validInput = true;
                
            } catch (Exception e) {
                System.err.println("Invalid input. Number of array must be an integer.");
                sc.nextLine();
            }
        }
        System.out.print("Enter the number to search: ");
        int searchNumber = sc.nextInt();
        int array[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
        //3 5 2 5 9 8
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (array[i] > array[j]) {
                    sort = array[i];
                    array[i] = array[j];
                    array[j] = sort;
                }
            }
        }
        System.out.print("The array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
        }
        int searchIndex = binarySearch(array, searchNumber);
        if (searchIndex == -1) {
            System.out.println("The number " + searchNumber + " is not found in the array.");
        } else {
            System.out.println("The number " + searchNumber + " is found at index: " + searchIndex);
        }
    }
    
    public static int binarySearch(int[] array, int searchNumber) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == searchNumber) {
                return mid;
            } else if (array[mid] < searchNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
