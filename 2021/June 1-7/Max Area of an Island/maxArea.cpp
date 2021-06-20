#include <bits/stdc++.h>
using namespace std;

/*
* Using the 'visited' boolean array, we keep track of
* all the 1's. This way we don't need to find the maxArea again
*/

int m, n;
bool visited[51][51] = {false};

int getArea(vector<vector<int>> &grid, int row, int column)
{
    if (row < 0 || column < 0 || row >= m || column >= n || grid[row][column] == 0 || visited[row][column] == true)
        return 0;
    visited[row][column] = true;
    return 1 + getArea(grid, row - 1, column) + getArea(grid, row + 1, column) + getArea(grid, row, column - 1) + getArea(grid, row, column + 1);
}

int findMaxArea(vector<vector<int>> &grid)
{

    int maxArea = 0;

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (grid[i][j] == 1 && visited[i][j] == false)
            {
                maxArea = max(maxArea, getArea(grid, i, j));
            }
            // cout<<maxArea<<endl;
        }
    }
    return maxArea;
}

int maxArea(vector<vector<int>> &grid)
{
    m = grid.size();
    n = grid.at(0).size();
    int maxAreaOfIsland = findMaxArea(grid);
    return maxAreaOfIsland;
}

int main()
{
    vector<vector<int>> grid{
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    cout << maxArea(grid) << endl;
    return 0;
}