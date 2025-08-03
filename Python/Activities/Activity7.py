#numList = [1,2,3,4]
numList = list(input("enter the numbers to add: ").split(","))
#Calculate the sum of all
sum = 0
for n in numList:
    sum = sum+ int(n)
    
print("Sum is: ", sum)    
