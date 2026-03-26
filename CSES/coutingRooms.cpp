#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<numeric>
using namespace std;
# define ll long long int
# define MOD 1000000007
void dfs(int x, int y, int r, int c, vector<string> &mat){
    if(0>x || x>=r || 0>y || y>=c || mat[x][y]=='#') return;
    mat[x][y] = '#';
    dfs(x+1,y,r,c,mat);
    dfs(x,y+1,r,c,mat);
    dfs(x-1,y,r,c,mat);
    dfs(x,y-1,r,c,mat);
}
int main(){
    int m,n;
    cin>>m>>n;
    vector<string> mat(m);
    int rooms = 0;
    for(int i=0;i<m;i++){
        cin>>mat[i];
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]=='.'){
                rooms++;
                dfs(i,j, m,n, mat);
            }
        }
    }
    cout<<rooms;
}