package exercises;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class RestAssuredExercises5Test {

	private static RequestSpecification requestSpec;

	@BeforeAll
	public static void createRequestSpecification() {

		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://localhost").
			setPort(9876).
			build();
	}
		
	/*******************************************************
	 * Get the list of speed records set by street legal cars
	 * use /xml/speedrecords
	 * Check that the third speed record in the list was set
	 * in 1955
	 ******************************************************/
	
	@Test
	public void checkThirdSpeedRecordWasSetIn1955() {
		
		given().
			spec(requestSpec).
		when().
                get("/xml/speedrecords").
		then()
                .body("speedRecords.car[2].year", equalTo("1955")).log().all();
	}
	
	/*******************************************************
	 * Get the list of speed records set by street legal cars
	 * use /xml/speedrecords
	 * Check that the fourth speed record in the list was set
	 * by an Aston Martin
	 ******************************************************/
	
	@Test
	public void checkFourthSpeedRecordWasSetbyAnAstonMartin() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
	
	/*******************************************************
	 * Get the list of speed records set by street legal cars
	 * use /xml/speedrecords
	 * Check that three speed records have been set by cars
	 * from the UK
	 ******************************************************/
	
	@Test
	public void checkThreeRecordsHaveBeenSetByCarsFromTheUK() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
	
	/*******************************************************
	 * Get the list of speed records set by street legal cars
	 * use /xml/speedrecords
	 * Check that four speed records have been set by cars
	 * from either Italy or Germany
	 ******************************************************/
	
	@Test
	public void checkFourRecordsHaveBeenSetByCarsFromEitherItalyOrGermany() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
	
	/*******************************************************
	 * Get the list of speed records set by street legal cars
	 * use /xml/speedrecords
	 * Check that two speed records have been set by cars
	 * whose make ends on 'Benz'
	 ******************************************************/
	
	@Test
	public void checkTwoRecordsHaveBeenSetByCarsWhoseMakeEndOnBenz() {
		
		given().
			spec(requestSpec).
		when().
		then();
	}
}