package Practice2;

public class Vector extends Matrix {

    public Vector() {
    }

    public Vector(int n) throws MatrixException {
        super(n, 1);
    }

    Vector(int n, int value) throws MatrixException {
        super(n, 1, value);
    }

    double length() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(Arr[i][0], 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public void set(int i, int j, int value) throws MatrixException {
        if (j != 0) {
            System.out.println("Column will set equal 0, because Vector is the Matrix with 1 column");
            j = 0;
        }

        if (i < 0 || i >= this.n) {
            throw new MatrixException("Was attempt to set out of bound vector's dimention");
        }
        Arr[i][j] = value;
    }

    void set(int i, int value) throws MatrixException {

        set(i, 0, value);
    }

    @Override
    public int at(int i, int j) throws MatrixException {
        if (j != 0) {
            System.out.println("Column will set equal 0, because Vector is the Matrix with 1 column");
            j = 0;
        }

        if (i < 0 || i >= this.n) {
            throw new MatrixException("Was attempt to get out of bound vector's dimention");
        }
        return Arr[i][j];
    }

    public int at(int i) throws MatrixException {
        return at(i, 0);
    }


}
