package api.example.temp;

import api.example.model.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import  org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
public class SerializeTest {
    private static final Logger LOG = LoggerFactory.getLogger(SerializeTest.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private String id;
    @Test
    public void serializationTest() throws IOException {
        // creating `User` object
        User student = new User("Inessa", "QA");
        // converting `User` object to JSON string using `ObjectMapper`
        byte[] data = MAPPER.writeValueAsBytes(student);
        String json = MAPPER.writeValueAsString(student);

        LOG.info("serialization of `User` class into JSON string using `ObjectMapper` => {}", new String(data));
        LOG.info("serialization of `User` class into JSON string using `ObjectMapper` => {}", json);
        // using `User` object in body of `CreateUser` API
        String url = "https://reqres.in/api/users";
        Response response = RestAssured.given()
                .contentType("application/json")
                .log().all(true)
                .accept("application/json")
                .body(student)
                .post(url)
                .andReturn();
        // validating the HTTP status code
        Assert.assertEquals(response.getStatusCode(), 201, "http status");
        // saving the `id` of the created `User` to delete the same in cleanup method
        id = response.path("id");
        // validating whether the created `User` id not null
        Assert.assertNotNull(id, "created user id is null");
        System.out.println("Created user id="+ id);
        LOG.info("Created user id => {}", id);
    }

    @AfterMethod
    public void deleteUser() {
        if (id != null) {
            String url = "https://reqres.in/api/users/{id}";
            Response response = RestAssured.given()
                    .contentType("application/json")
                    .accept("application/json")
                    .pathParam("id", id)
                    .delete(url);
            Assert.assertEquals(response.getStatusCode(), 204, "http status");
        }
    }

}

