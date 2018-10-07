package ds.practice.arrays;

import java.util.Scanner;

public class GetFirstIndex {

    // combine binary search with condition to check to the left element.
    // else condition will go with updating the last with left of min
    int getFirstIndex(int[] array, int x) {
        if(array == null || array.length == 0)
            return -1;
        int start = 0;
        int last = array.length -1;
        while (start <= last) {
            int mid = (start+last)/2;
             if(array[mid] == x && (array[mid-1] < x || mid == start ))
                 return mid;
             else if(array[mid] < x)
                 start = mid + 1;
             else
                 last = mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 2, 4, 5, 5, 5, 8};
        System.out.println("Enter the number to search");
        int x = Integer.parseInt(new Scanner(System.in).next());

        System.out.printf("The first index of %d is %d", x, new GetFirstIndex().getFirstIndex(numbers, x));
    }
}
