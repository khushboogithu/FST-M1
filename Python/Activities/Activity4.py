while True:
    User1 = input("enter your chance(rocks,paper,scissors): ").lower()
    User2 = input("enter your chance(rocks,paper,scissors): ").lower()
    if(User1==User2):
        print("Match is Tie")
    elif(User1=="rocks"):  
        if(User2=="scissors"):
            print("User1 is a winner")  
        else:
            print("User2 is a winner") 
    elif(User1=="scissors"):  
        if(User2=="paper"):
            print("User1 is a winner")  
        else:
            print("User2 is a winner") 
    elif(User1=="paper"): 
        if(User2=="rocks"):
            print("User1 is a winner") 
        else:
            print("User2 is a winner")       
    else:
        print("Invalid input, Try again")  
        

playAgain = input("Do you want to play another round? Yes/No: ").lower()        
if(playAgain=="yes"):
    pass
else:
    exit