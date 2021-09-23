
Feature: place order As a guest user from the web site


Description: customer can search on the products and checkout the orders from Nopecommerce website

@login
Scenario Outline: check customer can place an order by purchasing an item from search

Given user on the home page
When he search for "<productName>"
And Add the products in the shooping cart 
And moves to checkout cart and enter personal details on checkout page and place the order
Then he can view the order and download the invoice


Examples:

  | productName | 
  | MacB        |

   