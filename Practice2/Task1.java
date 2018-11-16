package Practice2;

public class Task1 {

    public static void Decision() {

        try {

            System.out.println("Task1\n");

            Matrix m1 = new Matrix(3, 9);
            Matrix.FillMatrix(m1, 6);
            m1.output();

            // печать в файл
            // String fn = "/storage/emulated/0/Java/matrix.txt";
            String fn = "matrix.txt";
            m1.write(fn);

            // считывание из файла
            Matrix m2 = Matrix.read(fn);
            System.out.println();
            m2.output();

            Matrix m3 = new Matrix(4, 9, 3);

            // складывание
            // m3 = null;
            Matrix m4 = m1.add(m3);
            System.out.println();
            m4.output();

            // сравнение
            boolean eq = m1.equal(m3);
            System.out.println("\nMatrix m1 equal m3 : " + eq);

            Vector v1 = new Vector(6, 5);
            Matrix.FillMatrix(v1, 4);
            v1.set(1, 0, 111);
            System.out.println();
            v1.output();

            double len = v1.length();
            //String len1 = v1.lengthRound(4);
            System.out.println("\nv1 length: " + len);

        } catch (MatrixException me) {
            System.out.println(me.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
