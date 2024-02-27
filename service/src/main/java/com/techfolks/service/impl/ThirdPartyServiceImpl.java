package com.techfolks.service.impl;

import com.techfolks.model.dto.Api;
import com.techfolks.model.dto.ThirdPartyReqRes;
import com.techfolks.repository.ApiRepository;
import com.techfolks.repository.ThirdPartyReqResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyServiceImpl implements com.techfolks.service.impl.ThirdPartyReqRes {

    @Autowired
    private ThirdPartyReqResRepository thirdPartyReqResRepository;

    @Autowired
    private ApiRepository apiRepository;

    public void saveThirdPartyReqRes(String apiName, String request, String response) {
        Api existingApi = apiRepository.findByApi(apiName);

        if (existingApi == null) {
            existingApi = new Api();
            existingApi.setApi(apiName);
            apiRepository.save(existingApi);
        }
        ThirdPartyReqRes thirdPartyReqRes = new ThirdPartyReqRes();
        thirdPartyReqRes.setRequest(request);
        thirdPartyReqRes.setResponse(response);
        thirdPartyReqRes.setApi(existingApi);
        thirdPartyReqResRepository.save(thirdPartyReqRes);
    }
}
