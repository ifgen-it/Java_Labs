package practice6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader implements Runnable {

    public Thread t;
    public String name;
    public DataBase db;
    public MySemaphore s;
    private volatile boolean isRunning;

    public Reader(String Name, DataBase DB, MySemaphore S) {
        name = Name;
        db = DB;
        s = S;
        isRunning = true;
        t = new Thread(this, Name);
        t.start();

    }

    @Override
    public void run() {

        while (isRunning) {

//            int sleepTime = 200 + (int)(Math.random() * 700);
//            System.out.println("    " + name + " is sleeping.." + sleepTime + " ms");
//            
//            try {
//                t.sleep(sleepTime);
//            } catch (InterruptedException ex) {
//                System.out.println("Error in reader");
//            }
            System.out.println("    " + name + " is waiting");

            s.wannaRead();

            db.readDB(this);

            s.wasRead(this);
        }
    }

    public void kill() {
        isRunning = false;
    }
}
