package com.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum
 * 39. Combination Sum Medium
 * Given an array of distinct integers candidates and a target integer target,return a list of all unique combinations of
 * candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
 *  of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 */
public class CombinationSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return combinationSum(candidates, 0, target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
        int sum  = 0;
        List<Integer> baseList = new ArrayList<Integer>();
        while( true ) {

            sum += candidates[start];
            if( sum < target ) {
                baseList.add(candidates[start]);
                List<List<Integer>> subResult = combinationSum(candidates, start+1, target - sum);
                subResult.forEach( x -> x.addAll(baseList));
                finalResult.addAll(subResult);
            } else {
                break;
            }
        }
        return null; //todo
    }


}
