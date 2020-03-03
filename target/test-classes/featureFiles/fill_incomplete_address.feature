#Author: yasin.raza@kingfisher.com
Feature: This automation script will fill the incomplete address in checkout page and then will run its corresponding script in jenkins


Scenario: fill the incomplete address
Given navigate to agent front
When provide valid credentials
And navigate upto checkout page


Scenario: re-built corresponding script

When Launch script in jenkins with defined user
And re-trigger failed scripts with same tabs

Scenario: check google api mock
When Launch mock configration page in dyn admin
 
