package Astar;

import java.util.HashMap;
import java.util.Map;

class Utility
{
    static String heuristicType = "m";

    private static Map<Integer, Coordinates> goalCoordinates = new HashMap<Integer, Coordinates>()
    {{
        put(1, new Coordinates(0, 0));
        put(2, new Coordinates(0, 1));
        put(3, new Coordinates(0, 2));
        put(4, new Coordinates(1, 0));
        put(5, new Coordinates(1, 1));
        put(6, new Coordinates(1, 2));
        put(7, new Coordinates(2, 0));
        put(8, new Coordinates(2, 1));
        put(0, new Coordinates(2, 2));
    }};

    static int manhattan(Coordinates currentCell)
    {
        Coordinates goalCell = goalCoordinates.get(0);
        return Math.abs(currentCell.x - goalCell.x) + Math.abs(currentCell.y - goalCell.y);
    }

    static int euclidean(Coordinates currentCell)
    {
        Coordinates goalCell = goalCoordinates.get(0);

        int y = Math.abs(currentCell.y - goalCell.y);
        int x = Math.abs(currentCell.x - goalCell.x);

        return (int) Math.sqrt((y) * (y) + (x) * (x));
    }

    static String boardToString(int[][] board)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    static int[][] convertBoardTo2D(int[] board)
    {
        int[][] board2D = new int[3][3];

        for (int i = 0; i < 3; i++)
            System.arraycopy(board, (i * 3), board2D[i], 0, 3);

        return board2D;
    }

    static Coordinates findZeroCoordinates(int[] board)
    {
        int[][] board2D = convertBoardTo2D(board);
        Coordinates coordinates = new Coordinates(0, 0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board2D[i][j] == 0) {
                    coordinates = new Coordinates(i, j);
                    break;
                }
            }
        }

        return coordinates;
    }

    static int getIndexOfZero(int[] array)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 0) return i;
        return -1;
    }
}
