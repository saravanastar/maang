package com.ask.log.siemens;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorCode {
    String[] colorCodes = {"\033[0;102m", "\033[0;101m", "\033[0;105m"};
    public static final String RESET = "\033[0m";
    public static void main(String[] args) {

        char[][] input = new char[][] {{'#', '#', '#', '#', '#'},
                                       {'#', ' ', '#', ' ', '#'},
                                       {'#', ' ', '#', ' ', '#'},
                                       {'#', '#', '#', '#', '#'},
                                       {'#', ' ', '#', ' ', '#'},
                                       {'#', ' ', ' ', ' ', '#'},
                                       {'#', ' ', '#', ' ', '#'},
                                       {'#', '#', '#', '#', '#'}};

        ColorCode colorCode = new ColorCode();
        char[][] output = colorCode.findRooms(input);
        colorCode.printRoom(output);
    }

    private void printRoom(char[][] input) {
        for (int row = 0; row < input.length; row++) {
            for (int column = 0; column < input[0].length; column++) {
                char currentChar = input[row][column];
                if (currentChar != '#') {
                    int index =  input[row][column];
                    System.out.print(colorCodes[index] + "\t" + RESET);
                } else {
                    System.out.print(currentChar + "\t" );
                }
            }
            System.out.println();
        }
    }

    private char[][] findRooms(char[][] input) {
        int colorCodeIndex = 0;
        for (int row = 0; row < input.length; row++) {
            for (int column = 0; column < input[0].length; column++) {
                if (input[row][column] == ' ') {
                    int index = colorCodeIndex % colorCodes.length;
                    fillRoom(input, row, column, index);
                    colorCodeIndex++;
                }
//                    final String existingColor = findColor(row, column, rooms);
//                    if (existingColor == null) {
//                        int index = colorCodeIndex % colorCodes.length;
//                        final String color = colorCodes[index];
//                        colorCodeIndex++;
//                        rooms.put(getKey(row, column), color);
//                        System.out.print(color);
//                    } else {
//                        rooms.put(getKey(row, column), existingColor);
//                        System.out.print(existingColor);
//                    }
//                } else {
//                    System.out.print(input[row][column]);
//                }
            }
//            System.out.println();
        }
        return input;
    }

    private String getKey(final int row, final int column) {
        return row + "," + column;
    }

    private String findColor(int row, int column, Map<String, String> roomColors) {
        final String topKey = getKey(row-1, column);
        final String leftKey = getKey(row, column-1);
        if (roomColors.containsKey(leftKey))  {
            return roomColors.get(leftKey);
        }
        if (roomColors.containsKey(topKey)) {
            return roomColors.get(topKey);
        }

        return null;
    }

    private void fillRoom(char[][] input, int row, int column, int colorCode) {
        if (row >= input.length && column >= input[0].length) return;
        if (input[row][column] == ' ') {
            input[row][column] = (char)colorCode;
            fillRoom(input, row-1, column, colorCode);
            fillRoom(input, row+1, column, colorCode);
            fillRoom(input, row, column-1, colorCode);
            fillRoom(input, row, column+1, colorCode);
        }
    }
}
