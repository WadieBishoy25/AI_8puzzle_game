package Astar;

class Move
{

    static Node up(Node state)
    {
        if (state.zeroIndex > 2)
            return new Node(state, state.zeroIndex - 3);
        return null;
    }

    static Node down(Node state)
    {
        if (state.zeroIndex < 6)
            return new Node(state, state.zeroIndex + 3);
        return null;
    }

    static Node left(Node state)
    {
        if (state.zeroIndex % 3 > 0)
            return new Node(state, state.zeroIndex - 1);
        return null;
    }

    static Node right(Node state)
    {
        if (state.zeroIndex % 3 < 2)
            return new Node(state, state.zeroIndex + 1);
        return null;
    }
}