package com.ask.log.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1335. Minimum Difficulty of a Job Schedule
 * Hard
 * <p>
 * 1067
 * <p>
 * 124
 * <p>
 * Add to List
 * <p>
 * Share
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * <p>
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 * <p>
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * <p>
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 * Example 2:
 * <p>
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 * <p>
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 */
public class MinimumDifficulty {

    int[] hardest;
    int jobLength;
    int totalDays;
    int[] jobDifficulty;
    Map<String, Integer> lookup = new HashMap<>();

    public static void main(String[] args) {
        MinimumDifficulty minimumDifficulty = new MinimumDifficulty();
        System.out.println(minimumDifficulty.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(minimumDifficulty.minDifficulty(new int[]{9,9,9}, 4));
        System.out.println(minimumDifficulty.minDifficulty(new int[]{1,1,1}, 3));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int hardest = 0;
        this.hardest = new int[n];
        for (int index = n - 1; index >= 0; index--) {
            hardest = Math.max(hardest, jobDifficulty[index]);
            this.hardest[index] = hardest;
        }
        this.jobLength = n;
        this.totalDays = d;
        this.jobDifficulty = jobDifficulty;

        return dp(0, 1);
    }

    private int dp(int index, int currentDay) {
        if (currentDay < 0) {
            return 0;
        }
        if (currentDay > totalDays) {
            return 0;
        }

        int remainingDaysForJob = totalDays - currentDay;
        int best = Integer.MAX_VALUE;
        int hardestVal = hardest[index];
        for (int ind = index; ind < jobLength - remainingDaysForJob; ind++) {
            hardestVal = Math.max(hardestVal, jobDifficulty[ind]);
            best = Math.min(best, hardestVal + dp(ind + 1, currentDay + 1));
        }

        return best;
    }
}
