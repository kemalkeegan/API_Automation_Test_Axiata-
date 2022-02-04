Feature: User functionality
  As a user
  I want to create user, get user, edit user, and delete user
  So that I am success goals mvp

  @CreateUser
  #Create User
  Scenario: I want to create, get, edit, and delete user
    Given I am create user
    When I am set body request sign
    And I am hit endpoint signup
    Then I am get a status code 201
    And validate success signup
    And I am hit endpoint get user
    And I am get a status code 200
    And validate success get user
    And I am hit endpoint edit user
    And I am get a status code 200
    And validate success edit user
    And I am hit endpoint delete user
    And I am get a status code 204