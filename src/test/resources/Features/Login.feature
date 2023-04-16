Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  # when to use Scenario Outline
    # if you want to use parameterization
  # if you want to use data driven testing

  # Scenario Outline is always used with the keyword 'Examples'
  @scenarioOutline
  # Parameterization/ Data Driven testing can also be achieved through parameterization in Scenario Outline
  Scenario Outline: # the Scenario Outline and Examples must be used together
     #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
  Examples:
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | jASON    | Hum@nhrm123 |

    # data Table
  @dataTable
  Scenario:  Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | jASON    | Hum@nhrm123 |





















