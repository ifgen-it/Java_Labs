package practice6;

public class Writer implements Runnable {

    public Thread t;
    public String name;
    public DataBase db;
    public MySemaphore s;
    private volatile boolean isRunning;

    public Writer(String Name, DataBase DB, MySemaphore S) {
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

//            int sleepTime = 500 + (int)(Math.random() * 2000);
//            System.out.println("    " + name + " is sleeping.." + sleepTime + " ms");
//            
//            try {
//                t.sleep(sleepTime);
//            } catch (InterruptedException ex) {
//                System.out.println("Error in writer");
//            }
            System.out.println("    " + name + " is waiting");

            s.wannaWrite();

            db.writeDB();

            s.wasWritten(this);
        }

    }

    public void kill() {
        isRunning = false;
    }
}
