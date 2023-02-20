class parentA {
    public parentA(){
//        System.out.println("parent no args");
    }
    public parentA(String s){
        System.out.println("A");
    }
}

class B extends parentA {
    public B (){
//        super("");
        System.out.println("Empty");
    }
    public B (String s){
//        super(s);
        System.out.println(s);
    }

    public static void main(String[] args) {
        new B("AB");
    }
}
