import operator
import unittest

def friendlywords(inp):
    inp.sort()
    dict={}
    for i in inp:
        if len(i) in dict and len(i)>0:
            temp = dict[len(i)]
            temp.append(i)
            dict[len(i)]=temp
        else:
            temp=[]
            temp.append(i)
            dict[len(i)]=temp
    sortedDict = {}
    for i in dict:
        if len(dict[i])>1:
            for j in dict[i]:
                sortedStr = ''.join(sorted(j))
                if sortedStr in sortedDict:
                    temp = sortedDict[sortedStr]
                    temp.append(j)
                    sortedDict[sortedStr]=temp
                else:
                    temp=[]
                    temp.append(j)
                    sortedDict[sortedStr]=temp
    sortedlist = []
    for i in sortedDict:
        if len(sortedDict[i])>1:
            sortedlist.append(sortedDict[i])
    sortedlist.sort(key=operator.itemgetter(0))   
    return sortedlist
            
  
class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
            (["cat", "net", "eat", "apple", "land", "chicken", "go", "dog", "ate", "mango", "ten", "teaching", "cheating", "god", "act","tea"], [['act', 'cat'],['ate', 'eat', 'tea'],['cheating', 'teaching'],['dog', 'god'],['net', 'ten']]),
            (["",""],[]),
            (["a","b"],[]),
            (["ab","ba"],[["ab","ba"]]),
            (["ab","ba "],[]),
            (["ab"," ba"],[]),
            (["cacbc","baccc","ccc","bacc","cacbc"],[["baccc","cacbc","cacbc"]])
          ]
           
    def test(self):
        for [n, expected] in self.data:
            actual = friendlywords(n)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()

  
    