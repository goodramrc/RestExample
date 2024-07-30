package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import testdata.DataBuilder;
import utils.BaseComponent;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaValidationExample extends BaseComponent {

    @Test
    public void testReponseSchema() {

        Response resp = doPostRequest(DataBuilder.buildUser().toJSONString(), "api/users", 201);
        assertThat(resp.asString(), matchesJsonSchemaInClasspath("schema.json"));
    }

}
