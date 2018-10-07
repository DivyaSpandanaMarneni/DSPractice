package ds.practice.arrays;

import java.util.Scanner;

public class BinarySearch {

    public int binarySearch(int[] array, int x, int start, int last) {
        if (array == null || array.length == 0) {
            return-1;
        }

        int mid = (start+last)/2;

        if(x == array[mid])
            return mid;
        else if(x > array[mid]){
            start = mid + 1;
        }
        else {
            last = mid -1;
        }
        return binarySearch(array, x, start, last);
    }

    public static void main(String[] args) {
        int[] numbers = {0,12,15,16, 18, 21, 32, 56};
        numbers = new int[] {0, 1, 2, 2, 4, 5, 5, 5, 8, 8, 8, 8, 8, 8,9 ,9,9,9,9,9,9,9,9,9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to search");
        int x = Integer.parseInt(scanner.next());

        System.out.println("Binary search result: " + new BinarySearch().binarySearch(numbers, x, 0 , numbers.length-1));
    }
}
