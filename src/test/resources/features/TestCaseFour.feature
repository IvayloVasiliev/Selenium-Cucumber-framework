Feature: Test Case Four

  Scenario: Get job positions and print them on the console
    Given I go to "home" page
      And I click on "Careers" tab
      And I am redirected to "Careers" page
      And I click on "Check our open positions" button
      And I am redirected to "Join us" page
    When I select "Sofia" from "Filter by location" dropdown
      And I get all position in "Sofia" available on the page
      And I select "Skopje" from "Filter by location" dropdown
      And I get all position in "Skopje" available on the page
    Then I print positions on console