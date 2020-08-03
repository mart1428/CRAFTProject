package com.sideproject.craftproject;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;

public class CraftProject {
    public static void main(String[] args) {
        System.out.println("Number of possibilities: "+ permutation(6,6));
        layoutGen(6);
    }

    public static int factorial(int base) {
        int answer = base;
        for (int i = 6; i > 0; i--) {
            if (i != 1) {
                answer = answer * (i - 1);
            } else {
                answer = answer * (i);
            }
        }
        if (answer == 0) {
            answer = 1;
        }
        return answer;
    }

    public static int permutation(int n, int k) {
        int numerator = factorial(n);
        int denominator = factorial(n - k);
        int answer = numerator / denominator;
        return answer;
    }

    public static void layoutGen(int numDepts) {
        Random random = new Random();
        //initialize "random" as an object name for the "Random" class, so we can use functions from the class
        int numPossibilities = permutation(numDepts, numDepts);
        //assuming that all departments are split on equal area size, and that all departments are given equal spaces
        String layoutStrValid = "";
        //initialize layoutStrValid variable
        for (int i = 1; i <= numPossibilities; i++) {
            String layoutStrBeingTested = "";
            //resets "layoutStrBeingTested" variable when a loop is done
            int nextIntInt = -1;
            //since there is no null value for int, since its a primitive type, basically resets nextIntInt value 
            for (int j = 1; j <= numDepts; j++) {
                int newIntInt = 0;
                if (j == 4) {
                    String lineBreak = ("\n");
                    layoutStrBeingTested = layoutStrBeingTested + lineBreak;
                    //allows 2x3 orientation, in case for a 6 department generation
                }
                while (newIntInt == 0) {
                    newIntInt = random.nextInt(numDepts + 1);
                    //since value is 0 <= Value < (numDepts + 1); value <= numDepts
                }
                //while function is to check such that the int that's converted into str is not 0
                if (newIntInt != nextIntInt) {
                    String newIntStr = Integer.toString(newIntInt);
                    layoutStrBeingTested = layoutStrBeingTested + newIntStr;
                    newIntInt = nextIntInt;
                    //WRONG!! need to store this as array in the future, cuz we need to check all possibilities
                    //whether the newly generated number from .random class has already been used beforehand
                    //numbers gaboleh double" soalnya
                }
            }
            if (layoutStrBeingTested != layoutStrValid) {
                layoutStrBeingTested = layoutStrValid;
                System.out.print(layoutStrValid);
            }
        }
    }
}

// note that this current algorithm does not take into account the possibilities of layout being similar to -
// ALL the previous layout generated
// Line 48, int is a primitive type but there's a class called Integer with a null value
