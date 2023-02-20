package teststring;

public class TestString {
    public static void main(String[] args) {
        String s = "3 + 6 = ";
        Integer c = 9;
        String result = s;
        result = result.replaceAll("\\n", "'");
        result = result + c;
        System.out.println(result);
    }
}
