import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author tai
 * @create 2021-08-04 9:45
 */
public class ViolatileDemo {
    private static boolean ready = false;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
