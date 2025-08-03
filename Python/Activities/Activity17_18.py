# Import pandas
import pandas as pd

# Create the dataset
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Convert the dataset into a  DataFrame
df = pd.DataFrame(data)

# Print the DataFrame
print(df)

#Write dataframe in CSV file
df.to_csv("./sample.csv", index=False)

#Write dataframe in CSV file (Activity18)
input_data = pd.read_csv("./sample.csv")

#Print the values only in the Usernames column
print("****Usernames****")
print(input_data['Usernames'])

#Print the username and password of the second row
print("****Passwords****")
print(input_data['Passwords'][1], input_data['Passwords'][1])

#Sort the Usernames column data in ascending order and print data
print("****Sorted Usernames****")
print(input_data.sort_values(by='Usernames', ascending=True))

#Sort the Passwords column in descending order and print data
print("****Sorted Passwords****")
print(input_data.sort_values(by='Passwords', ascending=False))