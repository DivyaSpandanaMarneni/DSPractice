package ds.practice.arrays;

import java.util.Scanner;

public class GetLastIndex {
    // M1
    // reverse the array and get the first occurrence of the number
    private int getLastIndex(int[] array, int x) {
        for(int i = array.length -1; i >= 0; i--) {
            if(array[i] == x)
                return i;
        }
        return -1;
    }
    // complexity worst O(n)
    // best O(1)
    // avg O(n)


    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 2, 4, 5, 5, 5, 8};
        System.out.println("Enter the element");
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.next());
        System.out.println("The index is : " + new GetLastIndex().getLastIndex(numbers, 5));


    }
}
