package practice6;

public class MySemaphore {

    private int writerPermits;
    private int readerPermits;
    private int maxWP;
    private int maxRP;

    private MyTimer timer;
    private long timerInterval;
    private boolean stopRead;
    private boolean reading;
    private boolean allSuspend;
    private boolean allStop;

    public MySemaphore(int WPermits, int RPermits) {
        writerPermits = maxWP = WPermits;
        readerPermits = maxRP = RPermits;

        timer = new MyTimer();
        timerInterval = Main.MAX_READER_TIME;
        stopRead = false;
        reading = false;
        allSuspend = false;
        allStop = false;
    }

    public synchronized void wannaWrite() {
        while (writerPermits < maxWP || readerPermits < maxRP || allSuspend) {
            try {
                wait();

            } catch (InterruptedException ex) {
                System.out.println("Error in MySemaphore - wannaWrite while");
            }
        }

        writerPermits--;
    }

    public synchronized void wasWritten(Writer Wr) {

        if (allStop) {
            Wr.kill();
        }

        writerPermits++;
        stopRead = false;
        notifyAll();
    }

    public synchronized void wannaRead() {
        while (readerPermits <= 0 || writerPermits < maxWP || stopRead || allSuspend) {
            try {
                wait();

            } catch (InterruptedException ex) {
                System.out.println("Error in MySemaphore - wannaRead while");
            }
        }

        readerPermits--;
        if (reading == false) {
            timer.start();
            reading = true;
        } else {
            if (timer.getTime() > timerInterval) {
                stopRead = true;
                timer.stop();
                reading = false;
            }

        }

    }

    public synchronized void wasRead(Reader Rd) {

        if (allStop) {

            Rd.kill();
        }
        readerPermits++;
        notifyAll();
    }

    public int getCountOfReaders() {
        return maxRP - readerPermits;
    }

    public void setAllSuspend() {
        if (!allSuspend) {

            allSuspend = true;
            System.out.println("\n    SUSPEND:");
        }
    }

    public synchronized void setAllResume() {
        if (allSuspend) {

            allSuspend = false;
            System.out.println("\n    RESUME:");
            notifyAll();
        }
    }

    public void setAllStop() {
        if (!allStop) {
            allStop = true;
            System.out.println("\n    STOP:");
        }
    }

}
