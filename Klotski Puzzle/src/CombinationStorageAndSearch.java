import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationStorageAndSearch {
    public static void main(String[] args) {
        Set<List<Integer>> combinations = new HashSet<>();

        // Example: Saving combinations
        List<Integer> combination1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<Integer> combination2 = List.of(2, 4, 6, 8, 10, 12, 14, 16, 1, 3, 5, 7, 9, 11, 13, 15);

        combinations.add(new ArrayList<>(combination1));
        combinations.add(new ArrayList<>(combination2));

        // Example: Searching for a combination
        List<Integer> searchCombination = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        if (combinations.contains(new ArrayList<>(searchCombination))) {
            System.out.println("Combination found!");
        } else {
            System.out.println("Combination not found.");
        }
    }
}
