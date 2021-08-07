#include<bits/stdc++.h>
using namespace std;


void dfs(int r, int c, vector<vector<int>>& grid, int id, int& area){
    if(r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() || grid[r][c] == 0 || grid[r][c] == id) return;

    grid[r][c] = id;
    area++;
    dfs(r+1, c, grid, id, area);
    dfs(r-1, c, grid, id, area);
    dfs(r, c+1, grid, id, area);
    dfs(r, c-1, grid, id, area);
}


int largestIsland(vector<vector<int>>& grid){
    map<int, int> areaMap;
    int maxArea = 0;
    int id = 2;

    

    for(int i=0;i<grid.size();i++){
        for(int j=0;j<grid[0].size();j++){
            if(grid[i][j] == 1){
                int area = 0;
                dfs(i,j,grid,id,area);
                
                areaMap[id] = area;
                id++;
                maxArea = max(area, maxArea);
            }
        }
    }
    

    int maxMergeArea = 0;

    for(int i=0;i<grid.size();i++){
        for(int j=0;j<grid[0].size();j++){
            if(grid[i][j] == 0){
                int mergedArea = 1;
                map<int, bool> idMap;
                if(i-1 >= 0 && grid[i-1][j] != 0){
                    mergedArea += areaMap[grid[i-1][j]];
                    idMap[grid[i-1][j]] = true;
                    
                } 
                if(i+1 < grid.size() && grid[i+1][j] != 0 && idMap[grid[i+1][j]] == false){
                    mergedArea += areaMap[grid[i+1][j]];
                    idMap[grid[i+1][j]] = true;
                } 
                if(j-1 >= 0 && grid[i][j-1] != 0 && idMap[grid[i][j-1]] == false){
                    mergedArea += areaMap[grid[i][j-1]];
                    idMap[grid[i][j-1]] = true;
                    
                } 
                if(j+1 < grid.size() && grid[i][j+1] != 0 && idMap[grid[i][j+1]] == false){
                    mergedArea += areaMap[grid[i][j+1]];
                    idMap[grid[i][j+1]] = true;
                    
                }
                maxMergeArea = max(maxMergeArea, mergedArea);
            }
            
        }
        
    }
    return max(maxMergeArea, maxArea);
}


int main(){
    vector<vector<int>> input {
        {1,0},
        {0,1}
    };

    cout<<largestIsland(input)<<endl;

    return 0;
}