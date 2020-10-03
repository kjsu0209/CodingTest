# 행렬곱
def solution(arr1, arr2):
    answer = []
    for i, a1 in enumerate(arr1):
        new_arr = [0 for g in range(len(arr2[0]))]
        for g in range(len(arr2[0])):
            for j in range(len(a1)):
                new_arr[g] += arr2[j][g]*a1[j]
        answer.append(new_arr)
                
    return answer
