package com.home.nahusha.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClimbingLadder {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int length = deDup(scores);
        int[] ranks = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            ranks[i] = bin_search(scores, length, alice[i]) + 1 ;
        }
        return ranks;
    }

   
    static int deDup(int[] dup) {
    	int j = 0;
    	for (int i = 0; i < dup.length - 1; i++) {
    		if (dup[i] != dup[i+1]) {
    			dup[j++] = dup[i];
    		}
    	}
    	dup[j] = dup[dup.length - 1];
    	return j;
    }
    
    private static int bin_search(int [] arr, int n, int key) {
    	int lo = 0, hi = n;
    	while (lo <= hi) {
    		int mid = lo + (hi - lo)/2;
    		if (arr[mid] < key)
    			hi = mid - 1;
    		else if (arr[mid] > key)
    			lo = mid + 1; 
    		else
    			return mid;
    	}
    	return lo;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}