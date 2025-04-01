class Solution {
    List<String> result = new ArrayList<>();

    private void dfs(int openCount, int closeCount, String str) {
        if (openCount == 0 && closeCount == 0) {
            result.add(str);
            return;
        }
        if (openCount > 0) {
            dfs(openCount - 1, closeCount, str + "(");
        }
        if (closeCount > openCount) {
            dfs(openCount, closeCount - 1, str + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        int openCount = n;
        int closeCount = n;
        dfs(openCount, closeCount, "");
        return result;
    }
}