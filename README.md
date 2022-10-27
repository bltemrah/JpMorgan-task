# QA TASK
### Verify the Number of the Posts in Response Body

In this task, GET Http request is used for "https://jsonplaceholder.typicode.com/posts" URI. 
It is expected to have 100 posts in response body.

### Key Features

- Framework: Cucumber BDD framework with Gherkin DSL
- Software language: Java 1.8.0_311
- Project build: Maven
- Library: JUnit
- Architect: Page Object Model (Multi layer object)

### Definition

- All related dependencies and plugin added in the pom.xml file
- Because there is only one URI, I put it in the configuration.properties file, and call it by helping ConfigurationReader class
- All test scenarios are under "VerifyNumberOfPosts" feature
- Runners class is under runners folder to execute a specific test scenario(s) by using their tag(s)
- ApiActions class includes all actions for the StepDefinitions class
- To use ApiActions in StepDefinitions, I prefer inheritance with extends key word. However, it is also possible to use constructor with object. 
- Because there is only one URL, it can be used with @Before methods in Hooks class
- Although no need to use Hooks class for this task, I add it for "@Before" and "@After" method to the framework
- Although no need to use Pojo class for this task, I add it for deserialization to the framework

### Test scenarios

  To verify the number of the posts in the response body, I use the below scenarios;

- Scenario 1 (@numberOfUser): Verify the number of userId in the post returned
- Scenario 2 (@countId): Verify the sequence of "id" from 1 to 100 in the post returned
- Scenario 3 (@lastId): Verify that the value of the last id number returns 100
- Scenario 4 (@postContent): Verify each post should include UserId, id, Title, Body



