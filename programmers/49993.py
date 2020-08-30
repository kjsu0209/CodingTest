def solution(skill, skill_trees):
    answer = 0
    
    for tree in skill_trees:
        count = -1
        valid_tree = True
        for i in range(len(tree)):
            if tree[i] in skill:
                if abs(skill.index(tree[i]) - count) == 1:
                    # 정상 스킬트리
                    count = skill.index(tree[i])
                else:
                    # 비정상 스킬트리
                    valid_tree = False
                    break
        if valid_tree == True:
            #print(tree)
            answer+=1
    return answer
