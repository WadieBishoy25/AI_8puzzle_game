import java.util.*;

public class BFSClass {

    private  Queue<int[]> queue = new LinkedList<>();
    private  HashMap<String, Integer> explored = new HashMap<String, Integer>();
    private  HashMap<String, Integer> inQueue = new HashMap<String, Integer>();
    private  HashMap<String, String> parent = new HashMap<String, String>();
    private  int tempState[] = new int[9];
    private  String temp ;
    private  int exploredcounter  = 0 ;


    public   Stack<String> BFSPath (int[] initialState)
    {
        Stack<String> path = new Stack<String>();

        if (BFS(initialState)) {
            System.out.println("Success\n\n");
            System.out.println("no of explored nodes: " +exploredcounter + "\n");

            path.push(Arrays.toString(new int[]{0,1,2,3,4,5,6,7,8}));
            temp = parent.get(Arrays.toString(new int[]{0,1,2,3,4,5,6,7,8}));
            path.push(temp);
            System.out.println("> Reversed Path:");
            System.out.println(Arrays.toString(new int[]{0,1,2,3,4,5,6,7,8}));
            System.out.println(temp);

            while (temp.compareTo(Arrays.toString(initialState)) != 0)
            {
                temp = parent.get(temp);
                path.push(temp);
                System.out.println(temp);

            }
        }

        return path ;

    }

    private  boolean BFS(int[] initialState) {

        int[] state;
        queue.add(initialState);
        inQueue.put(Arrays.toString(initialState), 1);

        while(!queue.isEmpty()) {
            state = queue.poll();
            inQueue.remove(Arrays.toString(state));
            explored.put(Arrays.toString(state), 1);
            System.out.println(" ");
            System.out.println("parent: " + Arrays.toString(state));
            exploredcounter++;

            if(isGoal(state)) {
                success(state);
                return true;
            }

            expandState(state);
        }
        return false;
    }

    private  void expandState(int[] currentState) {

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

        if(moveUp) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition-3];
            tempState[zeroPosition-3] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inQueue.containsKey(Arrays.toString(tempState))) {
                queue.add(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }
        }
        if(moveLeft) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition-1];
            tempState[zeroPosition-1] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inQueue.containsKey(Arrays.toString(tempState))) {
                queue.add(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }
        }
        if(moveRight) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition+1];
            tempState[zeroPosition+1] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inQueue.containsKey(Arrays.toString(tempState))) {
                queue.add(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }

        }
        if(moveDown) {
            tempState = currentState.clone();
            tempState[zeroPosition] = tempState[zeroPosition+3];
            tempState[zeroPosition+3] = 0;
            if(!explored.containsKey(Arrays.toString(tempState)) && !inQueue.containsKey(Arrays.toString(tempState))) {
                queue.add(tempState);
                parent.put(Arrays.toString(tempState), Arrays.toString(currentState));
                System.out.println("	> " + Arrays.toString(tempState));
            }

        }
        System.out.println("............................................");

    }
    private  boolean isGoal(int[] currentState) {
        int[] goalState = new int[]{0,1,2,3,4,5,6,7,8};
        int i;
        for(i = 0; i < 8; i++) {
            if(currentState[i] != goalState[i]) return false;
        }
        return true;
    }

    private  void success(int[] currentState) {
        System.out.println("Goal: " + Arrays.toString(currentState));
    }
}
