/**
 * file: driverDFA.java
 * author: Ian Sniffen
 * course: CMPT 440
 * Project
 * due date: 5/8/2019
 *
 * Driver for the MajorTriads class.
 * Code is mainly from Mod3Filter in textbook on page 40.
 */

import java.io.*;
import java.util.Scanner;

public class driverDFA{
  public static void main(String[] args){
    String[] inpArr = new String[3];
    Scanner input = new Scanner(System.in);
    System.out.println("Input 3 notes, separated by linebreak:");
    for(int i=0;i<3;i++){
      inpArr[i]=input.nextLine();
    }
    MajorTriads m = new MajorTriads();
    m.reset();
    m.process(inpArr);
    if(m.accepted()){
      System.out.println("The input is a major triad.");
    }else{
      System.out.println("The input is not a major triad.");
    }
  }
}