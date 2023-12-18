package dev.petefg.aoc23;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 extends AOCPuzzle {

    public Day06() {
        super("6");
    }

    @Override
    void solve(List<String> input) {
        String inputString = input.get(0);

        int marker = 0;
        // Part 1
        for (int i = 0; i < inputString.length() - 14; i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < i + 4; j++) {
                charSet.add(inputString.charAt(j));
            }
            if (charSet.size() == 4) {
                marker = i + 4;
                break;
            }
        }
        lap(marker);
        marker = 0;
        //Part 2
        for (int i = 0; i < inputString.length() - 14; i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < i + 14; j++) {
                charSet.add(inputString.charAt(j));
            }
            if (charSet.size() == 14) {
                marker = i + 14;
                break;
            }
        }
        lap(marker);
    }
}