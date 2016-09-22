class Solution(object):
    
    __author__ = 'tangjialiang'
  
    
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.replace(' ', '')
        nums = []
        ops = []
        
        #  work
        i = 0
        while i < len(s):
            op = s[i]
            print 'nums: ' + str(nums)
            print 'op' + op
            if self.isSuperOp(op):
                total = 0
                j = i + 1
                while j<len(s) and self.isNum(s[j]):
                    total = int(s[j]) + total*10 
                    j += 1
                i = j-1
                nums.append(total)
                b = nums.pop(); a = nums.pop() 
                nums.append(self.count(a, b, op))
            elif self.isLowOp(op):
                ops.append(op) 
            else:
                total = 0
                j = i
                while j<len(s) and self.isNum(s[j]):
                    total = int(s[j]) + total*10 
                    j += 1
                i = j-1
                print 'total: ' + str(total)
                nums.append(total)
            i += 1
        
        while len(ops) != 0:
            print 'ops: ' + str(ops) + ' nums: ' + str(nums)
            op = ops.pop(0) 
            a = nums.pop(0)
            b = nums.pop(0); 
            # print 'a: ' + str(a) + ' b: ' + str(b) + ' op: '
            nums.insert(0, self.count(a, b, op))
        
        print 'ans: ' + str(nums)
        return int(nums.pop())
    
    def isSuperOp(self, c):
        if c in ['*', '/']:
            return True 
        return False 
    
    def isLowOp(self, c):
        if c in ['+', '-']:
            return True 
        return False 
    
    def isNum(self, c):
        if '0'<=c and c<='9':
            return True
        return False 
        
    def count(self, a, b, op):
        a = int(a)
        b = int(b)
        if op == '*':
            return a * b
        if op == '/':
            return a / b
        if op == '+':
            return a + b
        if op == '-':
            return a - b
