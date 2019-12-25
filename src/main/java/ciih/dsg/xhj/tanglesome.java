package ciih.dsg.xhj;

public class tanglesome implements Runnable{
    static tanglesome tan = new tanglesome();
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(tan);
        Thread t2 = new Thread(tan);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++){
            i++;
        }
    }
}
