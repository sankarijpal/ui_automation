Feature:Update Personal Information details

  Scenario: Update the lastname from personal information
    Given I launch the URL
    And I login into the application
    And I verify the home screen displayed
    And I update the lastname "Ipswich"
    Then I take screenshot
