name = input("Enter your name: ")
age = int(input("Enter your age: "))

# Calculate the year in which user turns 100
year_when_100 = 2025 + (100-age)
print(name + " will turn 100 in the year " + str(year_when_100))
print(name + " will turn 100 in the year {}".format(year_when_100))