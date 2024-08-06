Feature: ChatBot functions

  Scenario Outline: Checking ChatBot function buttons and messaging
    Given I navigate to "home" page
      And I open the ChatBot dialog window
    When I click "<function button>" button
      And I verify the ChatBot answer equals "Before we move on, can I please have your first and last name?"
      And I provide "John Doe" message in Chat field
      And I verify the ChatBot answer equals "<chatbot email asnwer>"
      And I provide "fakemail@test.com" message in Chat field
    Then I verify the ChatBot answer equals "<chatbot proceed answer>"

    Examples:
      | function button     | chatbot email asnwer                                                         | chatbot proceed answer                                                         |
      #| Recruitment         | Thank you, John. In case we get disconnected, what is your email?            | Are you interested in our career opportunities, internships or something else? |
      | Software Solutions  | Thank you ,John. In case we get disconnected, what is your business email?   | Great! How would you like to proceed?                                          |
      | Other               | Thank you ,John. In case we get disconnected, what is your business email?   | Great! How would you like to proceed?                                          |
