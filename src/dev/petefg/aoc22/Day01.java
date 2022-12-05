package dev.petefg.aoc22;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends AOCPuzzle {

    public Day01() {
        super("1");
    }

    @Override
    void solve(List<String> input) {
        List<Integer> elfCalories = new ArrayList<>();
        int elfCalorie = 0;
        for (String line : input) {
            if (line.equalsIgnoreCase("")) {
                elfCalories.add(elfCalorie);
                elfCalorie = 0;
                continue;
            }
            elfCalorie += Integer.parseInt(line);
        }
        elfCalories.sort((a, b) -> b - a);
        int highestCalorie = elfCalories.get(0);
        int highestCalorieTop3 = elfCalories.get(0) + elfCalories.get(1) + elfCalories.get(2);
        System.out.println(highestCalorie);
        lap(highestCalorie);
        lap(highestCalorieTop3);
    }
}
