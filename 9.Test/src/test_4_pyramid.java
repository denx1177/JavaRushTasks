import java.util.Scanner;

public class test_4_pyramid {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int height = console.nextInt();
        String[][] pyramid = new String[height][height * 2 - 1];
        System.out.println(pyramid[0].length);

        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                if ((j > (pyramid[i].length / 2 - 1 - i)) && (j < (pyramid[i].length/2 + 1 + i))) {
                    pyramid[i][j] = "#";
                } else {
                    pyramid[i][j] = "";
                }
            }
        }
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] != "" ? pyramid[i][j] : " ");
            }
            System.out.println("");
        }
    }
}
