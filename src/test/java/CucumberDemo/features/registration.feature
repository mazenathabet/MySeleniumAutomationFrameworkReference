Feature:

  @Regression @Sanity
  Scenario: User can Register Successfully
    Given User open website and go to homepage
    When  User clicks on Register Link
    And   User fills the registration form and clicks submit
    Then  User should be registered successfully

