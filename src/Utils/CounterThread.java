package Utils;

public class CounterThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {  //int i = number of seconds in AFK usage.
                System.out.println("" + i);
                Thread.sleep(1000);
            }
        } catch (Exception aC){
            System.err.print(aC.getMessage());
        }
    }
}
