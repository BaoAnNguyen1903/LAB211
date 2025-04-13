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
public class SortAlgorithmController {
    public void BuddleSort(){
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
        int array[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
        System.out.print("Unsorted array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
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
        System.out.print("Sorted array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
        }
    }
    
    public void QuickSort(){
        int n;
        System.out.print("Enter number of array: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int array[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
        System.out.print("Unsorted array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
        }
        SortAlgorithmController sortController = new SortAlgorithmController();
        sortController.quickSort(array, 0, n - 1);
        System.out.print("Sorted array: [");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == n - 1) {
                System.out.println(array[i] + "]");
            }
        }
    }
    
    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
}
