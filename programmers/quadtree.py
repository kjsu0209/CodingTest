class QuadTree:
    def __init__(self, arr):
        self.data = arr
        self.child = []
        self.leafNode = True
        
    def addChild(self, child):
        self.child.append(child)
        self.leafNode = False
        
def solution(arr):
    answer = []
    root = QuadTree(arr)
    make_tree(root)
    global counter
    answer = counter
    return answer

counter = [0, 0]
def make_tree(node):
    global counter
    arr = node.data
    if len(arr) == 1:
        counter[arr[0][0]]+=1
        #print("endOfNode", arr)
        return
    
    s = len(arr) // 2
    
    
    same_val = True
    val = arr[0][0]
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i][j]!=val:
                same_val = False
    
    if same_val is False:
        new_arr = [[] for _ in range(s)]
        for i in range(s):
            for j in range(s):
                new_arr[i].append(arr[i][j])
    
        newnode = QuadTree(new_arr)
        node.addChild(newnode)
        make_tree(newnode)
        
        new_arr = [[] for _ in range(s)]
        for i in range(s):
            for j in range(s):
                new_arr[i].append(arr[i+s][j])
    
        newnode = QuadTree(new_arr)
        node.addChild(newnode)
        make_tree(newnode)
        
        new_arr = [[] for _ in range(s)]
        for i in range(s):
            for j in range(s):
                new_arr[i].append(arr[i][j+s])
    
        newnode = QuadTree(new_arr)
        node.addChild(newnode)
        make_tree(newnode)
        
        new_arr = [[] for _ in range(s)]
        for i in range(s):
            for j in range(s):
                new_arr[i].append(arr[i+s][j+s])
    
        newnode = QuadTree(new_arr)
        node.addChild(newnode)
        make_tree(newnode)
    else:
        counter[val] += 1
        #print('endOfNode : ', node.data)
