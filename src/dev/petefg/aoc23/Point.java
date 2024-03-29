package dev.petefg.aoc23;

public record Point(int row, int col) {
    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
