package Astar;

public class Main
{
    public static void main(String[] args)
    {
        int[] initialState = {1, 2, 3, 0, 4, 6, 7, 5, 8};

        Puzzle puzzle = new Puzzle(initialState);

        puzzle.solve();
    }
}