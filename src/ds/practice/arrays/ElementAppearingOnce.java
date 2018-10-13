package ds.practice.arrays;

public class ElementAppearingOnce {

    public static void main(String[] args) {
        int[] array = {5, 5, 4, 8, 4, 5, 8, 9, 4, 8};
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
            System.out.println(result);
        }

        System.out.println("Element appearing only once: "+ result);
    }
}
