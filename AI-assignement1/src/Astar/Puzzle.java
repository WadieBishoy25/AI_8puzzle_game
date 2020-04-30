package Astar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class Puzzle
{
    private Node initialState;
    private Node currentState;

    private final PriorityQueue<Node> frontier = new PriorityQueue<>(100, new Comparator<Node>()
    {
        /* higher order comparator function */

        @Override
        public int compare(Node state1, Node state2)
        {
            return state1.f() - state2.f();
        }
    });

    private final ArrayList<Node> visited = new ArrayList<>();

    Puzzle(int[] puzzleInput)
    {
        this.initialState = new Node(puzzleInput);
        this.currentState = this.initialState;
    }

    void solve()
    {
        frontier.clear();
        frontier.add(this.initialState);
        long startTime = System.currentTimeMillis();

        while (!frontier.isEmpty()) {

            this.currentState = frontier.poll();

            if (this.currentState.isSolved()) {
                System.out.println(this.currentState.backTrack(startTime));
                break;
            }

            visited.add(currentState);

            this.addToQueue(Move.up(currentState));
            this.addToQueue(Move.down(currentState));
            this.addToQueue(Move.left(currentState));
            this.addToQueue(Move.right(currentState));
        }
    }

    static int getHeuristic(int[] array)
    {
        Coordinates zeroCoordinates = Utility.findZeroCoordinates(array);

        if (Utility.heuristicType.equals("m"))
            return Utility.manhattan(zeroCoordinates);
        else
            return Utility.euclidean(zeroCoordinates);
    }

    /* will add the nextState if it's valid */
    private void addToQueue(Node candidateNode)
    {
        if (candidateNode != null && !this.visited.contains(candidateNode)) this.frontier.add(candidateNode);
    }
}
