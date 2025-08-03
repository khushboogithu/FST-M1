# Import pandas
import pandas as pd
from pandas import ExcelWriter

# Create a dataset
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# Convert a dataset into a DataFrame 
df = pd.DataFrame(data)

# Print the dataframe
print(df)

# Write the dataframe to a Excel(.xlsx) file
writer = ExcelWriter('./sample.xlsx')
df.to_excel(writer, sheet_name='Sheet1', index = False)

#Save the excel file
#writer.save()

# Commit data to the Excel file
writer.close()

#Activity20

# Read data from Excel sheet
df = pd.read_excel('./sample.xlsx')

# Print the dataframe
print(df)

# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", df.shape)

# Print the data in the emails column only
print("====================================")
print("Emails:")
print(df['Email'])

# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(df.sort_values('FirstName'))