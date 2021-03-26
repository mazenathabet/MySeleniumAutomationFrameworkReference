Feature:Login Feature

  @Regression @login
  Scenario Outline: User can login with valid data
    Given User at the homepage
    When  User clicks on Register Link
    And   User fills the registration form "<firstname>" "<lastname>" "<email>" "<password>" and clicks submit
    And  User should be registered successfully
    And  user clicks on login link
    And   user login with valid data "<email>" and "<password>"
    Then  User should be logged in successfully and logout

    Examples:
      |firstname | lastname |     email         | password |
      |mazen     |   ahmed  |  test30@gmail.com | 12345678 |
#      |  test61@gmail.com | 12345678 |
