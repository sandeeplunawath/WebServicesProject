package webServices_SOAP;


import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;


import io.restassured.RestAssured;
//import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestUtilities {

	public static String ENDPOINT;
	public static RequestSpecBuilder requestBuilder;
	public static RequestSpecification requestSpec;
	public static ResponseSpecBuilder RESPONSE_BUILDER;
	public static ResponseSpecification RESPONSE_SPEC;
	public static RestAssuredConfig config;
	

	private String trust_store_path = System.getenv("JAVA_HOME").toString() + "/jre/lib/security/cacerts";
	private String trust_store_password = "changeit";
	private String certificate_path = "src/test/resources/data/uploadFiles/";
	private String certificate_password = "test";

	//ReportLog test;
	private String apiKey;
	private String baseURI;
	private String basePath;
	private String userID;
	private String password;

	public RestUtilities(String apiKey, String userId, String password, String baseURI, String basePath) {
		this.apiKey = apiKey;
		this.basePath = basePath;
		this.baseURI = baseURI;
		this.userID = userId;
		this.password = password;
	}

	public RestUtilities(String baseURI, String basePath, String userID, String password) {
		this.basePath = basePath;
		this.baseURI = baseURI;
		this.userID = userID;
		this.password = password;
	}

	public RestUtilities(String baseURI, String basePath) {
		this.basePath = basePath;
		this.baseURI = baseURI;
	}

	// public void setEndPoint(String endPoint) {
	// ENDPOINT = endPoint;
	// }

//	public RequestSpecification getRequestSpecification() {
//		requestBuilder = new RequestSpecBuilder();
//		requestBuilder.setBaseUri(baseURI);
//		requestBuilder.setBasePath(basePath);
//		if (apiKey != null) {
//			requestBuilder.addParam("api_key", apiKey);
//		}
//		requestBuilder.setRelaxedHTTPSValidation();
//		requestBuilder.setContentType("application/json");
//		requestSpec = requestBuilder.build();
//		return requestSpec;
//	}

	public RequestSpecification postRequestSpecification() {

		
//		requestSpec.baseUri(baseURI);
//		requestSpec.basePath(basePath);
//		requestSpec.queryParam("api_key", apiKey);
//		requestSpec.contentType("application/json");
//		requestSpec.relaxedHTTPSValidation();
//		
//		client_certificate_path += "tafedeveastuskvlt-ApigeeTafeDevApi-20191011.pfx";
//
//		config = RestAssured.config().sslConfig(new SSLConfig().trustStore(trust_store_path, trust_store_password)
//				.keyStore(client_certificate_path, client_certificate_password).and().allowAllHostnames());
//
//		requestSpec.config(config);


		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri(baseURI);
		requestBuilder.setBasePath(basePath);
		requestBuilder.setContentType("application/json");
		requestBuilder.setRelaxedHTTPSValidation();
		requestBuilder.addHeader("apiKey", apiKey);

		certificate_path += "tafedeveastuskvlt-ApigeeTafeDevApi-20191011.pfx";

		config = RestAssured.config().sslConfig(new SSLConfig().trustStore(trust_store_path, trust_store_password)
				.keyStore(certificate_path, certificate_password).and().allowAllHostnames());

		requestBuilder.setConfig(config);
		requestSpec = requestBuilder.build();
		return requestSpec;
	}

	public ResponseSpecification getResponseSpecification() {
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		// RESPONSE_BUILDER.expectStatusCode(200);
		RESPONSE_BUILDER.expectResponseTime(lessThan(20L), TimeUnit.SECONDS);
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}

}
