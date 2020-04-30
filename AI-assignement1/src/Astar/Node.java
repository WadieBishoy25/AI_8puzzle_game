package Astar;

import java.util.Arrays;

class Node
{
    private int[] state;

    int zeroIndex;

    private int g;
    private int h;

    private Node parent;

    Node(int[] input)
    {
        this.state = input;
        this.zeroIndex = Utility.getIndexOfZero(input);
        this.parent = null;
        this.g = 0;
        this.h = Puzzle.getHeuristic(this.state);
    }

    Node(Node previous, int zeroIndex)
    {
        this.state = Arrays.copyOf(previous.state, previous.state.length);
        this.state[previous.zeroIndex] = this.state[zeroIndex];
        this.state[zeroIndex] = 0;
        this.zeroIndex = zeroIndex;
        this.g = previous.g + 1;
        this.h = Puzzle.getHeuristic(this.state);
        this.parent = previous;
    }

    boolean isSolved()
    {
        return Arrays.equals(this.state, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
    }

    String backTrack(long startTime)
    {
        long solveTime = System.currentTimeMillis() - startTime;

        return "\nSolution is: \n\n" +
                this.previousState() +
                "------------------------" +
                "\n-> Running time: " + solveTime + "ms" +
                "\n-> Cost of path: " + this.g + " steps";
    }

    private String previousState()
    {
        StringBuilder sb = new StringBuilder();
        if (this.parent != null) sb.append(parent.previousState());
        sb.append(Utility.boardToString(Utility.convertBoardTo2D(this.state)));
        return sb.toString();
    }

    int f()
    {
        return g + h;
    }
}
