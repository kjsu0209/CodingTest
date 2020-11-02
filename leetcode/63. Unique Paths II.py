# Runtime: 40 ms, faster than 78.20% of Python3 online submissions for Unique Paths II.
# Memory Usage: 14.3 MB, less than 100.00% of Python3 online submissions for Unique Paths II.

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid[0])
        n = len(obstacleGrid)
        memo = [[0 for i in range(m)] for _ in range(n)]
        
        for i in range(m):
            if obstacleGrid[0][i] == 1:
                break
            memo[0][i] = 1
        
        for i in range(n):
            if obstacleGrid[i][0] == 1:
                break
            memo[i][0] = 1
        
        for i in range(1, n):
            for j in range(1, m):
                if obstacleGrid[i][j] == 1:
                    continue
                memo[i][j] = memo[i-1][j] + memo[i][j-1]
                
        return memo[n-1][m-1]
