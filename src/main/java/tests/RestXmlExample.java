package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestXmlExample {

    @Test
    public void testXMLResponse() {

        Response resp = given().get("https://run.mocky.io/v3/a6271be8-f3cb-4eda-ac09-4365c971b224").then().extract().response();

        System.out.println(resp.asString());

        System.out.println(resp.xmlPath().getList("catalog"));
        System.out.println(resp.xmlPath().getList("catalog.book[0]"));
        System.out.println(resp.xmlPath().getList("catalog.book.size()"));

        System.out.println("----------------------------------");

        System.out.println(resp.xmlPath().getString("catalog.book[2].author"));
        System.out.println(resp.xmlPath().getString("catalog.book[1].author"));

        System.out.println(resp.xmlPath().getString("catalog.book[1].genre"));

        System.out.println("----------------------------------");

        System.out.println(resp.xmlPath().getList("catalog.book.@id"));
        System.out.println(resp.xmlPath().getList("catalog.book[0].@id"));
        System.out.println(resp.xmlPath().getList("catalog.book[0].@id"));

        System.out.println("----------------------------------");

        System.out.println(resp.xmlPath().getList("catalog.book.findAll{it.genre=='Fantasy'}"));
        System.out.println(resp.xmlPath().getList("catalog.book.findAll{it.genre=='Fantasy' | it.genre=='Romance'}"));
        System.out.println(resp.xmlPath().getList("catalog.book.findAll{it.genre=='Fantasy' & it.genre=='Math'}"));


        System.out.println(resp.xmlPath().getString("catalog.book.find{it.@=='bk109'}.author"));

    }
}
