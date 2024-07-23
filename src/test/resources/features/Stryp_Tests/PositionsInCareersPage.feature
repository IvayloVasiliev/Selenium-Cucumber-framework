Feature: Positions in Careers page

  Scenario Outline: Check if position is present in Careers page
    Given I navigate to "home" page
      And I click "Careers" button
      And I get redirected to "careers" page
    When I click "<position>" button
      And I verify position description contains "<responsibilities>"
      And I click "Apply now" button
      And I switch to the next tab
      And I get redirected to "apply" page
    Then I verify position "<position>" is ready to submit application

    Examples:
      | position                              | responsibilities                                                                                |
      | Automation Quality Assurance Engineer | Automate JavaScript (React) based web application testing using Selenium;                       |
      | Junior QA Engineer                    | At least 1 year of experience with Software Quality Assurance principles and procedures;        |
      | Python Developer                      | 3+ years of experience in programming in Python;                                                |
      | Python Web Developer                  | 4+ years of experience in programming in Python (Web);                                          |
      | Bid Manager                           | Identify and review opportunities for bid submissions to ensure they meet the company criteria; |
