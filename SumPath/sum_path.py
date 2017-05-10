import copy
import unittest

class Node():
    def __init__(self, data):
        self.data=data
        self.left=None
        self.right=None
        
def makeTree(arr):
    root = Node(arr[0])
    n=1
    queue=[]
    queue.append(root)
    while n<len(arr) and queue[0]:
        temp=queue[0]
        del queue[0]
        if arr[n] is not None:
            temp.left=Node(arr[n])
            queue.append(temp.left)
        if arr[n+1] is not None:
            temp.right=Node(arr[n+1])
            queue.append(temp.right)
        n+=2
    return root
 
def sumOfPaths(root, s):
    results=[]
    sumOfPath(root,s,[],results)
    return results   
     
def sumOfPath(root, s, result, results):
    if root==None:
        return  
    s=s-root.data
    result.append(root.data)
    if s==0:
        results.append(copy.deepcopy(result))
        result.pop()
        return
    elif s<0:
        result.pop()
        return    
    sumOfPath(root.left,s,result,results)
    sumOfPath(root.right,s,result,results)
    result.pop()    
    
class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
            (13, [[4, 7, 2], [4, 6, 3]]),
            (21, [[4, 7, 9, 1], [4, 7, 2, 8], [4, 6, 3, 8]]),
            (34, []),
            (16, [[4, 7, 2, 3]]),
            (4, [[4]]),
            (10, [[4, 6]]),
            (11, [[4, 7], [4, 6, 1]])
           ]
           
    def test(self):
        arr=[4,7,6,9,2,3,1,2,1,8,3,8,10]
        root = makeTree(arr)
        for [n, expected] in self.data:
            actual = sumOfPaths(root, n)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()
