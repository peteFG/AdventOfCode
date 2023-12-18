package dev.petefg.aoc23;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Day04 extends AOCPuzzle {

    public Day04() {
        super("4");
    }

    @Override
    void solve(List<String> input) {
        int points = 0;
        for (String line : input) {
            List<String> split = Arrays.stream(line.split(": ")).toList();
            List<String> numbers = Arrays.stream(split.get(1).split("\\|")).toList();
            List<String> winningNumbers = Arrays.stream(numbers.get(0).split(" ")).filter(StringUtils::isNotBlank).toList();
            List<String> pickedNumbers = Arrays.stream(numbers.get(1).split(" ")).filter(StringUtils::isNotBlank).toList();
            int amountOfWinners = 0;
            for (String winner : winningNumbers) {
                if (pickedNumbers.contains(winner)) {
                    amountOfWinners += 1;
                }
            }

            points += Math.pow(2, amountOfWinners-1);
        }
        System.out.println(points);
    }

}