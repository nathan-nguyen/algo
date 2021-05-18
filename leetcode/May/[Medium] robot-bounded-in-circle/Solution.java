class Solution {
    private static final int NORTH = 90;
    private static final int EAST = 180;
    private static final int SOUTH = 270;
    private static final int WEST = 0;

    public boolean isRobotBounded(String inst) {
        int state = NORTH;
        int x = 0, y = 0;
        
        for (int i = 0; i < inst.length(); ++i) {
            if (inst.charAt(i) == 'L') state = (state + 270) % 360;
            else if (inst.charAt(i) == 'R') state = (state + 90) % 360;
            else {
                switch (state) {
                    case NORTH: y += 1; break;
                    case EAST: x += 1; break;
                    case SOUTH: y -= 1; break;
                    case WEST: x -= 1; break;
                }
            }
        }
        return state != NORTH || (x == 0 && y == 0);
    }
}

