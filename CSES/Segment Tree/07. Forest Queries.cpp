#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, Q;
    if (!(cin >> N >> Q)) return 0;

    int R = N, C = N;
    vector<string> grid(R);
    for (int r = 0; r < R; ++r) {
        cin >> grid[r];              
    }

    vector<vector<int>> dp(R + 1, vector<int>(C + 1, 0));

    for (int r = 1; r <= R; ++r) {
        for (int c = 1; c <= C; ++c) {
            int inc = (grid[r - 1][c - 1] == '*') ? 1 : 0;
            dp[r][c] = inc + dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1];
        }
    }

    for (int qi = 0; qi < Q; ++qi) {
        int r1, c1, r2, c2;
        cin >> r1 >> c1 >> r2 >> c2;

        int ans = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
        cout << ans << '\n';
    }

    return 0;
}
