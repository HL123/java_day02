package cn.bjut.example;

/**
 * Created by huanglei on 17/4/6.
 */
public class LastLaugh {
    public static void main(String[] args) {
        System.out.println("H" + "a");
        System.out.println('H' + 'a');


        System.out.println(""+'H' + 'a');


        System.out.println(String.valueOf('H')+'a');


        StringBuffer sb = new StringBuffer();
        sb.append('H');
        sb.append('a');
        System.out.println(sb.toString());


        System.out.printf("%s"+'a','H');
    }
}
