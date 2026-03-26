#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<numeric>
using namespace std;
# define ll long long int
# define MOD 1000000007
static int diff[5] = {0,1,0,-1,0};
static char dirs[4] = {'L','U','R','D'};
int main(){
    int r, c;
    cin>>r>>c;
    vector<string> mat(r);
    for(int i=0;i<r;i++)    cin>>mat[i];
    queue<pair<int,int>> q;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(mat[i][j]=='B'){
                q.push(make_pair(i,j));
                i = r;
                break;
            }
        }
    }
    bool found = false;
    vector<char> path;
    int ai = -1, aj = -1;
    while(!q.empty() && !found){
        auto p = q.front(); q.pop();
        int x = p.first, y = p.second;
        for(int i=0;i<4;i++){
            int ri = x+diff[i], ci = y+diff[i+1];
            if(0<=ri && ri<r && 0<=ci && ci<c){
                if(mat[ri][ci]=='A'){
                    found = true;
                    mat[ri][ci] = dirs[i];
                    ai = ri;
                    aj = ci;
                    break;
                }
                else if(mat[ri][ci]=='.'){
                    mat[ri][ci] = dirs[i];
                    q.push(make_pair(ri,ci));
                }
            }
        }
    }
    if(!found){
        cout<<"NO"<<endl;
        return 0;
    }
    while(mat[ai][aj]!='B'){
        char way = mat[ai][aj];
        path.push_back(way);
        if(way=='L')    aj-=1;
        if(way=='R')    aj+=1;
        if(way=='U')    ai-=1;
        if(way=='D')    ai+=1;
    }
    cout<<"YES"<<endl;
    cout<<path.size()<<endl;
    for(int i = 0;i<path.size();i++){
        cout<<path[i];
    }

}