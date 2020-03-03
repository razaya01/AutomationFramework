#Author: yasin.raza@kingisher.com
Feature: creating an expired order from click and cloth same day product.

Scenario: Create a normal click and colect same day order.
When user hits agent-front url 
And login into agent-front by valid credentials
And place ccsd order through ccsd product and any valid customer


Scenario: create so for the ccsd order
When user hit fulfillment tool url
And create So through fulfillment tool

Scenario: perform allocation of ccsd product 
When validate user at homepage of agent-front 
And perform allocation of ccsd product

Scenario: change the date of operationTimeStamp to any past date
When user hits order repository in dyn admin
And perform all the necessary query in order to change operationTimeStamp to any past date

Scenario: Invoke the method of SendCollectionReminderScheduler in dyn admin
When user hits SendCollectionReminderScheduler url in dyn admin
And invoke the sendCollectionReminders method

Scenario: validate expired order is displaying in application
When user user go back to agent front
And validate expire order in application


