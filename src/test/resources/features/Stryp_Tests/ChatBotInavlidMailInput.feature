Feature: ChatBot invalid mail input

  Scenario: Checking ChatBot invalid mail address answer
    Given I navigate to "home" page
      And I open the ChatBot dialog window
    When I click "Recruitment" button
      And I verify the ChatBot answer equals "Before we move on, can I please have your first and last name?"
      And I provide "John Doe" message in Chat field
      And I verify the ChatBot answer equals "Thank you, John. In case we get disconnected, what is your email?"
      And I provide "invalidMail.com" message in Chat field
      And I verify the ChatBot answer equals "I'm sorry, that doesn't look like an email address. Can you try again?"
      And I provide "invalid@mail" message in Chat field
      And I verify the ChatBot answer equals "I'm sorry, that doesn't look like an email address. Can you try again?"
      And I provide "invalid@.com" message in Chat field
    Then I verify the ChatBot answer equals "I'm sorry, that doesn't look like an email address. Can you try again?"