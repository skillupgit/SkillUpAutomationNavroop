Feature: Login feature


Scenario Outline: Login Success
  Given I Open Login Page
  When I Enter Email"<email>"
  And I Enter Password "<password>"
  And I Submit
  Then I am Logged In
  Examples:
    | email                  | password      |
    | student@skillup.study   | Intern$hip001 |

  Scenario Outline: Login NotSuccess
    Given I Open Login Page
    When I Enter Email"<email>"
    And I Enter Password "<password>"
    And I Submit
    Then I am Notlogged In
    Examples:
      | email                  | password      |
      |   invalid@koel.dev       | Intern$hip001 |
      |   student@skillup.study  | invalidPassword |
      |                          |               |


