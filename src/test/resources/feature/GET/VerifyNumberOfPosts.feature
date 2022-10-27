Feature: Verify the number of posts returned

  Background: Base URL
    Given I connect to the baseUrl

  @numberOfUser
  Scenario: To verify the number of post returned
    When retrieving all number of post returned
    And status code should be 200
    Then the number of userId returned 100

  @countId
  Scenario: Post should include sequence of "id" from 1 to 100
    When retrieving all number of post returned
    And status code should be 200
    Then the sequence posts in response should be 1 to 100

  @lastId
  Scenario: To verify the last id number
    When retrieving all number of post returned
    And status code should be 200
    Then the last id number returned 100

  @postContent
  Scenario: Each post should include UserId, Id, Title, Body
    When retrieving all number of post returned
    And status code should be 200
    Then each post should have "userId", "id", "title" and "body"