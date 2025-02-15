class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        int N = houses.length, M = heaters.length;
        for(int house = 0 ; house < N ; house++){
            int minDistance = Integer.MAX_VALUE;
            for(int heater = 0 ; heater < M ; heater++){
                minDistance = Math.min(minDistance, Math.abs(heaters[heater] - houses[house]));
            }
            radius = Math.max(minDistance, radius);
        }
        return radius;
    }
}