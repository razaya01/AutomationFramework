#Author: yasin.raza@kingfisher.com
Feature: This automation script will clear the open order in allocation page by closing it
Description: By clearing the open order in allocation page we are intented to increase the loading performance in slock allocation page.

Scenario: perform allocation and collection of open orders
Given user hits b&q agent-front
When user login into b&q homepage with agent id and password and by providing store code
And perform allocation and collection process for open order



