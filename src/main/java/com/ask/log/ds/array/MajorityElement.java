package com.ask.log.ds.array;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{1,1,1,2,4,4,3,2,3,3,3,4,4,4,4}));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);//You can write any sorting algo instead of using this, i was too lazy to write the algo :)
        int x = nums.length/2;
        String term = String.valueOf("dfds".charAt(1));
        return nums[x];
    }


}
