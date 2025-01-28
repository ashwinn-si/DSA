class Solution {
    public boolean isPathCrossing(String path) {
        int X = 0;
        int Y = 0;
        Set<> prevPath = new HashSet<>(); 
        prevPath.add(new ArrayList(Arrays.asList(X,Y)));
        int N = path.length();
        for(int i = 0 ; i < N ; i++){
            char ch = path.charAt(i);
            switch(path.charAt(i)){
                case 'N' :
                    Y++;
                    break;
                case 'S':
                    Y--;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
            }
            if(prevPath.contains(new ArrayList(Arrays.asList(X,Y)))){
                return true;
            }
            prevPath.add(new ArrayList(Arrays.asList(X,Y)));
        }
        return false;
    }
}