package co.com.practice.stepdefinitions;

import co.com.practice.utils.TestDataReader;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {

    @Before
    public void configureBaseUrl(){

        setTheStage(new OnlineCast());
        theActorCalled("Request");

        String theRestApiBaseUrl = (TestDataReader.getProperty("qa.base.url"));


        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
