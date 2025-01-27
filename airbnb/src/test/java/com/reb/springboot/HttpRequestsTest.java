package com.reb.springboot;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestsTest {

	@LocalServerPort
	private int port;

    @Autowired()
    private TestRestTemplate restTemplate;

    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<String> result = this.restTemplate.withBasicAuth("rem", "cracky").getForEntity("/api/photo", String.class);
        
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

	/*@Test
    public void playersMe() throws Exception 
    {
		ResponseEntity<String> result = this.restTemplate.withBasicAuth("remi", "cracky").getForEntity("/api/photos",String.class);
		assertThat(result.getBody()).isEqualTo("test");
	}*/
}