def solution(key, lock):
    answer = False
    padding = [[] for i in range(len(lock) + (len(key)-1) * 2)]
    for i in range(len(padding)):
        for j in range(len(key)-1):
            padding[i].append(2)
        if i >= len(key)-1 and i < len(key) + len(lock)-1:
            for j in range(len(lock)):
                padding[i].append(lock[i-len(key)+1][j])
        else:
            for j in range(len(lock)):
                padding[i].append(2)
        for j in range(len(key)-1):
            padding[i].append(2)
        #print(padding[i])
        
    hom_num = 0
    for i in range(len(lock)):
        for j in range(len(lock)):
            if lock[i][j] == 0:
                hom_num += 1
    if hom_num == 0:
        hom_num = -1
        return True
    
    indexI = 0
    indexJ = 0
    result = False
    for k in range(4):
        while indexI <= len(padding)-len(key) and indexJ <= len(padding)-len(key):
            fit = True
            hom_count = 0
            for i in range(len(key)):
                if fit == False: break
                for j in range(len(key)):
                    if padding[indexI+i][indexJ+j] != 2:
                        if key[i][j] ^ padding[indexI+i][indexJ+j] != 1:
                            fit = False
                            break
                        else:
                            if padding[indexI+i][indexJ+j] == 0:
                                hom_count += 1
            #print(indexI, indexJ, hom_count, hom_num)
            if hom_count == hom_num and fit == True:
                result = True
                break
            else:
                fit = False
                
            if indexI == len(padding)-len(key) and indexJ == len(padding)-len(key):
                result = fit
                break
            if indexJ+1 <= len(padding)-len(key):
                indexJ += 1
            elif indexI+1 <=len(padding)-len(key):
                indexI += 1
                indexJ = 0
        if result == False:
            key = turn(key, k)
            indexI = 0
            indexJ = 0
            #print('turn')
        else:
            break
    return result
    
def turn(key, head):
    new_key = [[0 for j in range(len(key))]for i in range(len(key))]
    for i in range(len(key)):
        for j in range(len(key)):
            new_key[i][j] = key[len(key)-j-1][i]
        
    return new_key
