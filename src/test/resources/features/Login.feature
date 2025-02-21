Feature: Login Functionality for the Application

  As a user of the application
  I want to be able to log in with my account
  So that I can access my account-related features

  Background:
    Given I am on the login page

  Scenario: Successful login with valid credentials
    Given I enter a valid username and password
     When I click on the login button
     Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I enter "<username>" and "<password>"
     When I click on the login button
     Then I should see an error message "<error_message>"

    Examples:
      | username          | password      | error_message                                                             |
      | standard_user     | wrongPass     | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user   | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user     |               | Epic sadface: Password is required                                        |