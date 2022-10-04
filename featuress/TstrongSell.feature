Feature: fetaure to test Companies of Strong_Buy and Strong_Sell are equal

  Scenario: Check Strong_Buy and Strong_Sell are equal
    Given browser is open
    When user is on the Trading_view application
    When user goes to Stocks page
    And click on the Quotes tab
    When get the list of Strong_buy, Strong_sell from the table
    And compare the list
    Then print the result
