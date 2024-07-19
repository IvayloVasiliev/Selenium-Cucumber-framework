Feature: Test Case Three

  Scenario Outline: Upload CV and apply for position with negative data
    Given I go to "home" page
      And I click on "Careers" tab
      And I am redirected to "Careers" page
      And I click on "Check our open positions" button
      And I am redirected to "Join us" page
    When I select "Anywhere" from "Filter by location" dropdown
      And I click on "Full-Stack Developer" element
      And I verify "General description" section is shown
      And I verify "Requirements" section is shown
      And I verify "Responsibilities" section is shown
      And I verify "What we offer" section is shown
      And I verify Apply button is present and click on it
      And I fill "Name" field with "<name>"
      And I fill "Email" field with "<email>"
      And I fill "Mobile" field with "<phone number>"
      And I fill "Your Message" field with "<message>"
      And I upload CV file
      And I check consent checkbox
      And I click on Send button
    Then I verify that error message "<error message>" appears


    Examples:
    | name     | email                | phone number | message                 | error message                          |
    | John Doe | john@doe             | 0876543210   | This is automated test  | The e-mail address entered is invalid. |
    |          | johndoe@fakemail.com | 0876543210   | This is automated test  | The field is required.                 |
    | John Doe | johndoe@fakemail.com |              | This is automated test  | The field is required.                 |


