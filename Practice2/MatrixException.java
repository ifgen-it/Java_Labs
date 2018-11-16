package Practice2;

public class MatrixException extends Exception {

       public MatrixException(String msg) {

        super(msg);
    }

    @Override
    public String toString() {
       
        return getMessage();
    }
}
