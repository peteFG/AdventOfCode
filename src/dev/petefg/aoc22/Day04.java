package dev.petefg.aoc22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 extends AOCPuzzle {
    static int contained = 0;
    static int fullyContained = 0;

    public Day04() {
        super("4");
    }

    @Override
    void solve(List<String> input) {
        for (String line : input) {
            String[] split = line.split(",");
            List<String> firstElfSplit = Arrays.stream(Arrays.stream(split).toList().get(0).split("-")).toList();
            List<String> secondElfSplit = Arrays.stream(Arrays.stream(split).toList().get(1).split("-")).toList();

            List<Integer> firstElfNumbers = getElfNumbers(firstElfSplit);
            List<Integer> secondElfNumbers = getElfNumbers(secondElfSplit);
            if (firstElfNumbers.containsAll(secondElfNumbers) || secondElfNumbers.containsAll(firstElfNumbers)) {
                fullyContained++;
            }
            boolean alreadyContained = getContained(false, firstElfNumbers, secondElfNumbers);
            getContained(alreadyContained, secondElfNumbers, firstElfNumbers);
        }
        lap(fullyContained);
        lap(contained);
    }

    private static boolean getContained(boolean alreadyContained, List<Integer> elfNumbersToIterate, List<Integer> fullElfNumbers) {
        if (alreadyContained) {
            return true;
        }
        for (Integer elfNumber : elfNumbersToIterate) {
            if (fullElfNumbers.contains(elfNumber)) {
                contained++;
                alreadyContained = true;
                break;
            }
        }
        return alreadyContained;
    }

    private List<Integer> getElfNumbers(List<String> elfSplit) {
        List<Integer> elfNumbers = new ArrayList<>();
        for (int i = Integer.parseInt(elfSplit.get(0)); i <= Integer.parseInt(elfSplit.get(1)); i++) {
            elfNumbers.add(i);
        }
        return elfNumbers;
    }
}