Feature: Test Case Two

  Scenario: Verify that Company URL and Facebook URl loads correctly
    Given I go to "home" page
      And I click on "Company" tab
      And I am redirected to "Company" page
      And I verify that there is Leadership section
    When I click on Facebook icon
     And I switch tab
     And I am redirected to "Facebook" page
    Then I verify that Musala Soft profile picture appears