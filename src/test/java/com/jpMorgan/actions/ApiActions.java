package com.jpMorgan.actions;

import com.jpMorgan.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiActions {

    Response response;
    List<Map<String, Object>> listOfPost;

    public void connectToAPI() {
//        Because there is only one URL, it can be used with @Before methods in Hooks class
        RestAssured.baseURI = ConfigurationReader.getProperty("baseUrl");

        response = given().accept(ContentType.JSON)
                .when().get();
    }

    public void getResponse() {

        listOfPost = response.jsonPath().get();
    }

    public int getStatusCode() {

        return response.statusCode();
    }

    public int getNumberOfPost() {

        return listOfPost.size();
    }

    public boolean verifyLastId(Integer lastId) {

        boolean flag = false;

        for (Map<String, Object> post : listOfPost) {
            if (post.get("id") == lastId) {

                flag = true;
                break;
            }
        }
        return flag;
    }

    public void verifySequenceOfPost(int firstIndex, int lastIndex) {

        for (int i = 0; i < listOfPost.size(); i++) {
            int postIdValue = (int) listOfPost.get(i).get("id");
            Assert.assertEquals(postIdValue, firstIndex + i);
        }
        Assert.assertEquals(listOfPost.get(listOfPost.size() - 1).get("id"), lastIndex);
    }

    public boolean verifyContentOfPost(String userId, String id, String title, String body) {
        boolean flag = true;

        for (int i = 0; i < listOfPost.size(); i++) {

            if (!listOfPost.get(i).equals(null)) {

                if (listOfPost.get(i).get(userId).equals(null) || listOfPost.get(i).get(id).equals(null) || listOfPost.get(i).get(title).equals(null) || listOfPost.get(i).get(body).equals(null)) {

                    flag = false;
                    break;
                }
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
