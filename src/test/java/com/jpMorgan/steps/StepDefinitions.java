package com.jpMorgan.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpMorgan.actions.ApiActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions extends ApiActions {

    @Given("I connect to the baseUrl")
    public void iConnectToTheBaseUrl() {

        connectToAPI();
    }
    @When("retrieving all number of post returned")
    public void retrieving_all_number_of_post_returned() throws JsonProcessingException {

        getResponse();
    }
    @And("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {

        Assert.assertEquals(getStatusCode(), expectedStatusCode);
    }
    @Then("the number of userId returned {int}")
    public void the_number_of_userId_returned(int expectedNumberOfPost) {

        Assert.assertEquals(getNumberOfPost(), expectedNumberOfPost);
    }
    @Then("the last id number returned {int}")
    public void the_last_id_number_returned(Integer lastId) {

        Assert.assertTrue(verifyLastId(lastId));
    }
    @Then("the sequence posts in response should be {int} to {int}")
    public void the_sequence_posts_in_response_should_be_to(int firstIndex, int lastIndex) {

        verifySequenceOfPost(firstIndex, lastIndex);
    }
    @Then("each post should have {string}, {string}, {string} and {string}")
    public void eachPostShouldHaveAnd(String userId, String id, String title, String body) {

        Assert.assertTrue(verifyContentOfPost(userId, id, title, body));
    }
}
