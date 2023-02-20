import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test12_ArrayListIndex {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        int n = 5;
        int m = list.size() / 5;
        int reminder = list.size() % 5;

        for (int i = 0; i <= m; i++) {
            int from = n * i;
            int to = 0;
            if (i == m) {
                if (reminder > 0) {
                    to = list.size();
                } else {
                    to = n * (i);
                }
            } else {
                to = n * (i + 1);
            }
            List<Integer> sublist = new ArrayList<>();
//            List<Integer> sublist = list.subList(from, to);
            sublist = list.subList(from, to);
            if (sublist.size() > 0) {
                System.out.println(sublist);
            }
            System.out.println(sublist.getClass().getName() + "<" + sublist.get(0).getClass().getName() + ">");
        }
//        System.out.println(list.subList(13, 13));
        System.out.println(list.getClass().getName() + "<" + list.get(0).getClass().getName() + ">");
    }
}
