//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Student Name: 
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world!");

    Lab1 lab = new Lab1();
    System.out.println(lab.increment(1));

    int[] numbers =  {5, 9, 3, 12, 7, 3, 11, 5};

  
  //Output the array in order using a while loop.
    int counter= 0;
    while (counter < numbers.length){
      System.out.println(numbers[counter]);
      counter+=1;
    }


  //Output the array in reverse using a for loop.
  for( int i= numbers.length-1; i >= 0; i--){
    System.out.println(numbers[i]);
  }

  //Output the first and last values of the array.
  System.out.println("First value : "+ numbers[0]); 
  System.out.println("Last  value : "+ numbers[numbers.length-1]); 



  // max value 
  System.out.println("Max value: " + lab.max(20,30));

  // min value
  System.out.println("Min value: " + lab.min(20,30));


  //sum of the array 
  System.out.println("Sum: " + lab.sum(numbers));

  //Average of the array 
  System.out.println("Average: " + lab.average(numbers));


  //Max value  of the array 
  System.out.println("Max Value in the array : " + lab.max(numbers));


  //Min value  of the array 
  System.out.println("Min Value in the array : " + lab.min(numbers));
   
  }
}     





// Add all of the methods here
class Lab1 {

  public int increment(int num) {
    return ++num;
  }

  //max method
  public int max(int a , int b){
    if(a >=b){
      return a;
    }
    else{
      return b;
    }
  }


  //min method
  public int min(int a ,int b){
    if ( a <= b){
      return a;
    }
    else{
       return b;
    }
  }

  // sum method
  public int sum(int[] nums){
    int total= 0;
    for (int i=0 ;i < nums.length; i++){
      total= total + nums[i];
    }
    return total;

  }


  //average method
  public double average(int[] nums){
    int total = 0;
    for (int i : nums) {
      total = total + i;
      
    }
    double average = (double) total/nums.length;

    return average ;
  }

  //maximum value in an array method 
  public int max(int[] nums){
    int max_value= nums[0];
    for (int i= 1; i < nums.length; i++){
      if( nums[i] > max_value){
        max_value= nums[i];
      }
    }
    return max_value;
  }

//minimum value in an array method
public int min(int[] nums){
  int min_value= nums[0];
  for (int i=1; i < nums.length; i++){
    if(nums[i] < min_value){
      min_value= nums[i];
    }
  }
  return min_value;
}

  

}