package practice6;

public class DataBase {

    public int data;
    private int readersTime;
    private int writersTime;
    
    private MyJFrame frame;

    public DataBase(MyJFrame Frame) {

        data = 0;
        readersTime = 0;
        writersTime = 0;
        frame = Frame;
    }

    public void writeDB() {

        try {

            int workTime = 3000 + (int) (Math.random() * 5000);

            System.err.println(">>> " + Thread.currentThread().getName().toUpperCase() + " IS WRITING..." + workTime + " ms");
            Thread.currentThread().sleep(workTime);
            writersTime += workTime;
            frame.setWritersResult(writersTime);
            
            data++;
            System.out.println("<<< " + Thread.currentThread().getName() + " finished. Data = " + data);
            Thread.currentThread().sleep(1000);

        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception in " + Thread.currentThread().getName());
        }
    }

    public void readDB(Reader reader) {

        try {

            int workTime = 3000 + (int) (Math.random() * 5000);

            System.err.println("--> " + Thread.currentThread().getName().toUpperCase() + " IS READING..." + workTime + " ms"
                    + "  Reader Count = " + reader.s.getCountOfReaders());
            Thread.currentThread().sleep(workTime);
            readersTime += workTime;
            frame.setReadersResult(readersTime);
            
            System.out.print("<-- " + Thread.currentThread().getName() + " finished. Data = ");
            System.out.printf("%-3d", data);
            System.out.println("  Reader Count = " + (reader.s.getCountOfReaders()-1) );

            Thread.currentThread().sleep(1000);

        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception in " + Thread.currentThread().getName());
        }
    }
}
