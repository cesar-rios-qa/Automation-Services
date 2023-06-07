package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.questions.StatusCode;
import co.com.practice.questions.TheFieldsGetServiceResponseAre;
import co.com.practice.questions.TheSchemaIs;
import co.com.practice.tasks.ConsumeGet;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class GetStepdefinitions {

    @Given("I Load customer information")
    public void iLoadCustomerInformation(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }

    @When("I call Get user API")
    public void iCallGetUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndPoints.URI.getUrl()
                )
        );
    }

    @Then("I should see the status code {int}")
    public void iShouldSeeTheStatusCode(int responseCode) {
        theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );

    }

    @Then("I validate schema response {string}")
    public void iValidateSchemaResponse(String schemaResponse) {
        theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(TheSchemaIs.expected(schemaResponse))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );

    }

    @Then("Validate field and Value get response api")
    public void validateFieldGetResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }




}

