package util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by byang on 91/22/2016.
 */

public class ResponseBody {
    static RequestSpecification httpRequest;
    static Response response;

    public static Response getWithHeadersMethod(String token, String puri) {
        Response response = null;
        response = RestAssured.
                given().
                auth().
                preemptive().
                oauth2(token).
                header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON).get(puri);
//        System.out.println("The response is: " + response.getBody().asString());
        Assert.assertEquals(200, response.getStatusCode());
        return response;
    }
    public static Response  getWithHeaders(Map head, String puri, String path)  {
            RestAssured.baseURI = puri;
        httpRequest = RestAssured.given();

        System.out.println("The header is:  "+head);
        Iterator var = ((Set)head.keySet().stream().collect(Collectors.toSet())).iterator();
        while(var.hasNext()) {
            String headerKey = (String)var.next();
            httpRequest.header(headerKey, head.get(headerKey));
        }
        response = httpRequest.request(Method.GET, path);
//        System.out.println("The getWithHeaders reponse is:  "+response.getBody().asString());
        Assert.assertEquals(200, response.getStatusCode());
        return response;
}
}
