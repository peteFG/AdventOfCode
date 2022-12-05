package dev.petefg.aoc22;

import java.util.List;

public class Day02 extends AOCPuzzle {

    public Day02() {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        int score = 0;

        int rockChoice = 1;
        int paperChoice = 2;
        int scissorChoice = 3;

        int loss = 0;
        int draw = 3;
        int win = 6;

        for (String line : input) {
            char opponentPick = line.charAt(0);
            char outCome = line.charAt(2);
            boolean opponentRockChoice = opponentPick == 'A';
            boolean opponentPaperChoice = opponentPick == 'B';
            boolean opponentScissorChoice = opponentPick == 'C';
            boolean outComeLoss = outCome == 'X';
            boolean outComeDraw = outCome == 'Y';
            boolean outComeWin = outCome == 'Z';


            if (outComeLoss && opponentRockChoice) {

                score += scissorChoice + loss;
            } else if (outComeLoss && opponentPaperChoice) {
                score += rockChoice + loss;

            } else if (outComeLoss && opponentScissorChoice) {
                score += paperChoice + loss;

            } else if (outComeDraw && opponentRockChoice) {
                score += rockChoice + draw;

            } else if (outComeDraw && opponentPaperChoice) {
                score += paperChoice + draw;

            } else if (outComeDraw && opponentScissorChoice) {
                score += scissorChoice + draw;

            } else if (outComeWin && opponentRockChoice) {
                score += paperChoice + win;

            } else if (outComeWin && opponentPaperChoice) {
                score += scissorChoice + win;

            } else if (outComeWin && opponentScissorChoice) {
                score += rockChoice + win;
            }


        }
        lap(score);
    }
}
