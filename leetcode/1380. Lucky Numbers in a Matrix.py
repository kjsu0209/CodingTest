# Runtime: 140 ms, faster than 26.28% of Python3 online submissions for Lucky Numbers in a Matrix.
# Memory Usage: 14.6 MB, less than 23.37% of Python3 online submissions for Lucky Numbers in a Matrix.
# 0: 12
class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        lucky = []
        
        max_col = []
        min_row = []
        
        for i in range(len(matrix)):
            min_row.append(min(matrix[i]))
        
        for i in range(len(matrix[0])):
            max_c = 0
            for j in range(len(matrix)):
                if max_c < matrix[j][i]:
                    max_c = matrix[j][i]
            max_col.append(max_c)
        
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                num = matrix[i][j]
                
                if num == min_row[i] and num == max_col[j]:
                    lucky.append(num)
        
        return lucky
