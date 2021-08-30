package net.t.thread;

/**
 * @Author tai
 * @create 2021-08-03 13:16
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(System.currentTimeMillis());


        Runnable r1 = () -> {
            try {
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("r1");
        };

        Runnable r2 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("r2");
        };

        Thread t1 = new Thread(r1);
        //t1.start();
        Thread t2 = new Thread(r2);
        //t2.start();

        System.out.println("============= r1 ===========");
        t1.join();
        System.out.println("============= r2 ===========");
        t2.join();

        t1.start();
        t2.start();
        System.out.println("main");

    }
}
