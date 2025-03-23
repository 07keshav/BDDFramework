Feature: UserLogin

  Scenario: Successful login
    Given User is on Greenkart Landing page
    When User adds items to card
    And User clicks on cart option 
    And User clicks on Proceed To checkout
    Then User is taken to cart Page
    When User clicks on Proceed Button
    Then User is taken to Delivery info Page
    When User click on Proceed Button
    Then User is taken to order confirmation page
    And User validates the Order Confirmaton page
    And User closes the browser
     