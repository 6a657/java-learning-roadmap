package com.example.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = {5,3,9,1,7,3,9,2};
        System.out.println("Raw Array: "+Arrays.toString(nums));

        // reverse array
        int[] reversed = reverse(nums);
        System.out.println("Reversed Array: "+Arrays.toString(reversed));

        // find maxinum
        System.out.println("Max Num: "+max(nums));

        // reduce the same nums
        int[] unique = dedup(nums);
        System.out.println("Dedup Num: "+Arrays.toString(unique));

        // ArrayList version
        List<Integer> list = new ArrayList<>();
        for(int n: nums) list.add(n);

        System.out.println("\n--- ArrayList Version ---");
        System.out.println("Raw List: "+list);

        // reverse array
        List<Integer> listReversed = new ArrayList<>(list);
        java.util.Collections.reverse(listReversed);
        System.out.println("Reversed List: "+listReversed);

        // Max Num
        System.out.println("Max Num: "+ java.util.Collections.max(list));

        // reduce the same nums
        List<Integer> ListUnique = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("Dedup List: "+ListUnique);

        // Add new num
        list.add(100);
        list.add(200);
        System.out.println("Added List: "+list+", size="+list.size());
    }

    public static int[] reverse(int[] arr){
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = arr[arr.length-1-i];
        }
        return result;
    }

    public static int max(int[] arr){
        if (arr==null || arr.length==0){
            throw new IllegalArgumentException("Empty Array is wrong");
        }
        int temp = arr[0];
        for (int i=0; i<arr.length; i++){
            if (arr[i] > temp)
                temp = arr[i];
        }
        return temp;
    }

    public static int[] dedup(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for (int n: arr) set.add(n);
        int[] result = new int[set.size()];
        int i = 0;
        for (int n: set) result[i++] = n;
        return result;
    }
}