#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, M;
    if(!(cin >> N >> M)) return 0;
    
    vector<string> g(N);
    for(int i = 0; i < N; i++) cin >> g[i];
    
    auto proc_line = [&](bool isRow, int idx) -> int {
        int len = isRow ? M : N;
        for(int k = 0; k < len; k++) {
            char ch = isRow ? g[idx][k] : g[k][idx];
            if(ch != 'C' && ch != 'R') return 0;
        }
        
        int cC = 0, cR = 0;
        for(int k = 0; k < len; k++) {
            char ch = isRow ? g[idx][k] : g[k][idx];
            if(ch == 'C') cC++;
            else cR++;
        }
        return min(cC, cR);
    };
    
    int ans = 0;
    for(int i = 0; i < N; i++) ans += proc_line(true, i);
    for(int j = 0; j < M; j++) ans += proc_line(false, j);
    
    cout << ans;
    return 0;
}
