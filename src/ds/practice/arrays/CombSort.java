package ds.practice.arrays;

public class CombSort {

    private static final double gapFactor = 1.3;
    int[] combSort(int[] input, int gap) {

        if(gap == 1)
            return input;

        for(int i = gap; i < input.length; i++ ) {
            if(input[i] < input[i-gap]) {
                int temp = input[i];
                input[i] = input[i-gap];
                input[i-gap] = temp;
            }
        }

        gap = (int) Math.floor(gap/gapFactor);
        return combSort(input, gap);

    }

    public static void main(String[] args) {
        int[] numbers = {33, 98, 74, -13, 55, 20, 77, -45, 64, 83};
        int gap = (int) Math.floor((numbers.length/gapFactor));
        int[] results = new CombSort().combSort(numbers, gap);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }

    }
}
