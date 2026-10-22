package String.class_problems;

public class ReverseString {
    public static void main(String[] args) {
        String text = "hello";
        String reversed = new StringBuilder(text).reverse().toString();
        System.out.println(reversed);
    }
}