package ds.practice.arrays;

import java.util.Scanner;

public class GetLastIndex {
    // M1
    // reverse the array and get the first occurrence of the number
    // complexity worst O(n)
    // best O(1)
    // avg O(n)
    private int getLastIndex(int[] array, int x) {
        for(int i = array.length -1; i >= 0; i--) {
            if(array[i] == x)
                return i;
        }
        return -1;
    }


    // solution with binary search
    // not ideal since we are using a for loop which is of order O(n)
    // complexity log n + n/2 = O(n)
    private int getLastIndexWithBinary(int[] array, int x) {
        BinarySearch binarySearch = new BinarySearch();
        int find = -1;
        int firstFind = binarySearch.binarySearch(array, x, 0, array.length-1);
        if(firstFind == -1)
            return -1;
        for(int i = firstFind+1; i < array.length; i ++) {
            if(array[i] == x ) {
                find = i;
            }
        }
        return find;
    }

    // optimized
    // O(log n)
    private int getLastIndexBinaryUtil(int[] array, int x){
        if(array == null || array.length == 0)
            return -1;
        int start = 0;
        int last = array.length -1;

        while (start <= last) {
            int mid = (start + last)/2;
            if(array[mid] == x && ((mid == last) || array[mid+1] > x))
                return mid;
            else if(x < array[mid]){
                last = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 2, 4, 5, 5, 5, 8, 8, 8, 8, 8, 8,9 ,9,9,9,9,9,9,9,9,9, 10, 10 , 11, 11 , 11,11,11,11};
        System.out.println("Enter the element");
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.next());
        long start = System.currentTimeMillis();
        System.out.println("The index is : " + new GetLastIndex().getLastIndex(numbers, x));
        long end = System.currentTimeMillis();
        System.out.println("Time with reverse: " + (end - start));
        start = System.currentTimeMillis();
        System.out.println("Last index with binary search: " + new GetLastIndex().getLastIndexWithBinary(numbers,x));
        end = System.currentTimeMillis();
        System.out.println("Time with bin search: " + (end-start));

        start = System.currentTimeMillis();
        System.out.println("Last index with bin search: " + new GetLastIndex().getLastIndexBinaryUtil(numbers,x));
        end = System.currentTimeMillis();
        System.out.println("Time with bin search: " + (end-start));
    }
}
