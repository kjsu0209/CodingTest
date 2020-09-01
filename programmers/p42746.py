def solution(numbers):
    answer = ''
    string = ''
    #첫 자리 숫자가 제일 큰 것부터 정렬
    numbers = quicksort(numbers)
    
    for n in numbers:
        answer += str(n)
    if answer[0] == "0":
        answer = "0"
    return answer

def quicksort(x):
    if len(x) <= 1:
        return x

    pivot = x[len(x) // 2]
    pivot = str(pivot)
    less = []
    more = []
    equal = []
    for a in x:
        a= str(a)
        if a[0] > pivot[0]:
            less.append(a)
        elif a[0] < pivot[0]:
            more.append(a)
        else:
            if len(a) == len(pivot):
                if int(a) > int(pivot):
                    less.append(a)
                elif int(a) < int(pivot):
                    more.append(a)
                else:
                    equal.append(a)
            else:
                if int(a+pivot) > int(pivot+a):
                    less.append(a)
                else:
                    more.append(a)
    return quicksort(less) + equal + quicksort(more)
