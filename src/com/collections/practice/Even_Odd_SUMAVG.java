package com.collections.practice;

import java.util.*;

public class Even_Odd_SUMAVG {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,6,5,2,1,7,2,1,2));
        int e_sum=0,o_sum=0,e_count=0,o_count=0;
        double e_avg,o_avg;
        for(int x:list){
            if((x&1)==0){
                e_count++;
                e_sum+=x;
            }
            else{
                o_count++;
                o_sum+=x;
            }
        }
        e_avg=(double)e_sum/e_count;
        o_avg=(double)o_sum/o_count;
        System.out.println("Even Sum:"+e_sum+" "+"Even Avg:"+e_avg);
        System.out.println("Odd Sum:"+o_sum+" "+"Odd Avg:"+o_avg);
    }
}
