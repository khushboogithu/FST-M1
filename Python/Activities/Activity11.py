fruits = {
    "apple": 100,
    "papaya": 30,
    "pineapple": 40,
    "guava": 20
}

search_item = input("What fruit would you like?:  ").lower()

if(search_item in fruits):
    print(search_item + " costs " + str(fruits[search_item]))
else:
    print("Fruit is out of stock")