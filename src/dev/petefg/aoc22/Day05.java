package dev.petefg.aoc22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day05 extends AOCPuzzle {

    public Day05() {
        super("5");
    }

    @Override
    void solve(List<String> input) {
        //Part 1: getting current situation
        Map<Integer, Integer> destinationsAndIndices = new HashMap<>();
        List<Integer> destinations = new ArrayList<>();
        char[] destinationChars = input.get(8).toCharArray();
        for (int i = 0; i < destinationChars.length; i++) {
            if (isNumeric(String.valueOf(destinationChars[i]))) {
                int destination = Integer.parseInt(String.valueOf(destinationChars[i]));
                destinations.add(destination);
                destinationsAndIndices.put(destination, i);
            }
        }

        Map<Integer, List<String>> cratesPerColumn = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            String currentLine = input.get(i - 1);
            for (Integer column : destinations) {
                String valueAtIndex = String.valueOf(currentLine.charAt(destinationsAndIndices.get(column)));
                if (!valueAtIndex.isBlank()) {
                    if (cratesPerColumn.containsKey(column)) {
                        cratesPerColumn.get(column).add(valueAtIndex);
                    } else {
                        List<String> valuesAtIndex = new ArrayList<>();
                        valuesAtIndex.add(valueAtIndex);
                        cratesPerColumn.put(column, valuesAtIndex);
                    }
                }
            }
        }


        // Part 2 : moving
        List<String> lines = new ArrayList<>();
        for (int i = 10; i < input.size(); i++) {
            String[] s = input.get(i).split(" ");
            Integer amountToMove = Integer.parseInt(String.valueOf(s[1]));
            Integer source = Integer.parseInt(String.valueOf(s[3]));
            Integer destination = Integer.parseInt(String.valueOf(s[5]));
            List<String> itemsToMove = new ArrayList<>();
            for (int j = 0; j < amountToMove; j++) {
                //TODO comment in for part 1
                //String itemToMove = cratesPerColumn.get(source).get(0);
                //cratesPerColumn.get(destination).add(0, itemToMove);
                itemsToMove.add(cratesPerColumn.get(source).get(0));
                List<String> newList = cratesPerColumn.get(source);
                newList.remove(0);
                cratesPerColumn.replace(source, newList);
            }
            //TODO comment out for part1
            cratesPerColumn.get(destination).addAll(0, itemsToMove);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer dest : destinations) {
            sb.append(cratesPerColumn.get(dest).get(0));
        }
        System.out.println(sb);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}