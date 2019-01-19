Feature: Login User

  Background:
    Given I am on the Homepage
    And I click sigin button

  @Login
  Scenario Outline: As a user I want to Login successfully
    When I enter email "<email>" details
    And I enter password "<passw>" details
    And I click Signin button
    Then I verify that I am logged in
    And I log out successfully

    Examples:
      | email                | passw  |
      | maxtest227@gmail.com | Today1 |

  @Login
  Scenario Outline: As a user I want to see error message when I Login incorrectly
    When I enter email "<email>" details
    And I enter password "<passw>" details
    And I click Signin button
    Then I see an error "<errormessage>" message details

    Examples:
      | email                | passw  |errormessage              |
      | maxtest964@gmail.com |        |Password is required.     |
      |                      | Today1 |An email address required.|
      | maxtest964@gmail.com | xxxxxx |Authentication failed.    |
      | xxxxxxxxxx@gmail.com | Today1 |Authentication failed.    |
      |                      |        |An email address required.|