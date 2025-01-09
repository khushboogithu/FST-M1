# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
  
  # Open the browser to the URL
  driver.get("https://training-support.net")
  print ("Page title1: " + driver.title)
  
  About_US_button = driver.find_element(By.LINK_TEXT, "About Us")
  
  print ("Page title2: " + driver.title)
  # Perform testing and assertions
  ...
  
  # Close the browser
  # Feel free to comment out the line below
  # so it doesn't close too quickly
  driver.quit()