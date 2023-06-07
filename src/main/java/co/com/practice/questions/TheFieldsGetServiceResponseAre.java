package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

public class TheFieldsGetServiceResponseAre implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format("Validation fields get service", "get"),
                        response -> response.assertThat()
                                .body("userId", isA(Integer.class))
                                .and().body("id", equalTo(1))
                                .and().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                                .and().body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
                ));

        return true;
    }

    public static TheFieldsGetServiceResponseAre expected() {
        return new TheFieldsGetServiceResponseAre();
    }
}
