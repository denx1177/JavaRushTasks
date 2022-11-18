public class Cat3 {
        public int a = getSum();
        public int b = getSum() - a;
        public int c = getSum() - a - b;

        public int getSum()
        {
            return a + b + c;
        }

    public static void main(String[] args) {
        System.out.println(new Cat3().a);
        System.out.println(new Cat3().b);
        System.out.println(new Cat3().c);
    }
}
