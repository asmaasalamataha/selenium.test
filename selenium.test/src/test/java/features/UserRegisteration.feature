
Feature: User Registration
@checkout
	Scenario Outline: check that the user can register on our e-commerce website.
	Given the user in the home page
	When I click on register link
	And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
	Then The registration page displayed successfully
 
 	Examples:
 	 | firstname | lastname | email | password |
 	 | ahmed | mohamed | ahmed145@use.com | 12345678 |
 	 | Moataz | ahmed | test4578@newus0.com | 87654321 |
 	  