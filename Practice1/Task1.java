package Practice1;

import java.util.Scanner;

public class Task1 {

  public static void Decision(){
   
   System.out.println("Task1");
   System.out.println("Input x y z:");
   
   int x,y,z;
   Scanner in = new Scanner(System.in);
   
   x = in.nextInt();
   y = in.nextInt();
   z = in.nextInt();
   
   int A, B, C, Temp;
   
   A = x; B = y; C = z;
   if (x > y)
   {
     A = y; B = x;
   }
   
   if (A > C)
   {
     Temp = A; A = C; C = Temp; 
   }
   
   if (B > C)
   {
     Temp = B; B = C; C = Temp;
   }
   System.out.println("Sorted x, y, z ASC:");
   
   System.out.println(A + " "+B+" "+C);
  }
  
}
