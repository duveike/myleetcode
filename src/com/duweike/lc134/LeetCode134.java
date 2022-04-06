package com.duweike.lc134;

public class LeetCode134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gas2 = new int[2*gas.length];
        int[] cost2 = new int[2*cost.length];
        for(int i=0;i<gas.length;i++) {
            gas2[i] = gas[i];
            gas2[i+gas.length] = gas[i];

            cost2[i] = cost[i];
            cost2[i+gas.length] = cost[i];

        }

        int sum = 0;
        for(int i=0;i<gas.length;i++) {
            if(cost[i]>sum+gas[i]) {
                continue;
            } else {
                int j=i;
                for(;j<i+gas.length;j++) {
                    if(cost2[j]>sum+gas2[j]) break;
                    else {
                        sum += gas2[j]-cost2[j];
                    }

                }
                if(j >= i+gas.length) return i;
            }
            sum = 0;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
