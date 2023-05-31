Feature: Send Email with invalid email address

  Scenario Outline: Send Email with invalid email address
    Given I go to "home" page
      And I scroll to the needed part of the page
      And I click on "Contact us" button
      And I fill "Name" field with "John Doe"
    When I fill "Email" field with "<email>"
      And I fill "Subject" field with "Test Case 1"
      And I fill "Your Message" field with "This is automated test"
      And I click on Send button
    Then I verify that error message "The e-mail address entered is invalid." appears

Examples:
    | email             |
    | John@Doe          |
    | johndoe@.com      |
    | JohnDoe.gmail.com |
    | 12346@789         |
    | something@fake    |