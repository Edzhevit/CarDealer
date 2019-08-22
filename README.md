# Car Dealer
A car dealer holds information about cars, their parts, parts suppliers, customers and sales.
* Cars have make, model, and travelled distance in kilometers.
* Parts have name, price and quantity.
* Part supplier have name and info whether he uses imported parts.
* Customer has name, date of birth and info whether he/she is a young driver (Young driver is a driver that has less than 2 years of experience. Those customers get additional 5% off for the sale.).
* Sale has car, customer and discount percentage.
A price of a car is formed by the total price of its parts.

Using Code First approach create a database following the above description.
Configure the following relations in your models:
* A car has many parts and one part can be placed in many cars
* One supplier can supply many parts and each part can be delivered by only one supplier
* In one sale, only one car can be sold
* Each sale has one customer and a customer can buy many cars
# Car Dealer Import Data
Import data from the provided files (suppliers.json, parts.json, cars.json, customers.json).

First import the suppliers. When importing the parts, set to each part a random supplier from the already imported suppliers. Then, when importing the cars add between 10 and 20 random parts to each car. Then import all customers. Finally, import the sales records by randomly selecting a car, customer and the amount of discount to be applied (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).

# Car Dealer Query and Export Data

Write the below described queries and export the returned data to the specified format. 

### Query 1 – Ordered Customers
Get all customers, ordered by their birthdate in ascending order. If two customers are born on the same date, first print those, who are not young drivers (e.g. print experienced drivers first).

### Query 2 – Cars from make Toyota
Get all cars from make Toyota and order them by model alphabetically and then by travelled distance descending.

### Query 3 – Local Suppliers
Get all suppliers that do not import parts from abroad. Get their id, name and the number of parts they can offer to supply.

### Query 4 – Cars with Their List of Parts
Get all cars along with their list of parts. For the car get only make, model and travelled distance. For the parts get only the name and the price.

### Query 5 – Total Sales by Customer
Get all customers that have bought at least 1 car and get their names, count of cars bought and total money spent on cars. Order the result list by total money spent in descending order then by total cars bought again in descending order.

### Query 6 – Sales with Applied Discount
Get all sales with information about the car, the customer and the price of the sale with and without discount.
