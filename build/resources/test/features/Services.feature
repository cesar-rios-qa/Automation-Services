Feature: As a user
  I want to validate
  that all services are correct.

  Scenario: Successfully obtaining a resource
    Given I Load customer information
      | id |
      | 1  |
    When I call Get user API
    Then I should see the status code 200
    And I validate schema response "GetJsonSchema"
    And Validate field and Value get response api
