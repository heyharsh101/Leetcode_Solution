class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            String key = obstacle[0] + "_" + obstacle[1];
            obstacleSet.add(key);
        }

        int x = 0, y = 0, maxDist = 0;
        char currentDirection = 'N';

        for (int command : commands) {
            if (command == -1) {
                if (currentDirection == 'N') currentDirection = 'E';
                else if (currentDirection == 'E') currentDirection = 'S';
                else if (currentDirection == 'S') currentDirection = 'W';
                else currentDirection = 'N';
            } else if (command == -2) {
                if (currentDirection == 'N') currentDirection = 'W';
                else if (currentDirection == 'W') currentDirection = 'S';
                else if (currentDirection == 'S') currentDirection = 'E';
                else currentDirection = 'N';
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x, newY = y;

                    if (currentDirection == 'N') newY++;
                    else if (currentDirection == 'S') newY--;
                    else if (currentDirection == 'E') newX++;
                    else newX--;

                    String key = newX + "_" + newY;
                    if (obstacleSet.contains(key)) break;

                    x = newX;
                    y = newY;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}