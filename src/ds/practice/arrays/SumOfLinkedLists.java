package ds.practice.arrays;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Stack;

// Sum of two linked lists using stacks
public class SumOfLinkedLists {

    public LinkedList<Integer> getLinkedList(int number) {
        LinkedList<Integer> ll = new LinkedList<>();
        String numbers = Integer.toString(number);
        for (int i = 0; i < numbers.length(); i++) {
            ll.add(Character.getNumericValue(numbers.charAt(i)));
        }

        return ll;
    }

    public LinkedList<Integer> getSum(int number1, int number2) {
        int carry = 0;
        int sum = 0;
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        Stack<Integer> res = new Stack<>();

        LinkedList<Integer> n1 = getLinkedList(number1);
        LinkedList<Integer> n2 = getLinkedList(number2);
        LinkedList<Integer> result = new LinkedList<>();

        while (!n1.isEmpty())
            num1.add(n1.remove());
        while (!n2.isEmpty())
            num2.add(n2.remove());

        while (!num1.isEmpty() || !num2.isEmpty()) {
            sum = carry;
            if(!num1.isEmpty())
                sum = sum + num1.pop();
            if(!num2.isEmpty())
                sum = sum + num2.pop();

            res.add(sum%10);
            carry = sum / 10;
        }

            if (carry != 0)
                res.add(carry);

        while (!res.isEmpty())
            result.add(res.pop());


        return result;
    }

    public static void main(String[] args) {
        int number1 = 99971;
        int number2 = 998;

        LinkedList<Integer> result = new SumOfLinkedLists().getSum(number1, number2);
        for (int i :
                result) {
            System.out.print(i + "->");
        }


    }
}
