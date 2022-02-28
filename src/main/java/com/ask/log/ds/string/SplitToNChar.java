package com.ask.log.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitToNChar {
    public static void main(String[] args) {
        SplitToNChar splitToNChar = new SplitToNChar();
        String input = "<p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol <p>Hi, thanks for contacting Lincoln Financial Group.</p> <p>Ask me a question about your  <b><i>Lincol";
        String inout2 = "Hi Melissa,  this customer is telling me she's having a hard time with the e-interview saving her information and she's asking if she can print and then scan and email to me so I can get it to you guys.  Is that allowable?";
        String inpu3 = "Hello ! ! ";
        String inout4 = "Hi Melissa,  this customer is telling me she's having a hard time with the e-interview saving her information and she's asking if she can print and then scan and email to me so I can get it to you guys.  Is that allowable?";
        splitToNChar.lineBreaker(input, 100)
                .forEach(System.out::println);

        splitToNChar.partitionByTextSize(Arrays.asList(input, inout2, inpu3, inout4));


    }

    private List<List<String>> partitionByTextSize(final List<String> input) {
        List<List<String>> result = new ArrayList<>();
        List<String> mediate = new ArrayList<>();
        int lines = 0;
        for (String line : input) {
            double numberOfLines = Math.ceil(line.length() / 100d);
            if (numberOfLines + lines > 10) {
                result.add(mediate);
                lines = 0;
                mediate = new ArrayList<>();
            } else {
                lines += numberOfLines;
            }
            mediate.add(line);
        }
        if (!mediate.isEmpty()) {
            result.add(mediate);
        }
        return result;

    }

    private List<String> lineBreaker(final String input, final int maxSize) {
        if (input == null) {
            return Collections.emptyList();
        }
        if (input.length() < maxSize) {
            return Collections.singletonList(input);
        }
        final List<String> parts = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();
        StringBuilder intermediate = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            final String temp = String.valueOf(input.charAt(index));
            if (temp.equalsIgnoreCase(" ")) {
                if (intermediate.length() + lineBuilder.length() > maxSize) {
                    parts.add(lineBuilder.toString());
                    lineBuilder.setLength(0);
                    lineBuilder.append(intermediate);
                    lineBuilder.append(" ");
                    intermediate.setLength(0);
                } else {
                    lineBuilder.append(intermediate);
                    lineBuilder.append(" ");
                    intermediate.setLength(0);
                }
            } else {
                intermediate.append(temp);
            }
        }
        if (intermediate.length() + lineBuilder.length() > maxSize) {
            parts.add(lineBuilder.toString());
            parts.add(intermediate.toString());
        } else {
            parts.add(lineBuilder.append(intermediate).toString());
        }
        return parts;
    }
}
