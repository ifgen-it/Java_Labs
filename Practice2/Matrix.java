package Practice2;

import java.util.Scanner;
import java.io.*;

public class Matrix {

    protected int n;
    private int m;
    protected int[][] Arr;

    public Matrix() {
        n = m = 0;
        Arr = null;
    }

    public Matrix(int n, int m) throws MatrixException {
        if (n <= 0 || m <= 0) {
            throw new MatrixException("Parameters for dementions of Matrix must be positive");
        }
        this.n = n;
        this.m = m;

        Arr = new int[n][m];
    }

    public Matrix(int n, int m, int value) throws MatrixException {
        if (n <= 0 || m <= 0) {
            throw new MatrixException("Parameters for dementions of Matrix must be positive");
        }

        this.n = n;
        this.m = m;

        Arr = new int[n][m];
        for (int[] r : Arr) {
            for (int i = 0; i < r.length; i++) {
                r[i] = value;
            }
        }
    }

    public boolean equal(Matrix m1) throws MatrixException {
        if (m1 == null) {
            throw new MatrixException("Parameter - Matrix is null. Cannot make equation");
        }
        if (n != m1.rows() || m != m1.cols()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Arr[i][j] != m1.at(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix add(Matrix m1) throws MatrixException {
        if (m1 == null) {
            throw new MatrixException("Parameter - Matrix is null. Cannot make addition with null");
        }
        if (n != m1.rows() || m != m1.cols()) {
            throw new MatrixException("Cannot make addition: matrixes has different dimensions!");
        }

        Matrix m3 = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                m3.set(i, j, Arr[i][j] + m1.at(i, j));
            }
        }
        return m3;
    }

    public void write(String fn) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fn);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    fw.write(Arr[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Cannot close file: " + e.getMessage());
            }
        }
    }

    public static Matrix read(String fn) throws MatrixException {

        int i = 0;
        int j = 0;

        try (FileReader fr = new FileReader(fn)){
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                if (i == 0) {
                    String Temp = scan.nextLine();
                    Scanner s1 = new Scanner(Temp);
                    while (s1.hasNextInt()) {
                        int buff = s1.nextInt();
                        j++;
                    }
                    i++;
                }
                i++;
                String Temp = scan.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        //creation of new Matrix
        Matrix m1 = new Matrix(i, j);

        try (FileReader fr = new FileReader(fn)){
            
            Scanner scan1 = new Scanner(fr);
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < j; b++) {
                    m1.set(a, b, scan1.nextInt());
                }
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return m1;

    }

    public int rows() {
        return n;
    }

    public int cols() {
        return m;
    }

    public void set(int i, int j, int value) throws MatrixException {
        if ((i < 0 || i >= n) || (j < 0 || j >= m)) {
            throw new MatrixException("Parameters of Matrix are out of range");
        }
        Arr[i][j] = value;
    }

    public int at(int i, int j) throws MatrixException {
        if ((i < 0 || i >= n) || (j < 0 || j >= m)) {
            throw new MatrixException("Parameters of Matrix are out of range");
        }
        return Arr[i][j];
    }

    public void output() {
        if (Arr != null) {
            for (int i = 0; i < Arr.length; i++) {
                for (int j = 0; j < Arr[i].length; j++) {
                    System.out.print(Arr[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is not defined");
        }
    }
    
    static void FillMatrix(Matrix m1, int Starter) throws MatrixException {
        for (int i = 0; i < m1.rows(); i++) {
            for (int j = 0; j < m1.cols(); j++) {
                m1.set(i, j, Starter++);
            }
        }
    }

}
