
import java.util.Scanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DFSexternal {

    public static Stack stack = new Stack();
    public static HashMap<String, Integer> inStack = new HashMap<String, Integer>();
    public static HashMap<String, Integer> explored = new HashMap<String, Integer>();
    public static HashMap<String, String> parent = new HashMap<String, String>();
    public static int tempState[] = new int[9];
    public static String temp ;
    public static   int exploredcounter  = 0 ;

    public static void main(String[] args) {

        int i;
        String[] state;
        int[] initialState = new int[9];
        Scanner input = new Scanner(System.in);

        do {
            state = input.nextLine().split("");
        }while(state.length != 9);

        for(i = 0; i < state.length; i++) {
            initialState[i] = Integer.parseInt(state[i]);
        }

        if (DFS(initialState)) {
            System.out.println("Success");
            System.out.println("no of explored nodes: " +exploredcounter + "\n");

            temp = parent.get(Arrays.toString(new int[]{0,1,2,3,4,5,6,7,8}));
            System.out.println("> Reversed Path:");
            System.out.println(temp);

            while (temp.compareTo(Arrays.toString(initialState)) != 0)
            {
                temp = parent.get(temp);
                System.out.println(temp);
            }
        }
    }


    private static boolean DFS(int[] initialState) {

        int[] state;
        stack.push(initialState);
        inStack.put(Arrays.toString(initialState), 1);

        while(!stack.isEmpty()) {
            state = (int[]) stack.pop();
            inStack.remove(Arrays.toString(state));
            explored.put(Arrays.toString(state), 1);
            System.out.println(" ");
            System.out.println("parent: " + Arrays.toString(state));
            exploredcounter ++;

            if(isGoal(state)) {
                success(state);
                return true;
            }

            expandStateDFS(state);
        }
        return false;
    }

    public static void expandStateDFS(int[] currentState) {

        int i;
        boolean moveDown, moveUp, moveRight, moveLeft;
        int zeroPosition = 0, size = currentState.length;

        for(i = 0; i < size; i++) {
            if(currentState[i] == 0) {
                zeroPosition = i;
                break;
            }
        }

        if(zeroPosition % 3 == 0) { // first column

            moveRight = true;
            moveLeft = false;

        }else if(zeroPosition % 3 == 1) { // second column

            moveRight = true;
            moveLeft = true;

        }else { // third column

            moveRight = false;
            moveLeft = true;

        }


        if(zeroPosition < 3) { // first row

            moveDown = true;
            moveUp = false;

        }else if(zeroPosition < 6) { // second row

            moveDown = true;
            moveUp = true;

        }else { // third row

            moveDown = false;
            moveUp = true;
        }
        if(moveRight) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition+1];
            tempState[zeroPosition+1] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inStack.containsKey(Arrays.toString(tempState))) {
                stack.push(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }

        }
        if(moveDown) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition+3];
            tempState[zeroPosition+3] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inStack.containsKey(Arrays.toString(tempState))) {
                stack.push(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }
        }
        if(moveUp) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition-3];
            tempState[zeroPosition-3] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inStack.containsKey(Arrays.toString(tempState))) {
                stack.push(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }
        }
        if(moveLeft) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition-1];
            tempState[zeroPosition-1] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inStack.containsKey(Arrays.toString(tempState))) {
                stack.push(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }
        }
        System.out.println("............................................");

    }

    public static boolean isGoal(int[] currentState) {
        int[] goalState = new int[]{0,1,2,3,4,5,6,7,8};
        int i;
        for(i = 0; i < 8; i++) {
            if(currentState[i] != goalState[i]) return false;
        }
        return true;
    }

    public static void success(int[] currentState) {
        System.out.println("Goal: " + Arrays.toString(currentState));
    }

}
