package com.gintaras.seb;

import com.gintaras.seb.model.Product;
import com.gintaras.seb.model.Questionnaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.gintaras.seb.UtilsKt.AGE_0_17;
import static com.gintaras.seb.UtilsKt.PRODUCT_JUNIOR_SAVER_ACCOUNT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Tests rest endpoint.
 *
 * @created 04/08/2020 - 14:03
 * @author gintaras
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebHttpTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnJsonObject() throws Exception {
        Questionnaire questionnaire = new Questionnaire(AGE_0_17, null, null);
        List<Product> result = given().contentType("application/json")
                .with().body(questionnaire)
                .when().post("http://localhost:" + port + "/post")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(List.class);
        assertThat(result.toString()).contains(PRODUCT_JUNIOR_SAVER_ACCOUNT);;

    }
}
