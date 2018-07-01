// https://www.hackerrank.com/challenges/a-chessboard-game-1/problemac

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the chessboardGame function below.
    static String chessboardGame(int x, int y) {
        Map<String, Boolean> memo = new HashMap<>();
        boolean result = dp(x, y, true, memo);
        // System.out.println(result);
        if (result) return "First";
        return "Second";
    }
    
    static final int[][] dir = new int[][] {{-2, 1}, {-2, -1}, {1, -2}, {-1, -2}};
    static final int numOfDir = dir.length;
    
    static boolean dp(int x, int y, boolean isFirst, Map<String, Boolean> memo) {
        
        int moves = 0;
        
        if (memo.containsKey(x + "," + y)) {
            return memo.get(x + "," + y);
        }
        for (int i = 0;i < numOfDir;i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 1 && nx <= 15 && ny >= 1 && ny <= 15) {
                boolean res = dp(nx, ny, !isFirst, memo);
                if (res == isFirst) {
                    moves++;
                }
            }
        }
        
        // System.out.println(x + "," + y + "," + isFirst);
        if (moves == 0) {
            memo.put(x + "," + y, !isFirst);
            return !isFirst;
        }
        memo.put(x + "," + y, isFirst);
        return isFirst;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            String result = chessboardGame(x, y);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

