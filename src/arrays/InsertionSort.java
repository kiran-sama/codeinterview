package arrays;

import java.util.Date;

/**
 * Created by ksama on 2/2/16.
 */
public class InsertionSort {

  public void insertionSort(int[] input){
    for(int i=1;i<input.length;i++){
       int j = i;
       while(j>0 && input[j-1] > input[j]){
         input[j-1] = input[j-1]+input[j];
         input[j] = input[j-1]-input[j];
         input[j-1] = input[j-1]-input[j];
         j--;
       }
    }
  }

  public static void main(String[] args){
    int[] ints = new int[1000000];
    for(int i=0;i<1000000;i++){
      ints[i]=1000000-i;
    }
    InsertionSort sorter = new InsertionSort();
    long start = System.currentTimeMillis();
    System.out.println("Sorting started at:" + new Date(start));
    sorter.insertionSort(ints);
    long end = System.currentTimeMillis();
    System.out.println("Sorting started at:" + new Date(end));
    System.out.println("Total Time Taken In Seconds:"+(end-start)/1000);
  }
}
