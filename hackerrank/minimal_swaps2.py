#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def minimumSwaps(arr):
    i = 0
    answer = 0
    while i < len(arr):
        if arr[i] == i+1:
            i+=1
            continue
        temp1 = arr[i]
        temp2 = arr[temp1-1]
        arr[i], arr[temp1-1] = temp2, temp1
        answer+=1
    return answer

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = minimumSwaps(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
