package ds.practice.arrays;

public class FindOddOccurance {

    public void printOddOccurance(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            System.out.println("Enpty array");
            return;
        }
        int odd = numbers[0];
        for(int i =1; i < numbers.length; i ++) {
            odd = odd ^ numbers[i];
        }
        System.out.println("odd occurance: " + odd);
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 3, 1, 5, 5, 1, 4, 2, 5};
        new FindOddOccurance().printOddOccurance(input);
    }
}
