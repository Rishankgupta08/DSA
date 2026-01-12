#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, K;
    cin >> N >> M >> K;

    vector<int> A(N), B(M);

    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < M; i++) cin >> B[i];

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    int ptrA = 0, ptrB = 0, ans = 0;

    while (ptrA < N && ptrB < M) {
        if (abs(A[ptrA] - B[ptrB]) <= K) {
            ans++;
            ptrA++;
            ptrB++;
        } else if (A[ptrA] < B[ptrB]) {
            ptrA++;
        } else {
            ptrB++;
        }
    }

    cout << ans << "\n";
    return 0;
}