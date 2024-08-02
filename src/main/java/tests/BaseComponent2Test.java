package tests;

import io.restassured.response.Response;
import utils.BaseComponent2;

public class BaseComponent2Test extends BaseComponent2 {

    public void postTodoWithAuth() {

        Response response = doPostRequest("{\n"
                        + "    \"title\":\"Microsoft\",\n"
                        + "    \"body\": \"testCeva\"\n"
                        + "}",
                "save");

        }


    }

