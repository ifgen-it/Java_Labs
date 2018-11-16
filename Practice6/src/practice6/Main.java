package practice6;

import java.awt.GraphicsEnvironment;
import java.io.PrintStream;

public class Main {

    public static final int MAX_WRITER_PERMITS = 1;
    public static final int MAX_READER_PERMITS = 3;
    public static final long MAX_READER_TIME = 10000; // is the time for not interrupted reading for readers
    public static boolean startRace = false;
    
    public static void main(String[] args) {

//        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for (int i = 0; i < fonts.length; i++) {
//            System.out.println(fonts[i]);
//        }

        MySemaphore s1 = new MySemaphore(MAX_WRITER_PERMITS, MAX_READER_PERMITS);
        MyJFrame frame = new MyJFrame(s1);

        // redirection stdout from Console to the JTextArea
        PrintStream printStream = new PrintStream(new CustomOutputStream(frame.tResult));
        System.setOut(printStream);
        System.setErr(printStream);
        
        // main action
        DataRacing(s1, frame);
    

}
    
    public static void DataRacing(MySemaphore s1, MyJFrame frame) {
       
        
        try {

            DataBase d1 = new DataBase(frame);
            System.out.println("Main starts. Data = " + d1.data + "\n");

           // MySemaphore s1 = new MySemaphore(MAX_WRITER_PERMITS, MAX_READER_PERMITS);

            Writer w1 = new Writer("w1", d1, s1);
            Writer w5 = new Writer("w5", d1, s1);

            Reader r1 = new Reader("r1", d1, s1);
            Writer w2 = new Writer("w2", d1, s1);

            Reader r2 = new Reader("r2", d1, s1);
            Reader r3 = new Reader("r3", d1, s1);

            Writer w3 = new Writer("w3", d1, s1);

            Reader r4 = new Reader("r4", d1, s1);
            Reader r5 = new Reader("r5", d1, s1);

            Writer w4 = new Writer("w4", d1, s1);

            // Writers writes here
            // Readers reads here
            
            w1.t.join();
            w2.t.join();
            w3.t.join();
            w4.t.join();
            w5.t.join();

            r1.t.join();
            r2.t.join();
            r3.t.join();
            r4.t.join();
            r5.t.join();

            Thread.sleep(1000);
            System.out.println("\nMain finished. Data = " + d1.data);

        } catch (InterruptedException ex) {
            System.out.println("InterruptedException in Main");
        }
    }

}
