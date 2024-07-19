Feature: ChatBot functions

  Scenario: Checking ChatBot recruitment button function
    Given I navigate to "home" page
      And I open the ChatBot dialog window
    When I click "Recruitment" button
    And I verify the ChatBot answer equals "Before we move on, can I please have your first and last name?"
    And I provide "John Doe" message in Chat field
    And I verify the ChatBot answer equals "Thank you, John. In case we get disconnected, what is your email?"
    And I provide "fakemail@test.com" message in Chat field
    And I verify the ChatBot answer equals "Are you interested in our career opportunities, internships or something else?"