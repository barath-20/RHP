#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;
#define ll long long

int get_size(int n) {
    return pow(2, ceil(log2(n)));
}

void update(vector<long long>& arr, int idx, long long val) {
    if (idx < 1) return;
    arr[idx] += val;
    update(arr, idx / 2, val);
}

ll sum(vector<long long>& arr, int node, int left, int right, int x, int y) {
    ll current_sum = 0;
    int mid = left + (right - left) / 2;

    if (left == x && right == y) return arr[node];

    if (x <= mid) current_sum += sum(arr, 2 * node, left, mid, x, min(y, mid));

    if (y > mid) current_sum += sum(arr, 2 * node + 1, mid + 1, right, max(x, mid + 1), y);

    return current_sum;
}

void solve(){
    int n, q;
    cin >> n >> q;

    int N = get_size(n);
    vector<ll> arr(2 * N);

    for (int i = N; i < N + n; ++i) {
        cin >> arr[i];
    }

    for (int i = N - 1; i > 0; --i) {
        arr[i] = arr[i * 2] + arr[i * 2 + 1];
    }

    while (q--) {
        int op;
        cin >> op;
        if (op == 1) {
            int k;
            ll u;
            cin >> k >> u;
            update(arr, k + N - 1, u - arr[k + N - 1]);
        } else {
            int a, b;
            cin >> a >> b;
            cout << sum(arr, 1, 1, N, a, b) << endl;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int tc = 1;
    while(tc-->0){
        solve();
    }
    return 0;
}

