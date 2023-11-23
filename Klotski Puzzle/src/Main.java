import java.util.*;

public class Main {
    private static int x;
    private static int y;
    static int originalBoard[][] = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            };

    static int currentBoard[][] = new int[][]{
            {1, 5, 3},
            {2, 6, 4},
            {8, 0, 7},
            };

    private static List<Integer> getCurrentBoard2(int[][] board) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                array.add(board[i][j]);
            }
        }
        return array;
    }

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

    private static void findStart() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
    }

    public static void main(String[] args) {

        String finalState = getCurrentBoard(originalBoard);
        String currentState = getCurrentBoard(currentBoard);
        //Set<List<Integer>> finalState = new HashSet<>();
        //finalState.add(new ArrayList<>(getCurrentBoard2(originalBoard)));
        //List<Integer> currentState = getCurrentBoard2(currentBoard);

        if (currentState.equals(finalState)) {
            System.out.println("Found Solutions Without moving");
            return;
        }

        /*if (finalState.contains(currentState)) {
            System.out.println("Found Solutions Without moving");
            return;
        }*/
        int maxAttempt = 10;
        findStart();
        boolean result = false;
        while (maxAttempt < 40) {
            FindPath findPath = new FindPath(finalState, currentState, currentBoard, maxAttempt, x, y);
            //FindPath2 findPath = new FindPath2(finalState, currentState, currentBoard, maxAttempt, x, y);
            result = findPath.solution();
            if (result) {
                break;
            } else {
                maxAttempt++;
            }
        }
        System.out.println(result ? "Found Solution!" : "Not Found!");
    }
}
