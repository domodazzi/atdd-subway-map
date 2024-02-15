package subway;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredTest extends AcceptanceTest {

    @DisplayName("구글 페이지 접근 테스트")
    @Test
    void accessGoogle() {
        ExtractableResponse<Response> response = RestAssured
            .given()
            .port(443)
            .when().get("https://www.google.com")
            .then().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}