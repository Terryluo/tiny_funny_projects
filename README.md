# tiny_funny_projects
use coding to finish tiny funny projects

## Klotski Puzzle
The Klotski Puzzle project is using Java to solve the slide number klotski puzzle game. It is effectively to solve the 3 x 3 puzzle. For 4 x 4 puzzle, due to the memory limit, the maximum try solution should not be exceed 40 times. For some difficult 4 x 4 puzzle mutation, some time it could not find the solution. 
#### Implementation
Use `solve()` as the entry, use DFS method `search(int direction)` to find out the solution. The `search(int direction)` will proceed four directions in the code. If we find out the "0" block can move(neither out of the boundary of the board, nor appeared at the existing path), we move the block and check if the new board is matching the final state. At the meantime, we record the solution in the arraylist call "steps".

