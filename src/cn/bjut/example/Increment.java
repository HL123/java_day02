package cn.bjut.example;

/**
 * Created by huanglei on 17/4/6.
 */
public class Increment {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);


        int m = 0;
        m= m++;
        System.out.println(m);

    }
}
