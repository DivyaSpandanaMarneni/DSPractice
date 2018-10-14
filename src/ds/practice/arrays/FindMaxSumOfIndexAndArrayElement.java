package ds.practice.arrays;

// Find maximum value of sum of index element products(i*array[i])
// with only rotations allowed on a given array
public class FindMaxSumOfIndexAndArrayElement {

    // simple way to get max sum
    // O(n^2)
    public int getMaxSum(int[] input) {
        int max = 0;
        int sum = 0;

        for (int s = 0; s< input.length; s ++) {
            int temp = input[0];
            sum = 0;
            // rotation
            for (int i = 1; i< input.length; i ++) {
                input[i-1] = input[i];
            }

            input[input.length -1] = temp;
            // finding sum
            for (int i = 0; i < input.length; i++) {
                sum = sum + i*input[i];
            }
            max = max < sum? sum : max;
        }

        for (int s = 0; s< input.length; s ++) {
            int temp = input[input.length -1];
            sum =0;
            for (int i = 1; i< input.length; i ++) {
                input[i] = input[i-1];
            }

            input[0] = temp;

            for (int i = 0; i < input.length; i++) {
                sum = sum + i*input[i];
            }
            max = max < sum? sum : max;
        }

       return max;
    }

    // optimized way to get max sum without doing actual rotation
    public int getMaxSumOptimized(int[] input) {
        int sum = 0;
        int sumi = 0;
        int maxSum = 0;

        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
            sumi = sumi + i*input[i];

        }


        maxSum = sumi;
        for (int i = 1; i < input.length; i++) {
            sumi = sumi + sum - input.length * input[input.length - i];
            maxSum = maxSum < sumi ? sumi: maxSum;

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {24,26,25,22};
        int[] input1 = {24,26,25,22};


        FindMaxSumOfIndexAndArrayElement obj = new FindMaxSumOfIndexAndArrayElement();

        System.out.println("Max sum = " + obj.getMaxSum(input));
        System.out.println("Max sum m2 = " + obj.getMaxSumOptimized(input1));
    }
}
