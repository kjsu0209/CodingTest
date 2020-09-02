def solution(numbers, hand):
    answer = ''
    key = [[1, 2, 3], [4, 5, 6], [7, 8, 9], ['*', 0, '#']]
    keypad = {}
    for i in range(len(key)):
        for j in range(len(key[0])):
            keypad[key[i][j]] = [i, j]
    left = [3, 0]
    right = [3, 2]
    for n in numbers:
        key_index = keypad[n]
        if n in [1, 4, 7]:
            answer += 'L'
            left = key_index
        elif n in [3, 6, 9]:
            answer += 'R'
            right = key_index
        else:
            if get_dist(left, key_index) < get_dist(right, key_index):
                answer += 'L'
                left = key_index                
            elif get_dist(left, key_index) > get_dist(right, key_index):
                answer += 'R'
                right = key_index  
            else:
                if hand == 'left':
                    answer += 'L'
                    left = key_index          
                else:
                    answer += 'R'
                    right = key_index 
    return answer

def get_dist(finger, key_index):
    x = abs(finger[0] - key_index[0])
    y = abs(finger[1] - key_index[1])
    return x+y
