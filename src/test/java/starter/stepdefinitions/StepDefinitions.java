package starter.stepdefinitions;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.verifone.User_json.CallPermissionRespJson;
//import com.verifone.User_json.Jsontojava;
//import com.verifone.cucumber.common.steps.CommonRestSteps;
//import com.verifone.util.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
//import org.json.JSONException;
import org.junit.Assert;
import util.TestBase;
import util.TestUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

//import static com.verifone.User_json.CallPermissionRespJson.analyzePermissionRespMap;

//billy Yang
public class StepDefinitions extends TestBase {

    public static Response responsedeleted = null;
    public static int userid;
    public static int roleuserid;
    public static String token;
    public static String env;
    public static String baseUrl;
    public static String qaAPIbaseUrl;
    public static String qaPdrsAPIbaseUrl;
    public static String qaSelfRegistUrl;
    public static String qatAPIbaseUrl;
    public static String qatPdrsAPIbaseUrl;
    public static String qatSelfRegistUrl;
    public static String VFIhelpDeskToken;
    public static String TestToken;
    public static String TestTokenResponseFilePath;
    public static String merchantAdmin1Token;
    public static String merchantQatAdmin1;
    public static String majorOilAdmin1Token;
    public static String majorOilAdmin2Token;
    public static String majorOilAdminSubToken;
    public static String merchantAdmin2Token;
    public static String merchantAdmin3Token;
    public static String merchantSubToken;
    public static String SiteAssetToken;
    public String APIresponse;
//
//    static TreeMap<String, String> permissionMap;
//    Response response;
//    RequestSpecification httpRequest;
//    @Steps
//    CommonRestSteps commonRestSteps;
//
//
    @When("disabled certificate")
    public void disabled_certificate() {
        RestAssured.useRelaxedHTTPSValidation();

    }
//
//    @When("set base url based on environment variables")
//    public String setBaseUrlBasedOnEnvironmentVariables() {
//        env = prop.getProperty("env");
//        qaAPIbaseUrl = prop.getProperty("qaAPIbaseUrl");
//        baseUrl = null;
//        switch (env) {
//            case "qa":
//                baseUrl = qaAPIbaseUrl;
//                break;
//            case "qat":
//                baseUrl = qatAPIbaseUrl;
//                break;
//        }
//        return baseUrl;
//    }

    @When("set base url based on environment variables and service {string}")
    public String setBaseUrlBasedOnEnvironmentVariablesAndService(String microService) {
        env = prop.getProperty("env");
        qaAPIbaseUrl = prop.getProperty("qaAPIbaseUrl");
        qaPdrsAPIbaseUrl = prop.getProperty("qaPdrsAPIbaseUrl");
        baseUrl = null;
        switch (env) {
            case "qa": {
                switch (microService) {
                    case "pems":
                        baseUrl = qaAPIbaseUrl;
                        break;
                    case "pdrs":
                        baseUrl = qaPdrsAPIbaseUrl;
                        break;
                }
            }
            break;
            case "qat": {
                switch (microService) {
                    case "pems":
                        baseUrl = qatAPIbaseUrl;
                        break;
                    case "pdrs":
                        baseUrl = qatPdrsAPIbaseUrl;
                        break;
                }

            }
            break;
        }
        return baseUrl;
    }

//    @When("set {string} base url based on environment variables")
//    public String setBaseUrlBasedOnEnvironmentVariables(String urlName) {
//        env = prop.getProperty("env");
//        System.out.println("env is:" + env);
//        qaAPIbaseUrl = prop.getProperty("qaAPIbaseUrl");
//        qatAPIbaseUrl = prop.getProperty("qatAPIbaseUrl");
//        qaPdrsAPIbaseUrl = prop.getProperty("qatPdrsAPIbaseUrl");
//        qaSelfRegistUrl = prop.getProperty("selfRegistUrl");
//        qatSelfRegistUrl = prop.getProperty("selfRegistQatUrl");
//        baseUrl = null;
//        switch (env) {
//            case "qa":
//                switch (urlName) {
//                    case "selfRegist":
//                        baseUrl = qaSelfRegistUrl;
//                        break;
//                }
//                break;
//            case "qat":
//                switch (urlName) {
//                    case "selfRegist":
//                        baseUrl = qatSelfRegistUrl;
//                        break;
//                }
//                break;
//        }
//        System.out.println("baseUrl is:" + baseUrl);
//        return baseUrl;
//
//
//    }
//
//
//    @Then("{string} token get id from response and get user details")
//    public void tokenGetIdFromResponseAndGetUserDetails(String tokenName)  throws IOException  {
////        String token = null;
////        switch (tokenName) {
////            case "merchantAdmin1Token":
////                token = merchantAdmin1Token;
////                break;
////            case "merchantAdmin3Token":
////                token = merchantAdmin3Token;
////                break;
////        }
//        String token = null;
//        TestUtil tul = new TestUtil();
//        token = tul.selectTokenByName(tokenName);
//        int userid12 = createUserStepDefinitions.userID;
//        Response response = null;
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(token).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).
//                        get("https://52.54.246.176:5001/v1/users/" + createUserStepDefinitions.userID);
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//
//    @Then("get id from response and delete user details for merchantAdmin {int}")
//    public void getIdFromResponseAndDeleteUserDetailsForMerchantAdmin(int merchantIndex) {
//        userid = createUserStepDefinitions.userID;
//        //  String response1 = commonRestSteps.getResponse().body().asString();
//        Response response = null;
//        String token = null;
//        switch (merchantIndex) {
//            case 1:
//                token = merchantAdmin1Token;
//                break;
//            case 2:
//                token = merchantAdmin2Token;
//                break;
//        }
//        System.out.println("The token use for this scenario is : " + token);
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(token).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).delete("https://52.54.246.176:5001/v1/users/" + userid);
//        Assert.assertEquals(200, response.getStatusCode());
//        response.then().assertThat().body("message", Is.is("User account has been deleted successfully"));
//    }
//
//    @Then("delete second time already deleted user")
//    public void delete_second_time_already_deleted_user() {
//        Response responsedeleted = null;
//        responsedeleted = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2("Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJ3VTNpZklJYUxPVUFSZVJCL0ZHNmVNMVAxUU09IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjMDk2NjQ1Mi1kODYzLTQ4ZDktOWEwZi0yZTdiZTlmMWNlMmYiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiOGRjYTRlMjgtYjI3MS00YTQyLTliMGUtNjlhMTc4YjQ3YWVmLTc5OTIzMDciLCJpc3MiOiJodHRwczovLzMuODMuMTIxLjQyOjEwNDQzL2FtL29hdXRoMi9WZXJpZm9uZVVzZXJzIiwidG9rZW5OYW1lIjoiYWNjZXNzX3Rva2VuIiwidG9rZW5fdHlwZSI6IkJlYXJlciIsImF1dGhHcmFudElkIjoiOC1pQzBZWGhYU1N0Z3ZtcW9EQlhtUnh6d29jIiwiYXVkIjoiZW50aXR5Q2xpZW50IiwibmJmIjoxNjE3MjU4NDY0LCJncmFudF90eXBlIjoiYXV0aG9yaXphdGlvbl9jb2RlIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSJdLCJhdXRoX3RpbWUiOjE2MTcyNTg0NjIsInJlYWxtIjoiL1Zlcmlmb25lVXNlcnMiLCJleHAiOjE2MTcyNjIwNjQsImlhdCI6MTYxNzI1ODQ2NCwiZXhwaXJlc19pbiI6MzYwMCwianRpIjoiOVM3cC1QZ20yRHU3dTJ1YmYzU2FjY0VQSlYwIiwiZW50aXR5X2lkIjoiYmRmNTFiYWItM2QzOS00OTIzLTllMGMtMDcyYmYxOWU3MWJmIiwicm9sZXMiOlsiUEVUUk9fU0lURV9BRE1JTiJdLCJ1c2VyVWlkIjoiYzA5NjY0NTItZDg2My00OGQ5LTlhMGYtMmU3YmU5ZjFjZTJmIn0.p4T4lxr4TswaJN9we44txZYPmSayP3KliV0CUyzT3RC8zwz0FUp6JOHDDZjUAnuFLSNZWUxkpBVroV7i36FSOEf2i4NNhJ6EgV2GEZpf5GyPm9LrZbJXRNCAnJIqMNA67dwqhqDY4wFEN5Y_OvL5rOBuIjmAq10G8JM68_--YMPJWjqmYpWTKnmqoZuUz3jLZNMNMeNZp9JiCrxIHKpgqKVbe9u8o2GFbkHalpcLU495IJgFlEkPyiwKDZhOTPT2QEmBtutk-FAogjkqh8kON_yRofN7VTL5eIWf6ZtfmKKtbe6FguKisdBIXbhInaGVhY-XLNG0K5-iOOU-tQOunQ").
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).delete("https://52.54.246.176:5001/v1/users/" + createUserStepDefinitions.userID);
//        Assert.assertEquals(409, responsedeleted.getStatusCode());
//        responsedeleted.then().assertThat().body("message", Is.is("User account already deleted"));
//    }
//
//
//    @Then("delete second time already deleted user for merchant admin {int}")
//    public void deleteSecondTimeAlreadyDeletedUserForMerchantAdmin(int merchantIndex) {
//        Response responsedeleted = null;
//        String token = null;
//        switch (merchantIndex) {
//            case 1:
//                token = merchantAdmin1Token;
//                break;
//            case 2:
//                token = merchantAdmin2Token;
//                break;
//        }
//        System.out.println("The token use for this scenario is : " + token);
//        responsedeleted = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(token).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).delete("https://52.54.246.176:5001/v1/users/" + createUserStepDefinitions.userID);
//        Assert.assertEquals(409, responsedeleted.getStatusCode());
//        responsedeleted.then().assertThat().body("message", Is.is("User account already deleted"));
//    }
//
//    @And("verify response code and response message")
//    public void verify_response_code_and_response_message() {
//
//        System.out.println("Verified");
//        //Assert.assertEquals(409, responsedeleted.getStatusCode());
//        //responsedeleted.then().assertThat().body("message", Is.is("User account already deleted"));
//    }
//
//    @When("fetch request body from db")
//    public void fetch_request_body_from_db() throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
//        Jsontojava js = new Jsontojava();
//        js.Jsonjava();
//    }
//
//    @Then("get response body")
//    public void getResponseBody() {
//
//        String uri = "https://18.208.137.81:5001";
//        HashMap<String, Object> headers = new HashMap<String, Object>();
//        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGciLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiNDNlNGNjN2EtMzgzNy00YmUzLTgxMzgtNjJhNjg3NzY1ZDMwLTExNjc2NTU0IiwiaXNzIjoiaHR0cHM6Ly8zLjgzLjEyMS40MjoxMDQ0My9hbS9vYXV0aDIvVmVyaWZvbmVVc2VycyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlU2VE1iXzhDYWx1QVlnNWhZel9rLTB6UVdDdyIsImF1ZCI6ImVudGl0eUNsaWVudCIsIm5iZiI6MTU5NzQwMTIwNiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNTk3NDAwMDcxLCJyZWFsbSI6Ii9WZXJpZm9uZVVzZXJzIiwiZXhwIjoxNTk3NDA0ODA2LCJpYXQiOjE1OTc0MDEyMDYsImV4cGlyZXNfaW4iOjM2MDAsImp0aSI6ImRWRHk5cG05M0h0VDEwU2FCeWx2TDZ6TzdFVSIsImVudGl0eV9pZCI6IjFhMDE4ZWIwLWM5NTItNDM0MS1hMzY0LTUxOWM4NGE3NDNkZSIsInJvbGVzIjpbIk1FUkNIQU5UX0FETUlOIl0sInVzZXJVaWQiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGcifQ.9maksYbw6tuSVFELaRrX6YZ7oX2gh9ZeCFmRJMk2ylQ");
//        headers.put("Content-Type", "application/json");
//        headers.put("Accept", "*/*");
//        ResponseBody responseBody = new ResponseBody();
//        responseBody.getWithHeaders(headers, uri, "/v1/hierarchy/");
//
//    }
//
//    @Then("get response body for Merchant {int}")
//    public void getResponseBodyForMerchant(int merchantIndex) {
//        String token = null;
//        switch (merchantIndex) {
//            case 1:
//                token = merchantAdmin1Token;
//                break;
//            case 2:
//                token = merchantAdmin2Token;
//                break;
//        }
//        System.out.println("The token use for this scenario is : " + token);
//        String uri = "https://52.54.246.176:5001";
//        HashMap<String, Object> headers = new HashMap<String, Object>();
//        headers.put("Authorization", token);
//        headers.put("Content-Type", "application/json");
//        headers.put("Accept", "*/*");
//        ResponseBody responseBody = new ResponseBody();
//        responseBody.getWithHeaders(headers, uri, "/v1/hierarchy/");
////        String uriMethod2 = "https://52.54.246.176:5001/v1/hierarchy/";
////        responseBody.getWithHeadersMethod2(token, uriMethod2);
//    }
//
//    @Then("get response body for Merchant {int} use utility method")
//    public void getResponseBodyForMerchantUseUtilityMethod(int merchantIndex) {
//        String token = null;
//        TestUtil tul = new TestUtil();
//        token = tul.selectTokenByIndex(merchantIndex);
////        switch(merchantIndex){
////            case 1:
////                token=merchantAdmin1Token;
////                break;
////            case 2:
////                token=merchantAdmin2Token;
////                break;
////        }
////        System.out.println("The token use for this scenario is : "+token);
//
//        String uri = "https://52.54.246.176:5001";
//        HashMap<String, Object> headers = new HashMap<String, Object>();
//        headers.put("Authorization", token);
//        headers.put("Content-Type", "application/json");
//        headers.put("Accept", "*/*");
//        getResponseBodyVeri responseBody = new getResponseBodyVeri();
//        responseBody.getWithHeaders(headers, uri, "/v1/hierarchy/");
//    }
//
//
//    @Then("get id from response and verify perimissions for created role id")
//    public void get_id_from_response_and_verify_perimissions_for_created_role_id() throws IOException {
//
//        roleuserid = deleteRole.roleID;
//        //String response1 = commonRestSteps.getResponse().body().asString();
//        Response response2 = null;
//        response2 = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2("Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJ3VTNpZklJYUxPVUFSZVJCL0ZHNmVNMVAxUU09IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJjMDk2NjQ1Mi1kODYzLTQ4ZDktOWEwZi0yZTdiZTlmMWNlMmYiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiOGRjYTRlMjgtYjI3MS00YTQyLTliMGUtNjlhMTc4YjQ3YWVmLTc5OTIzMDciLCJpc3MiOiJodHRwczovLzMuODMuMTIxLjQyOjEwNDQzL2FtL29hdXRoMi9WZXJpZm9uZVVzZXJzIiwidG9rZW5OYW1lIjoiYWNjZXNzX3Rva2VuIiwidG9rZW5fdHlwZSI6IkJlYXJlciIsImF1dGhHcmFudElkIjoiOC1pQzBZWGhYU1N0Z3ZtcW9EQlhtUnh6d29jIiwiYXVkIjoiZW50aXR5Q2xpZW50IiwibmJmIjoxNjE3MjU4NDY0LCJncmFudF90eXBlIjoiYXV0aG9yaXphdGlvbl9jb2RlIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSJdLCJhdXRoX3RpbWUiOjE2MTcyNTg0NjIsInJlYWxtIjoiL1Zlcmlmb25lVXNlcnMiLCJleHAiOjE2MTcyNjIwNjQsImlhdCI6MTYxNzI1ODQ2NCwiZXhwaXJlc19pbiI6MzYwMCwianRpIjoiOVM3cC1QZ20yRHU3dTJ1YmYzU2FjY0VQSlYwIiwiZW50aXR5X2lkIjoiYmRmNTFiYWItM2QzOS00OTIzLTllMGMtMDcyYmYxOWU3MWJmIiwicm9sZXMiOlsiUEVUUk9fU0lURV9BRE1JTiJdLCJ1c2VyVWlkIjoiYzA5NjY0NTItZDg2My00OGQ5LTlhMGYtMmU3YmU5ZjFjZTJmIn0.p4T4lxr4TswaJN9we44txZYPmSayP3KliV0CUyzT3RC8zwz0FUp6JOHDDZjUAnuFLSNZWUxkpBVroV7i36FSOEf2i4NNhJ6EgV2GEZpf5GyPm9LrZbJXRNCAnJIqMNA67dwqhqDY4wFEN5Y_OvL5rOBuIjmAq10G8JM68_--YMPJWjqmYpWTKnmqoZuUz3jLZNMNMeNZp9JiCrxIHKpgqKVbe9u8o2GFbkHalpcLU495IJgFlEkPyiwKDZhOTPT2QEmBtutk-FAogjkqh8kON_yRofN7VTL5eIWf6ZtfmKKtbe6FguKisdBIXbhInaGVhY-XLNG0K5-iOOU-tQOunQ").
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get("https://52.54.246.176:5001/v1/roles/" + roleuserid + "/permissions");
//
//        Assert.assertEquals(200, response2.getStatusCode());
//        PermissionDetails response = JsonUtility.deserialize(response2.asString(), PermissionDetails.class);
//        List<Long> ids = new ArrayList<>();
//        PermissionResponse.getIdsOfCheckedPermissions(response.getPermissions(), ids);
//
//        Response responseComparison = null;
//        responseComparison = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2("Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJ3VTNpZklJYUxPVUFSZVJCL0ZHNmVNMVAxUU09IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGYiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiNDNlNGNjN2EtMzgzNy00YmUzLTgxMzgtNjJhNjg3NzY1ZDMwLTExNjc2NTU0IiwiaXNzIjoiaHR0cHM6Ly8zLjgzLjEyMS40MjoxMDQ0My9hbS9vYXV0aDIvVmVyaWZvbmVVc2VycyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlU2VE1iXzhDYWx1QVlnNWhZel9rLTB6UVdDdyIsImF1ZCI6ImVudGl0eUNsaWVudCIsIm5iZiI6MTU5NzQwMTIwNiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNTk3NDAwMDcxLCJyZWFsbSI6Ii9WZXJpZm9uZVVzZXJzIiwiZXhwIjoxNTk3NDA0ODA2LCJpYXQiOjE1OTc0MDEyMDYsImV4cGlyZXNfaW4iOjM2MDAsImp0aSI6ImRWRHk5cG05M0h0VDEwU2FCeWx2TDZ6TzdFVSIsImVudGl0eV9pZCI6IjMzZGQ5ZjJjLWVlZmQtNDU1YS1hYmVkLTM3MDY3ZTc4ODk1YiIsInJvbGVzIjpbIk1FUkNIQU5UX0FETUlOIl0sInVzZXJVaWQiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGYifQ.z76-2H4hFccQoo2nImO2W5xdEb5j3bgjEH2KqlPS4NYwLqNeN6ao-QTneA2X3jczNf542ZStZpN-3UMAv2XjmKd7a61Us-gobF8xsVqjjQqXDkQQF84jZagANmwrYYtl0Q2k9poE-jktzz3Hx_FIkab3h_FjwQF7_e1beXjq5iF6hCCWZuueQTmf_LkRpog4A_pYTu23_fASFsW9nqF9_j9FxjEPhCsXH4OAaco7ZR9uAmYEnMlHC_TgYOzX9ky7L1hFZfCXZqC-h4TpEZtBrNWmBQdQB8r-dbZv9IWhSAqUkDL5EtW_dxfMSEmMrl3_0dGkc_VeejrUx4mnd6Vo6A").
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get("https://52.54.246.176:5001/v1/roles/" + roleuserid + "/permissions?compare_with_current_user=true");
//        Assert.assertEquals(200, responseComparison.getStatusCode());
//
//        PermissionDetails responseActual = JsonUtility.deserialize(responseComparison.asString(), PermissionDetails.class);
//        List<Long> ids1 = new ArrayList<>();
//        PermissionResponse.getIdsOfCheckedPermissions(responseActual.getPermissions(), ids1);
//        Assert.assertEquals(ids1.size(), ids.size());
//
//        for (Long mappingId : ids) {
//            Assert.assertTrue(ids1.contains(mappingId));
//        }
//
//    }
//
//
//    @When("get token from config file")
//    public void getTokenFromConfigFile() {
//        token = prop.getProperty("merchantAdmin1Token");
//        System.out.println("The token is : " + token);
//    }
//
//    @When("get {string} token from config file")
//    public String getTokenFromConfigFile(String tokenName) {
//        switch (tokenName) {
//            case "VFIhelpDeskToken":
//                VFIhelpDeskToken = prop.getProperty(tokenName);
//                TestToken = VFIhelpDeskToken;
//                break;
//            case "merchantQatAdmin1":
//                merchantQatAdmin1 = prop.getProperty(tokenName);
//                TestToken = merchantQatAdmin1;
//                break;
//            case "merchantAdmin1Token":
//                merchantAdmin1Token = prop.getProperty(tokenName);
//                TestToken = merchantAdmin1Token;
//                break;
//            case "merchantAdmin2Token":
//                merchantAdmin2Token = prop.getProperty(tokenName);
//                TestToken = merchantAdmin2Token;
//                break;
//            case "merchantAdmin3Token":
//                merchantAdmin3Token = prop.getProperty(tokenName);
//                TestToken = merchantAdmin3Token;
//                break;
//            case "SiteAssetToken":
//                SiteAssetToken = prop.getProperty(tokenName);
//                TestToken = SiteAssetToken;
//                break;
//        }
//        System.out.println("The token is : " + TestToken);
//        return TestToken;
//    }
//
    @When("get {string} token from config file for merchantAdmin one")
    public void getTokenFromConfigFileForMerchantAdminOne(String tokenName) {
        merchantAdmin1Token = prop.getProperty(tokenName);
        System.out.println("The token is : " + merchantAdmin1Token);
    }

    @When("get siteAssets {string} type {string} {int} uri relateive path {string} testName {string}")
    public void getSiteAssetsTypeUriRelateivePathTestName(String arg0, String accountType, int index, String uriPath, String testName) {
        //  https://52.54.246.176:5004/v1/assets?limit=10&device_paginate=true
        String url = baseUrl + uriPath;
        System.out.println(url);
        TestUtil tul = new TestUtil();
        APIresponse = tul.getTypesOfGetResponseToFilePath(accountType, index, "src/test/testresult", testName, url);
    }

    @Then("verify the response contains {string}")
    public void verifyTheResponseContains(String message) {
        Assert.assertTrue(APIresponse.contains(message));
    }

//
//    @When("get {string} token from config file for merchantAdmin {int}")
//    public void getTokenFromConfigFileForMerchantAdmin(String tokenName, int merchantIndex) {
//        switch (merchantIndex) {
//            case 1:
//                merchantAdmin1Token = prop.getProperty(tokenName);
//                break;
//            case 2:
//                merchantAdmin2Token = prop.getProperty(tokenName);
//                break;
//            case 3:
//                merchantAdmin3Token = prop.getProperty(tokenName);
//                break;
//        }
//    }
//
//    @When("get {string} token from config file for merchantAdmin two")
//    public void getTokenFromConfigFileForMerchantAdminTwo(String tokenName) {
//        merchantAdmin2Token = prop.getProperty(tokenName);
//        System.out.println("The token is : " + merchantAdmin2Token);
//    }
//
//    @When("get {string} token from config file for merchantAdmin Three")
//    public void getTokenFromConfigFileForMerchantAdminThree(String tokenName) {
//        merchantAdmin3Token = prop.getProperty(tokenName);
//        System.out.println("The token is : " + merchantAdmin2Token);
//    }
//
//    @When("get {string} token from config file for Major-Branded oil one")
//    public void getTokenFromConfigFileForMajorBrandedOilOne(String tokenName) {
//        majorOilAdmin1Token = prop.getProperty(tokenName);
//        System.out.println("The token is : " + majorOilAdmin1Token);
//    }
//
//    @When("get {string} token from config file for Major-Branded oil Two")
//    public void getTokenFromConfigFileForMajorBrandedOilTwo(String tokenName) {
//        majorOilAdmin2Token = prop.getProperty(tokenName);
//        System.out.println("The token is : " + majorOilAdmin2Token);
//    }
//
//    @When("get {string} token from config file for Major-Branded oil Three or Sub user")
//    public void getTokenFromConfigFileForMajorBrandedOilThreeOrSubUser(String tokenName) {
//        majorOilAdminSubToken = prop.getProperty(tokenName);
//        System.out.println("The token is : " + majorOilAdminSubToken);
//    }
//
//
//    @When("get {string} token from config file for merchantSub one")
//    public void getTokenFromConfigFileForMerchantSubOne(String tokenName) {
//        merchantSubToken = prop.getProperty(tokenName);
//        System.out.println("The token is : " + merchantSubToken);
//    }
//
//    @When("get {string} permission")
//    public void getPermission(String arg0) {
//        Response responsE = null;
//        String url = "https://52.54.246.176:5001/v1/permissions/lite";
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(VFIhelpDeskToken).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get(url);
//        System.out.println("The response is: " + response.getBody().asString());
//        TestUtil tul = new TestUtil();
//        tul.Jsonstr2FileVeri(response.asString(), "src/test/resources/request-verify/permsionResponse1.json");
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//    @When("get {string} permission for merchantAdmin one")
//    public void getPermissionForMerchantAdminOne(String arg0) {
//        Response responsE = null;
//        String url = "https://52.54.246.176:5001/v1/permissions/lite";
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(merchantAdmin1Token).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get(url);
//        System.out.println("The response is: " + response.getBody().asString());
//        TestUtil tul = new TestUtil();
//        tul.Jsonstr2FileVeri(response.asString(), "src/test/resources/request-verify/MerchantpermsionResponse1.json");
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//    @When("get {string} permission for majorOilAdmin one")
//    public void getPermissionForMajorOilAdminOne(String arg0) {
//        Response responsE = null;
//        String url = "https://52.54.246.176:5001/v1/permissions/lite";
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(majorOilAdmin1Token).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get(url);
//        System.out.println("The response is: " + response.getBody().asString());
//        TestUtil tul = new TestUtil();
//        tul.Jsonstr2FileVeri(response.asString(), "src/test/resources/request-verify/majorOilpermsionResponse1.json");
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//
//    @When("get {string} permission for merchantSub one")
//    public void getPermissionForMerchantSubOne(String arg0) {
//        Response responsE = null;
//        String url = "https://52.54.246.176:5001/v1/permissions/lite";
//        response = RestAssured.
//                given().
//                auth().
//                preemptive().
//                oauth2(merchantSubToken).
//                header("Accept", ContentType.JSON.getAcceptHeader())
//                .contentType(ContentType.JSON).get(url);
//        System.out.println("The response is: " + response.getBody().asString());
//        TestUtil tul = new TestUtil();
//        tul.Jsonstr2FileVeri(response.asString(), "src/test/resources/request-verify/merchantSubResponse1.json");
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//    @Then("analyze the response and get the permissions")
//    public void analyzeTheResponseAndGetThePermissions() {
//        CallPermissionRespJson csrj = new CallPermissionRespJson();
//        String path = "src/test/resources/request-verify/permsionResponse1.json";
//        permissionMap = analyzePermissionRespMap(path);
//    }
//
//    @Then("analyze the merchant one response and get the permissions")
//    public void analyzeTheMerchantOneResponseAndGetThePermissions() {
//        CallPermissionRespJson csrj = new CallPermissionRespJson();
//        String path = "src/test/resources/request-verify/MerchantpermsionResponse1.json";
//        permissionMap = analyzePermissionRespMap(path);
//    }
//
//    @Then("analyze the majorOil one response and get the permissions")
//    public void analyzeTheMajorOilOneResponseAndGetThePermissions() {
//        CallPermissionRespJson csrj = new CallPermissionRespJson();
//        String path = "src/test/resources/request-verify/majorOilpermsionResponse1.json";
//        permissionMap = analyzePermissionRespMap(path);
//    }
//
//    @Then("analyze the merchantSub one response and get the permissions")
//    public void analyzeTheMerchantSubOneResponseAndGetThePermissions() {
//        CallPermissionRespJson csrj = new CallPermissionRespJson();
//        String path = "src/test/resources/request-verify/merchantSubResponse1.json";
//        permissionMap = analyzePermissionRespMap(path);
//    }
//
//    @Then("verify {string} in permission contain {string}")
//    public void verifyInPermissionContain(String key, String value) {
//        String val = permissionMap.get(key);
//        System.out.println("The value " + key + " is : " + val);
//        Assert.assertTrue(val.contains(value));
//    }

}
