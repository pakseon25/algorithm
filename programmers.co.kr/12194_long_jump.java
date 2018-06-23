// https://programmers.co.kr/learn/courses/30/lessons/12914

import java.util.*;
class Solution {
  public long solution(int n) {
      long answer = 0;
      if (n == 1) return 1;
      else if (n == 2) return 2;

      int[][] arr = new int[n+1][];

      arr[0] = new int[] {1};
      arr[1] = new int[] {1, 1};

      for (int i = 2;i <= n;i++) {
          arr[i] = new int[i+1];
          arr[i][0] = 1;
          arr[i][i] = 1;
          for (int j = 1;j < i;j++) {
              arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 1234567;
          }
      }

      System.out.println(Arrays.toString(arr[n]));
      for (int row = n, col = 0; col < arr[row].length;row--, col++) {
          answer += arr[row][col];
          answer %= 1234567;
          // System.out.println(row + "," + col + " = " + arr[row][col] + " / " + answer);
      }
      return answer % 1234567;
  }
}

