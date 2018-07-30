package exercises;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RestAssuredExercises4Test {

    private static RequestSpecification requestSpec;


    @BeforeAll
    static void setUp() {
        createRequestSpecification();
        retrieveOAuthToken();
    }


    static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(9876).
                setBasePath("/api/f1").
                build();
    }

    /*******************************************************
     * Request an authentication token through the API
     * and extract the value of the access_token field in
     * the response to a String variable.
     * Use preemptive Basic authentication:
     * username = oauth
     * password = gimmeatoken
     * Use /oauth2/token
     ******************************************************/

    private static String accessToken;

    public static void retrieveOAuthToken() {
        String responseBody =
                given().spec(requestSpec).auth().preemptive().basic("oauth", "gimmeatoken")
                .when()
                .get("/oauth2/token").asString();
        accessToken = JsonPath.from(responseBody).get("access_token");
    }

    /*******************************************************
     * Request a list of payments for this account and check
     * that the number of payments made equals 4.
     * Use OAuth2 authentication with the previously retrieved
     * authentication token.
     * Use /payments
     * Value to be retrieved is in the paymentsCount field
     ******************************************************/

    @Test
    public void checkNumberOfPayments() {
        retrieveOAuthToken();
        given().
                spec(requestSpec).auth().preemptive().oauth2(accessToken).
                when().
                get("/payments").
                then().
                body("paymentsCount", is(4)).log().all();
    }

    /*******************************************************
     * Request the list of all circuits that hosted a
     * Formula 1 race in 2014 and check that this request is
     * answered within 100 ms
     * Use /2014/circuits.json
     ******************************************************/

    @Test
    public void checkResponseTimeFor2014CircuitList() {

        given().
                spec(requestSpec).
                when().
                then();
    }
}
