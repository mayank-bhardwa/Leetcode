class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -1<<31 and divisor == -1:
            return (1<<31) - 1
        
        sign = (dividend < 0) != (divisor < 0)
        
        dividend = abs(dividend)
        divisor = abs(divisor)
        
        res = 0
        while dividend >= divisor:
            x = 0
            while dividend >= divisor << 1 << x:
                x+=1
            
            dividend -= divisor << x
            res += 1<<x
        
    
        if sign:
            res = -res
        
        return res
    
if __name__ == "main":
    dividend = 10
    divisor = 3
    s = Solution()
    res = s.divide(dividend,divisor)
    print(res)