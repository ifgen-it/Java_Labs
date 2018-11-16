package Practice1;

import java.util.Scanner;

public class Task2 {

  public static void Decision(){
   
   System.out.println("Task2");
   System.out.println("Input dimension of array:");
   
   int x;
   Scanner in = new Scanner(System.in);
   x = in.nextInt();
   
   System.out.println("Input number between 1 and 10:");
   
   int Counter = in.nextInt();
   
   int[][] Arr = new int[x][];
   for (int i = 0; i < Arr.length; i++)
   {
     Arr[i] = new int[i+1];
   }
   
   // заполнение массива
   for (int i=0; i<Arr.length; i++)
   {
     for (int j=0; j<Arr[i].length; j++)
     {
       Arr[i][j] = Counter;
       Counter += 3;
      // Arr[i][j] = in.nextInt();
     }
   }
   System.out.println();
   
   // печать
   PrintArr(Arr);
  
  // поиск числа в массиве,самого близкого к 
  FindNearestInArr(Arr, 25);
  
  }
  
 public static void PrintInt(int x)
 {
   System.out.println(x);
 }
 
 public static void PrintArr(int[][] Arr)
 {
   
    // печать
   for (int[] R:Arr)
   {
     for (int b:R)
     {
       System.out.print(b + " ");
     }
     System.out.println();
   }
   
 }
 
 public static void FindNearestInArr(int[][] Arr, int Base)
 {
   int Min = Math.abs( Arr[0][0] - Base );
   int MinI = 0;
   int MinJ = 0;
   
   for (int i =0;i<Arr.length;i++)
   {
     for (int j=0;j<Arr[i].length;j++)
     {
      int Temp = Math.abs( Arr[i][j] - Base );
     
       if ( Temp < Min)
       {
         Min = Temp;
         MinI = i;
         MinJ = j;
       }
     }
   }
   
   System.out.println("\nThe nearest to " + Base + " is Arr[" + MinI + "][" + MinJ +"] = " + Arr[MinI][MinJ]);
   
 }
}
