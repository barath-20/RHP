#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n;
    string s;
    cin >> n >> s;
    if(n%2==1 && s[0]=='b'){
        cout<<"NO"<<endl;
        return;
    }
    int i = n%2;
    for(;i<n;i+=2){
        if(s[i]==s[i+1] && s[i]!='?'){
            cout<<"NO"<<endl;
            return;
        }
    }
    cout<<"YES"<<endl;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int tc;
    cin >> tc;
    while(tc--){
        solve();
    }
    
    return 0;
}
