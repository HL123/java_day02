package cn.bjut.example;

/**
 * Created by huanglei on 17/4/6.
 */
public class HelloGoodbye {
    public static void main(String[] args){
        System.out.println(decision());

        try{
            System.out.println("Hello,World!");
                System.exit(0);
        }finally{
            System.out.println("Goodbye,world!");
        }

    }

    private static boolean decision() {
        try{
            return true;
        }
        finally{
            return false;
        }
    }
}
