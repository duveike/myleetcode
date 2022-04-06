package com.duweike.lc134;

public class LeetCode134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int remain=0;
        int debet=0;
        int idx=0;
        int len=gas.length;
        for(int i=0;i<len;i++)
        {
            remain+=gas[i]-cost[i];
            if(remain<0)
            {
                debet+=remain;
                idx=i+1;
                remain=0;
            }
        }
        return remain+debet>=0?idx:-1;

       /* int[] gas2 = new int[2*gas.length];
        int[] cost2 = new int[2*cost.length];
        for(int i=0;i<gas.length;i++) {
            gas2[i] = gas[i];
            gas2[i+gas.length] = gas[i];

            cost2[i] = cost[i];
            cost2[i+gas.length] = cost[i];

        }

        int sum = 0;
        for(int i=0;i<gas.length;) {
            if(cost[i]>sum+gas[i]) {
                i++;
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
                else i=j;
            }
            sum = 0;
        }
        return -1;*/
    }

    public static void main(String[] args) {

        int[]gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));


    }
}
