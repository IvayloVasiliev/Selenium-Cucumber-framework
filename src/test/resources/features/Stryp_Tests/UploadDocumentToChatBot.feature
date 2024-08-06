@ExampleTaggedScenario
Feature: Upload document to ChatBot

  Scenario: ChatBot document upload
    Given I navigate to "home" page
      And I open the ChatBot dialog window
      And I consent ChatBot cookies
      And I click "Recruitment" button
      And I verify the ChatBot answer equals "Before we move on, can I please have your first and last name?"
    When I upload a "TestCV.docx" file
    Then I verify the ChatBot answer equals "Thank you, Message Sent With Files But No. In case we get disconnected, what is your email?"