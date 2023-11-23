import java.util.*;

public class FindPath {
    /*
    *
    *
    static int originalBoard[][] = new int[][]{
            {1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 16}};

    static int currentBoard[][] = new int[][]{
            {1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 16}};
    *
    * */

    private static int x;
    private static int y;
    private static int[][] currentBoard;
    private static String currentState;
    private static final int DIRS[][] = {{1,0},{0,1},{-1,0},{0,-1}};// down, right, up, left
    private static List<Integer> steps;
    private static Set<String> record;
    private static String finalState;
    private static int MAX_ATTEMPT;
    private static int attempt;

    public FindPath(String finalState, String currentState, int[][] currentBoard, int MAX_ATTEMPT, int x, int y) {
        this.finalState = finalState;
        this.currentState = currentState;
        this.currentBoard = currentBoard;
        this.MAX_ATTEMPT = MAX_ATTEMPT;
        this.x = x;
        this.y = y;
        this.steps = new LinkedList<>();
        this.record = new TreeSet<>();
        this.attempt = 0;
    }


    private static boolean search(int direction) {
        if (moveForward(direction)) {
            String state = getCurrentBoard(currentBoard);
            if (state.equals(finalState)) {
                return true;
            }
            if (record.contains(state) || attempt >= MAX_ATTEMPT) {
                moveBack(direction);
                return false;
            }
            record.add(state);
            if (search(0) || search(1) || search(2) || search(3)) {
                return true;
            } else {
                moveBack(direction);
                return false;
            }
        }
        return false;
    }

    private static boolean canMove(int direction) {
        int xProp = x + DIRS[direction][0];
        int yProp = y + DIRS[direction][1];
        if (xProp >= 0 && yProp >= 0 && xProp < currentBoard.length && yProp < currentBoard[0].length) {
            return true;
        }
        return false;
    }

    private static boolean moveForward(int direction) {
        int xProp = x + DIRS[direction][0];
        int yProp = y + DIRS[direction][1];
        if (xProp < 0 || yProp < 0 || xProp >= currentBoard.length || yProp >= currentBoard[0].length) {
            return false;
        }
        attempt++;
        swap (currentBoard, x, y, xProp, yProp);
        x = xProp;
        y = yProp;
        steps.add(direction);
        return true;
    }

    private static void moveBack(int direction) {
        attempt--;
        int xProp = x - DIRS[direction][0];
        int yProp = y - DIRS[direction][1];
        swap (currentBoard, x, y, xProp, yProp);
        x = xProp;
        y = yProp;
        steps.remove(steps.size() - 1);
    }

    private static void printSteps(List<Integer> steps) {
        for (int direction : steps) {
            if (direction == 0) {
                System.out.print("down ");
            } else if (direction == 1) {
                System.out.print("right ");
            } else if (direction == 2) {
                System.out.print("up ");
            } else if (direction == 3) {
                System.out.print("left ");
            } else {
                System.out.println("No such direction!!");
            }
        }
        System.out.println();
    }

    private static void swap(int board[][], int x, int y, int newX, int newY) {
        int temp = board[x][y];
        board[x][y] = board[newX][newY];
        board[newX][newY] = temp;
    }

   /* private static Long getCurrentBoard(int[][] board) {
        long result = 0;
        int binaryNum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result += board[i][j] * power(2, binaryNum++);
            }
        }
        return result;
    }*/

    private static String getCurrentBoard(int[][] board) {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (board[i][j]) {
                    case 11:
                        result += "A";
                        break;
                    case 12:
                        result += "B";
                        break;
                    case 13:
                        result += "C";
                        break;
                    case 14:
                        result += "D";
                        break;
                    case 15:
                        result += "E";
                        break;
                    case 16:
                        result += "F";
                        break;
                    default:
                        result += board[i][j];
                }
            }
        }
        return result;
    }

    private static int power(int a, int i) {
        if (i == 0) {
            return 1;
        }
        int half = power(a, i / 2);
        if (i % 2 == 0) {
            return half * half;
        } else {
            return a * half * half;
        }
    }

    public boolean solution() {
        record.add(currentState);
        boolean result = search(0) || search(1) || search(2) || search(3);
        if (result) {
            printSteps(steps);
            return true;
        }
        return false;
    }
}
