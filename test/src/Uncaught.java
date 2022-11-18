public class Uncaught {
    public static void main(String[] args) throws ArithmeticException {
        try {
            for (int i = 3; i >=0 ; i--) {
                System.out.println(10 / i);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
