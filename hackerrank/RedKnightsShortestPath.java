// https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Print the distance along with the sequence of moves.
        
        if (impossible(n, i_start, j_start, i_end, j_end)) {
            System.out.println("Impossible");
        }
        else {
            int ul = 0;
            int ur = 0;
            int r = 0;
            int lr = 0;
            int ll = 0;
            int l = 0;
            
            while (i_start != i_end || j_start != j_end) {         
                if (i_start > i_end) {
                    if (j_start >= j_end) {
                        i_start -= 2;
                        j_start -= 1;
                        ul++;
                    }
                    else {
                        i_start -= 2;
                        j_start += 1;
                        ur++;
                    }
                }
                else if (i_start < i_end) {
                    if (j_start <= j_end) {
                        i_start += 2;
                        j_start += 1;
                        lr++;
                    }
                    else {
                        i_start += 2;
                        j_start -= 1;
                        ll++;
                    }
                }
                else {
                    if (i_start == i_end && j_start <= j_end) {
                        j_start += 2;
                        r++;
                    }
                    else {
                        j_start -= 2;
                        l++;
                    }
                }
            }
            
            
            StringJoiner joiner = new StringJoiner(" ");
            for (int i = 0;i < ul;i++) {
                joiner.add("UL");
            }
            
            for (int i = 0;i < ur;i++) {
                joiner.add("UR");
            }
            
            for (int i = 0;i < r;i++) {
                joiner.add("R");
            }
            
            for (int i = 0;i < lr;i++) {
                joiner.add("LR");
            }
            
            for (int i = 0;i < ll;i++) {
                joiner.add("LL");
            }
            
            for (int i = 0;i < l;i++) {
                joiner.add("L");
            }
            
            int moves = ul + ur + r + lr + ll + l;
            System.out.println(moves);
            System.out.println(joiner.toString());
        }
    }
    
    static boolean impossible(int n, int i_start, int j_start, int i_end, int j_end) {
        int xSub = Math.abs(j_start - j_end );
        int ySub = Math.abs(i_start - i_end);
        if ((ySub % 2) == 1) {
            return true;
        }
        else if ((ySub % 4) == 0) {
            if ((xSub % 2) == 0) {
                return false;
            }

            return true;
        }
        else {
            if ((xSub % 2) == 0) {
                return true;
            }
            
            return false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}
