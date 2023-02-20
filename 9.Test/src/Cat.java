public class Cat
{
    public static void print(Object o)
    {
        System.out.println(o);
    }
    public static void print(String s)
    {
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        Cat.print(1);
        Cat.print(null);
    }
}