package ds.practice.arrays;

public class DifferenceInArrays {

    int getDifference(int[] arr1, int[] arr2) {
        int sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 = sum1 + arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            sum1 = sum1 - arr2[i];
        }
        return sum1;
    }

    // without using arithmetic operations
    int getDifferenceXOR(int[] arr1, int[] arr2) {
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            result = result ^ arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result = result ^ arr2[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] arr2 = {2, 4, 3, 9, 1, 8, 5, 6};

        System.out.println("with arithmetic operations: " +new DifferenceInArrays().getDifference(arr1, arr2));
        System.out.println("with xor: " + new DifferenceInArrays().getDifferenceXOR(arr1, arr2));
    }
}
