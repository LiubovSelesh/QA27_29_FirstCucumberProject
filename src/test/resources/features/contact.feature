Feature: Contact

  @contact
  Scenario: Add Contacts
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid data
    And Click on Login button
    And Click on ADD tab
    And Enter data form for contacts
    And Click on Save button
    Then Appear contact


  @removeContact
  Scenario: Add Contacts
    Given Navigate to Home Page
    When Click on Login tab
    And Enter valid data
    And Click on Login button
    And Click on ADD tab
    And Enter data form for contacts
    And Click on Save button
    And Click on contact tab
    And Click on Remove button
    Then Appear message
