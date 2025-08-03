#numList = [1,2,3,1]
numList = list(input("enter the numbers to add: ").split(","))
#Check first and last numbers
if(numList[0]==numList[-1]):
    print("First and last element are the same.")
else:
    print("First and last element are not the same.")  