#Type 1

num = {1, 2, 3, 10, 40, 156, 200}
sum = 0

for n in num:
  sum += n

print(sum)

#Type2
numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum1 = 0

for number in numbers:
  sum1 += int(number)

print(sum1)