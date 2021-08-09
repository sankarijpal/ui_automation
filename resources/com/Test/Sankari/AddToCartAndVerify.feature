Feature:Add and verify under cart

  Scenario: Add and verify under cart
    Given I launch the URL
    And I login into the application
    And I verify the home screen displayed
    And I Click on tshirt link , verify tshirt page is displayed
    |T-SHIRTS|Faded Short Sleeve T-shirts|
    And I Click on proceed to check out button
    And I verify shopping cart summary page is displayed
    Then I verify whether the actual order tshirt details is displayed in the order history summary page
    Then I verify tshirt displayed in cart
    |Faded Short Sleeve T-shirts|
    And I take screenshot