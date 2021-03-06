package tafe;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/*import com.carmax.sputnik.tafe.utils.SuiteBase;
import com.carmax.tafe.apiutils.TAFEEndPoints;
import com.carmax.tafe.calculateobjects.Calculate.CalculateResponse;
import com.carmax.tafe.getinputobjects.Getinputs.InputRequest;
import com.carmax.tafe.getinputobjects.Getinputs.InputResponse;*/

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TAFE_API_Tests extends Suite_Base {

	/*
	 * @Test(groups = { "tafe", "api", "regression" }) public void
	 * MyTestCaseNameGoesHere() {
	 * 
	 * String thirdPartyNumber = "0000001537";
	 * 
	 * Response response =
	 * given().spec(getSpec).when().get(TAFEEndPoints.getInputs((thirdPartyNumber)))
	 * ;
	 * 
	 * response.then().spec(resSpec).log().all();
	 * 
	 * //bankruptcy = Arrays.asList(response.getBody().as(Bankruptcy[].class));
	 * 
	 * //System.out.println("ticket:" + bankruptcy.get(0).ticket);
	 * 
	 * String statusCode = Integer.toString(response.getStatusCode());
	 * System.out.println("Status Code:" + statusCode);
	 * 
	 * }
	 */


	
	public void POSTestCase() {


		/*//Set up the inputRequest payload
		inputRequest.storeState = "VA";
		inputRequest.customerState = "VA";
		inputRequest.storeId = 7290;
		inputRequest.effectiveDate = "2019-10-10T01:00:00";
		inputRequest.contextProperties.key = "TafeSPA";
		inputRequest.contextProperties.value = "WebClient";

		Response response = given()
				.spec(postSpec)
				.body(inputRequest).log().all()
				.when()
				.post(TAFEEndPoints.postInputs());

		response.then().log().all();

		inputResponse = response.getBody().as(InputResponse.class);

		String displayName = "";
		String description = "";
		String name = "";
		String ruleName = "";
		String validation = "";

		System.out.println("@============================================");
		for(int i =0 ; i < inputResponse.inputs.length; i++)
		{
			displayName = inputResponse.inputs[i].displayName;
			description = inputResponse.inputs[i].description;
			name = inputResponse.inputs[i].name;
			ruleName = inputResponse.inputs[i].ruleName;
			validation = inputResponse.inputs[i].validation;

			//	System.out.println(displayName + " - " + ruleName);
		}

		//System.out.println("============================================");
		//System.out.println("displayName: " + displayName);

		//		inputResponse.inputparameters.storeState
		//System.out.println(inputResponse.inputParameters.contextProperties.key + "---");
		//		
		calculateRequest.inputparameters.contextProperties.key = inputResponse.inputParameters.contextProperties.key;
		calculateRequest.inputparameters.contextProperties.value = inputResponse.inputParameters.contextProperties.value;
		calculateRequest.inputparameters.customerState = inputResponse.inputParameters.customerState;

		calculateRequest.inputparameters.effectiveDate = inputResponse.inputParameters.effectiveDate;

		calculateRequest.inputparameters.storeId = inputResponse.inputParameters.storeId;
		calculateRequest.inputparameters.storeState = inputResponse.inputParameters.storeState;




		System.out.println(inputResponse.inputs.length);
		
		 * for(int i =1 ; i < inputResponse.inputs.length; i++) {
		 * System.out.println(inputResponse.inputs[i].id); calculateRequest.inputs[i].id
		 * = inputResponse.inputs[i].id; calculateRequest.inputs[i].displayName =
		 * inputResponse.inputs[i].displayName; calculateRequest.inputs[i].description =
		 * inputResponse.inputs[i].description; calculateRequest.inputs[i].name =
		 * inputResponse.inputs[i].name; calculateRequest.inputs[i].ruleName =
		 * inputResponse.inputs[i].ruleName; calculateRequest.inputs[i].validation =
		 * inputResponse.inputs[i].validation; calculateRequest.inputs[i].value =
		 * "2000";
		 * 
		 * System.out.println(inputResponse.inputs[i].id + ": id ");
		 * 
		 * }
		 

		calculateRequest.inputs[0].id = inputResponse.inputs[0].id;
		calculateRequest.inputs[0].displayName = inputResponse.inputs[0].displayName;
		calculateRequest.inputs[0].description = inputResponse.inputs[0].description;
		calculateRequest.inputs[0].name = inputResponse.inputs[0].name;
		calculateRequest.inputs[0].ruleName = inputResponse.inputs[0].ruleName;
		calculateRequest.inputs[0].validation = inputResponse.inputs[0].validation;
		calculateRequest.inputs[0].value = "2000";
		
		calculateRequest.inputs[1].id = inputResponse.inputs[1].id;
		calculateRequest.inputs[1].displayName = inputResponse.inputs[1].displayName;
		calculateRequest.inputs[1].description = inputResponse.inputs[1].description;
		calculateRequest.inputs[1].name = inputResponse.inputs[1].name;
		calculateRequest.inputs[1].ruleName = inputResponse.inputs[1].ruleName;
		calculateRequest.inputs[1].validation = inputResponse.inputs[1].validation;
		calculateRequest.inputs[1].value = "2000";
		
		
		 * calculateRequest.inputs[0].value = "100"; calculateRequest.inputs[1].value =
		 * "34"; calculateRequest.inputs[2].value = "12/24/2019";
		 * calculateRequest.inputs[3].value = "2000"; calculateRequest.inputs[4].value =
		 * "";
		 

		//		
		//		if(displayName.equals("Your SOAP XML")) {
		//			//do something
		//		} else {
		//			//do something else
		//		}
		//		
		//		//create method to move data from inputREsponse to calucalteRequest
		//
		//		String statusCode = Integer.toString(response.getStatusCode());
		//		System.out.println("Status Code:" + statusCode);


		response = given()
				.spec(postSpec)
				.body(calculateRequest).log().all()
				.when()
				.post(TAFEEndPoints.postInputs());

		response.then().log().all();

		calculateResponse = response.getBody().as(CalculateResult.class);
*/

	}

	
	
	
}
