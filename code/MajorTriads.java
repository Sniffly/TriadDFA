/**
 * file: MajorTriads.java
 * author: Ian Sniffen
 * course: CMPT 440
 * Project
 * due date: 5/8/2019
 *
 * Contains functions that allow testing solutions
 * for major triads (1st, 3rd, and 5th)
 */
import java.io.*;

public class MajorTriads {

  private static final int q0 = 0;
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3 = 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;
  private static final int q10 = 10;
  private static final int q11 = 11;
  private static final int q12 = 12;
  private static final int q13 = 13;
  private static final int q14 = 14;
  private static final int q15 = 15;
  private static final int q16 = 16;
  private static final int q17 = 17;
  private static final int q18 = 18;
  private static final int q19 = 19;
  private static final int q20 = 20;
  private static final int q21 = 21;
  private static final int q22 = 22;
  private static final int q23 = 23;
  private static final int q24 = 24;
  private static final int q25 = 25;
  private static final int q26 = 26;
  private static final int q27 = 27;
  private static final int q28 = 28;
  private static final int q29 = 29;
  private static final int q30 = 30;
  private static final int q31 = 31;
  private static final int q32 = 32;
  private static final int q33 = 33;
  private static final int q34 = 34;
  private static final int q35 = 35;
  private static final int q36 = 36;
  private static final int q37 = 37;
  private static final int q38 = 38;
  private static final int q39 = 39;
  private static final int q40 = 40;
  private static final int q41 = 41;
  private static final int q42 = 42;
  private static final int q43 = 43;
  private static final int q44 = 44;
  private static final int q45 = 45;
  private static final int q46 = 46;
  private static final int q47 = 47;
  private static final int q48 = 48;
  private static final int q49 = 49;
  private static final int q50 = 50;
  private static final int q51 = 51;
  private static final int q52 = 52;
  private static final int q53 = 53;
  private static final int q54 = 54;
  private static final int q55 = 55;
  private static final int q56 = 56;
  private static final int q57 = 57;
  private static final int q58 = 58;
  private static final int q59 = 59;
  private static final int q60 = 60;
  private static final int qErr = 61;
  

  private int state;

  /**
   * delta
   * Contains the array matrix of transitions
   * Can be viewed in stateTransition.xlsx
   */
  static private int[][] delta =  
    {{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12},                     //q0
    {qErr,qErr,qErr,q13,q14,q15,qErr,q16,q17,q18,qErr,qErr},       //q1
    {qErr,qErr,qErr,qErr,q19,q20,q21,qErr,q22,q23,q24,qErr},       //q2
    {qErr,qErr,qErr,qErr,qErr,q25,q26,q27,qErr,q28,q29,q30},       //q3
    {q13,qErr,qErr,qErr,qErr,qErr,q31,q32,q33,qErr,q34,q35},       //q4
    {q14,q19,qErr,qErr,qErr,qErr,qErr,q36,q37,q38,qErr,q39},       //q5
    {q15,q20,q25,qErr,qErr,qErr,qErr,qErr,q40,q41,q42,qErr},       //q6
    {qErr,q21,q26,q31,qErr,qErr,qErr,qErr,qErr,q43,q44,q45},       //q7
    {q16,qErr,q27,q32,q36,qErr,qErr,qErr,qErr,qErr,q46,q47},       //q8
    {q17,q22,qErr,q33,q37,q40,qErr,qErr,qErr,qErr,qErr,q48},       //q9
    {q18,q23,q28,qErr,q38,q41,q43,qErr,qErr,qErr,qErr,qErr},       //q10
    {qErr,q24,q29,q34,qErr,q42,q44,q46,qErr,qErr,qErr,qErr},       //q11
    {qErr,qErr,q30,q35,q39,qErr,q45,q47,q48,qErr,qErr,qErr},       //q12
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q57,qErr,qErr,qErr},  //q13
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,q49,qErr,qErr,qErr,qErr},  //q14
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q54,qErr,qErr},  //q15
    {qErr,qErr,qErr,qErr,q49,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q16
    {qErr,qErr,qErr,q57,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q17
    {qErr,qErr,qErr,qErr,qErr,q54,qErr,qErr,qErr,qErr,qErr,qErr},  //q18
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q58,qErr,qErr},  //q19
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q50,qErr,qErr,qErr},  //q20
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q55,qErr},  //q21
    {qErr,qErr,qErr,qErr,qErr,q50,qErr,qErr,qErr,qErr,qErr,qErr},  //q22
    {qErr,qErr,qErr,qErr,q58,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q23
    {qErr,qErr,qErr,qErr,qErr,qErr,q55,qErr,qErr,qErr,qErr,qErr},  //q24
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q59,qErr},  //q25
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q51,qErr,qErr},  //q26
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q56},  //q27
    {qErr,qErr,qErr,qErr,qErr,qErr,q51,qErr,qErr,qErr,qErr,qErr},  //q28
    {qErr,qErr,qErr,qErr,qErr,q59,qErr,qErr,qErr,qErr,qErr,qErr},  //q29
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,q56,qErr,qErr,qErr,qErr},  //q30
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q60},  //q31
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q52,qErr},  //q32
    {q57,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q33
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,q52,qErr,qErr,qErr,qErr},  //q34
    {qErr,qErr,qErr,qErr,qErr,qErr,q60,qErr,qErr,qErr,qErr,qErr},  //q35
    {q49,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q36
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q53},  //q37
    {qErr,q58,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q38
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,q53,qErr,qErr,qErr},  //q39
    {qErr,q50,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q40
    {q54,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q41
    {qErr,qErr,q59,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q42
    {qErr,qErr,q51,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q43
    {qErr,q55,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q44
    {qErr,qErr,qErr,q60,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q45
    {qErr,qErr,qErr,q52,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q46
    {qErr,qErr,q56,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q47
    {qErr,qErr,qErr,qErr,q53,qErr,qErr,qErr,qErr,qErr,qErr,qErr},  //q48
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q49
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q50
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q51
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q52
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q53
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q54
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q55
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q56
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q57
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q58
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q59
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}, //q60
    {qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr,qErr}}; //qErr
  /**
   * reset
   * Sets int state to q0, the starting state
   */  
  public void reset() {
    state = q0;
  }
  /**
   * process
   * Takes the string input, loops through each character, and navigates the DFA
   */
  public void process(String[] in) {
    /*A=0
     *A#=1
     *B=2
     *C=3
     *C#=4
     *D=5
     *D#=6
     *E=7
     *F=8
     *F#=9
     *G=10
     *G#=11
     */
    
    for (int i = 0; i<in.length;i++) {
      String note = in[i].toLowerCase();
      int t=12;//defaults to 12 so an error can be thrown
      switch(note){//turn input notes into values
        case "a":
          t=0;
          break;
        case "a#":
          t=1;
          break;
        case "b":
          t=2;
          break;
        case "c":
          t=3;
          break;
        case "c#":
          t=4;
          break;
        case "d":
          t=5;
          break;
        case "d#":
          t=6;
          break;
        case "e":
          t=7;
          break;
        case "f":
          t=8;
          break;
        case "f#":
          t=9;
          break;
        case "g":
          t=10;
          break;
        case "g#":
          t=11;
          break;
      }
      try {
        state = delta[state][t];
      }
      catch (ArrayIndexOutOfBoundsException ex) {
        state = qErr;
      }
    }
  }
  /**
   * accepted
   * returns true if state == the accepted state (q9) as per the DFA
   */
  public boolean accepted() {
    if(state>=q49&&state<=q60){
      switch(state){
        case q49:
          System.out.println("A Major");
          break;
        case q50:
          System.out.println("A# / Bb Major");
          break;
        case q51:
          System.out.println("B Major");
          break;
        case q52:
          System.out.println("C Major");
          break;
        case q53:
          System.out.println("C# / Db Major");
          break;
        case q54:
          System.out.println("D Major");
          break;
        case q55:
          System.out.println("D# / Eb Major");
          break;
        case q56:
          System.out.println("E Major");
          break;
        case q57:
          System.out.println("F Major");
          break;
        case q58:
          System.out.println("F# / Gb Major");
          break;
        case q59:
          System.out.println("G Major");
          break;
        case q60:
          System.out.println("G# / Ab Major");
          break;
      }
      return true;
    }
    return false;
  }
}