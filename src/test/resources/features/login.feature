Feature: Login

  @validData
  Scenario: Login with valid data
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid data
    And Click on Login button
    Then SignOut button displayed

  @invalidPassword
  Scenario Outline: Login with invalid password
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid email and invalid password
      | email   | password   |
      | <email> | <password> |
    And Click on Login button
    Then Alert appeared
    Examples:
      | email            | password       |
      | ron+21@gmail.com | ro1234567$     |
      | ron+21@gmail.com | RR1234567$     |
      | ron+21@gmail.com | Rr12$          |
      | ron+21@gmail.com | Ro12345678952$ |
    