package com.techfolks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/rest")
public class HelloRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
    	
        String url = "https://svcdemo.digitap.work/ent/v3/kyc/intiate-kyc-auto";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization","NDE0ODc1MTU6WVVvTFJYaHVjSEg2ZEtYQ3FpOEVtaGFxdDZkZ0FMdks=");

        InitiateKycRequest initiateKycRequest = new InitiateKycRequest();
        initiateKycRequest.setUniqueId("1234567");
        initiateKycRequest.setUid("771802087896");

        HttpEntity<InitiateKycRequest> requestHttpEntity = new HttpEntity<>(initiateKycRequest, httpHeaders);
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, requestHttpEntity, String.class);

        String ijk = responseEntity.getBody();
        ObjectMapper obj = new ObjectMapper();
        obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        InitiateKycResponse abc = new InitiateKycResponse();
        try {
			abc = obj.readValue(ijk, InitiateKycResponse.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "hello world";
    }
    
}
