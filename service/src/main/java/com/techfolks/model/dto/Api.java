package com.techfolks.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "api")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "api")
    private String api;

    @OneToMany(mappedBy = "api", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ThirdPartyReqRes> thirdPartyReqResList;

    public Api() {
    }

    public Api(Integer id, String api, List<ThirdPartyReqRes> thirdPartyReqResList) {
        this.id = id;
        this.api = api;
        this.thirdPartyReqResList = thirdPartyReqResList;
    }

    public List<ThirdPartyReqRes> getThirdPartyReqResList() {
        return thirdPartyReqResList;
    }

    public void setThirdPartyReqResList(List<ThirdPartyReqRes> thirdPartyReqResList) {
        this.thirdPartyReqResList = thirdPartyReqResList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
