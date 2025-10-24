# PayFlow
A payment gateway system that merchants can integrate into their websites.

# How to use
Run the backend which is located in src/main/java/PayFlowApplication.java  
Run the demo Merchant Portal page in demo/portal.html  
Run the demo User Checkout page in demo/checkout.html  

Notes:
-Email cannot be already used  
-Passwords have to match when registering  
-Demo checkout page has a set merchant id of 1. The first merchant account that is registered also has a merchant id of 1    
-After logging in, each merchant can view every transaction under their merchantid. Therefore, with our demo, the second registration (eg. merchant id 2), will never show any transactions  
-Transaction will be logged as FAILED if the card does not match exactly 4242424242424242, 12/24 and 123  

# Things to improve
We can use the API KEY passed through the header for more security checks  
Error Handling could be better  
Design the css file for the payment widget  
Merchant accessing the api should be easier  
Design the webhook url notification system  
Encrypt passwords and apikey for extra security  
Make backend tests  
