package dev.petefg.aoc23;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 extends AOCPuzzle {

    public static final String RED = "red";
    public static final String GREEN = "green";
    public static final String BLUE = "blue";

    public Day02() {
        super("2");
    }


    @Override
    void solve(List<String> input) {
        List<Integer> successfulGameIds = new ArrayList<>();
        List<Integer> gamePowers = new ArrayList<>();

        for (String line : input) {
            int RED_MINIMUM = 0;
            int GREEN_MINIMUM = 0;
            int BLUE_MINIMUM = 0;
            List<Boolean> possibleTurns = new ArrayList<>();
            String[] split = line.split(": ");
            int gameId = Integer.parseInt(StringUtils.removeStart(Arrays.stream(split).toList().get(0), "Game "));
            List<String> combinations = Arrays.stream(Arrays.stream(split).toList().get(1).split("[;,]")).toList();
            for (String combo: combinations){
                int RED_AMOUNT = 12;
                int GREEN_AMOUNT = 13;
                int BLUE_AMOUNT = 14;
                List<String> splitColorsAndNumbers = Arrays.stream(combo.split(" ")).filter(StringUtils::isNotBlank).collect(Collectors.toList());
                int numberOfColor = Integer.parseInt(splitColorsAndNumbers.get(0));
                String color = splitColorsAndNumbers.get(1);
                switch (color) {
                    case RED -> {
                        RED_AMOUNT = RED_AMOUNT - numberOfColor;
                        if (numberOfColor > RED_MINIMUM) RED_MINIMUM = numberOfColor;
                    }
                    case BLUE -> {
                        BLUE_AMOUNT = BLUE_AMOUNT - numberOfColor;
                        if (numberOfColor > BLUE_MINIMUM) BLUE_MINIMUM = numberOfColor;
                    }
                    case GREEN -> {
                        GREEN_AMOUNT = GREEN_AMOUNT - numberOfColor;
                        if (numberOfColor > GREEN_MINIMUM) GREEN_MINIMUM = numberOfColor;
                    }
                }
                if (RED_AMOUNT < 0 || BLUE_AMOUNT < 0 || GREEN_AMOUNT < 0){
                    possibleTurns.add(false);
                } else {
                    possibleTurns.add(true);
                }
            }
            if (!possibleTurns.contains(false)) {
                successfulGameIds.add(gameId);
            }
            gamePowers.add(BLUE_MINIMUM * RED_MINIMUM * GREEN_MINIMUM);
        }
        int sum = successfulGameIds.stream().mapToInt(Integer::intValue).sum();
        int powerSum = gamePowers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        System.out.println("Power sum is " + powerSum);
    }
}
