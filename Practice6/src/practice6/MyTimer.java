package practice6;

public class MyTimer {

    private long beginTime;

    MyTimer() {
        beginTime = 0;
    }

    public void start() {
        beginTime = System.currentTimeMillis();
    }

    public void stop() {
        beginTime = 0;
    }

    public void reset(){
        beginTime = System.currentTimeMillis();
    }
    
    public long getTime() {
        return System.currentTimeMillis() - beginTime;
    }

}
