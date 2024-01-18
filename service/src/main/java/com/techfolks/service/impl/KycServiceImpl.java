package com.techfolks.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techfolks.model.request.InitiateKycAuto;
import com.techfolks.model.request.ReSendOtp;
import com.techfolks.model.request.SubmitOtp;
import com.techfolks.model.response.InitiateKycAutoResponse;
import com.techfolks.model.response.ReSendOtpResponse;
import com.techfolks.model.response.SubmitOtpResponse;
import com.techfolks.repository.ThirdPartyReqResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;
import java.util.Base64;

@Service
public class KycServiceImpl implements KycService {

    @Autowired
    private ThirdPartyReqResRepository thirdPartyReqResRepository;

    @Autowired
    private RestTemplate restTemplate;


    private String clientID = "41487515";
    private String clientSecret = "YUoLRXhucHH6dKXCqi8Emhaqt6dgALvK";
    private String apiUrl = "https://svcdemo.digitap.work/ent/v3/kyc/";

    @Override
    public InitiateKycAutoResponse initiateAutoKycFunc(InitiateKycAuto initiateAutoKyc) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = new ObjectMapper().writeValueAsString(initiateAutoKyc);
        ResponseEntity<String> result = restPostAPICall(apiUrl + "intiate-kyc-auto", jsonString);
        String responseBody = result.getBody();
        InitiateKycAutoResponse jsonObject = new ObjectMapper().readValue(responseBody, InitiateKycAutoResponse.class);
        return jsonObject;
    }

    public ResponseEntity<String> restPostAPICall(String url, String data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String originalString = clientID + ":" + clientSecret;
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        headers.set(HttpHeaders.AUTHORIZATION, encodedString);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return responseEntity;
    }

    @Override
    public SubmitOtpResponse submitOtp(SubmitOtp submitOtp) {

        String url = "https://svcdemo.digitap.work/ent/v3/kyc/submit-otp";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "NDE0ODc1MTU6WVVvTFJYaHVjSEg2ZEtYQ3FpOEVtaGFxdDZkZ0FMdks=");

        SubmitOtp submitOtpRequest = new SubmitOtp();
        submitOtpRequest.setOtp(submitOtp.getOtp());
        submitOtpRequest.setTransactionId(submitOtp.getTransactionId());
        submitOtpRequest.setCodeVerifier(submitOtp.getCodeVerifier());
        submitOtpRequest.setShareCode(submitOtp.getShareCode());
        submitOtpRequest.setFwdp(submitOtp.getFwdp());
        submitOtpRequest.setValidateXml(submitOtp.getValidateXml());

        HttpEntity<SubmitOtp> requestHttpEntity = new HttpEntity<>(submitOtpRequest, httpHeaders);
        ResponseEntity<SubmitOtpResponse> responseEntity =
                restTemplate.postForEntity(url, requestHttpEntity, SubmitOtpResponse.class);

        SubmitOtpResponse response = responseEntity.getBody();
        ObjectMapper obj = new ObjectMapper();
        obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SubmitOtpResponse otpResponse = new SubmitOtpResponse();
        try {
            otpResponse = obj.readValue((DataInput) response, SubmitOtpResponse.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @Override
    public ReSendOtpResponse resendOtp(ReSendOtp reSendOtp) {
        String url = "https://svcdemo.digitap.work/ent/v3/kyc/resend-otp";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "NDE0ODc1MTU6WVVvTFJYaHVjSEg2ZEtYQ3FpOEVtaGFxdDZkZ0FMdks=");

        ReSendOtp reSendOtpRequest = new ReSendOtp();
        reSendOtpRequest.setUniqueId(reSendOtp.getUniqueId());
        reSendOtpRequest.setUid(reSendOtp.getUid());
        reSendOtpRequest.setFwdp(reSendOtp.getFwdp());
        reSendOtpRequest.setTransactionId(reSendOtp.transactionId);

        HttpEntity<ReSendOtp> requestHttpEntity = new HttpEntity<>(reSendOtpRequest, httpHeaders);
        ResponseEntity<ReSendOtpResponse> responseEntity =
                restTemplate.postForEntity(url, requestHttpEntity, ReSendOtpResponse.class);

        ReSendOtpResponse response = responseEntity.getBody();
        ObjectMapper obj = new ObjectMapper();
        obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SubmitOtpResponse otpResponse = new SubmitOtpResponse();
        try {
            otpResponse = obj.readValue((DataInput) response, SubmitOtpResponse.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }


}
