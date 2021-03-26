Feature: Registration Feature

  @Regression @Sanity @register
 Scenario Outline: User can Register Successfully
    Given User at the homepage
    When  User clicks on Register Link
    And   User fills the registration form "<firstname>" "<lastname>" "<email>" "<password>" and clicks submit
    Then  User should be registered successfully
    Examples:
      | firstname | lastname |      email     | password |
      |   Mazen   | Ahmed    |test1@gmail.com | 12345678|
#      |   Mazen  | Ahmed    |test61@gmail.com| 12345678|
