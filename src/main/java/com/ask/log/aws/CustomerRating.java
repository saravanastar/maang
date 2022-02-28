package com.ask.log.aws;

import java.util.Arrays;
import java.util.List;

public class CustomerRating {
    List<Integer> integers;

    public static void main(String[] args) {
        CustomerRating customerRating = new CustomerRating();
        System.out.println(customerRating.rating(Arrays.asList(4, 3, 5, 4, 3)));
    }

    private long rating(List<Integer> ratings) {
        int diff = 1;
        long counter = 0;
        long result = 0;
        for (int index = 1; index < ratings.size(); index++) {
            if (ratings.get(index - 1) - 1 == ratings.get(index)) {
                diff += 1;
                counter += diff;
            } else {
                result += counter;
                diff = 1;
            }

        }
        result += counter;
        return result;
    }


}
