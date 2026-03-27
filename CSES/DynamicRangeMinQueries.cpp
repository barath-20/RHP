    #include <iostream>
    #include <vector>
    #include <cmath>
    #include <algorithm>
    #include <climits>

    using namespace std;
    #define ll long long

    int get_size(int n) {
        return pow(2, ceil(log2(n)));
    }

    void update(vector<long long>& arr, int idx) {
        idx /= 2; 
        while (idx >= 1) {
            arr[idx] = min(arr[2 * idx], arr[2 * idx + 1]);
            idx /= 2;
        }
    }

    ll minRange(vector<long long>& arr, int node, int left, int right, int x, int y) {
        if (x > y) return LLONG_MAX;
            if (left == x && right == y) return arr[node];

            int mid = left + (right - left) / 2;
            
            return min(
                minRange(arr, 2 * node, left, mid, x, min(y, mid)),
                minRange(arr, 2 * node + 1, mid + 1, right, max(x, mid + 1), y)
            );
    }

    void solve(){
        int n, q;
        cin >> n >> q;

        int N = get_size(n);
        vector<ll> arr(2 * N, LLONG_MAX);

        for (int i = N; i < N + n; ++i) {
            cin >> arr[i];
        }

        for (int i = N - 1; i > 0; --i) {
            arr[i] = min(arr[i * 2] , arr[i * 2 + 1]);
        }

        while (q--) {
            int op;
            cin >> op;
            if (op == 1) {
                int k;
                ll u;
                cin >> k >> u;
                arr[k + N - 1] = u;
                update(arr, k + N - 1 );
            } else {
                int a, b;
                cin >> a >> b;
                cout << minRange(arr, 1, 1, N, a, b) << endl;
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

