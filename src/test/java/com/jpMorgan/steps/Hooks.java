package com.jpMorgan.steps;

public class Hooks {

// no need to create a main method

//     @Before
    public void setupStep(){

//        "Do something before each scenario"
//        Because there is only one URL, it can be used with @Before methods in Hooks class
//        RestAssured.baseURI = ConfigurationReader.getProperty("baseUrl");
    }

    // @After
    public void afterStep(){

        System.out.println("Do something after each scenario");
    }

}
