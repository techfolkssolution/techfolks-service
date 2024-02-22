package com.techfolks.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "third_party_req_resp")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyReqRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "request")
    private String request;

    @OneToOne
    @JoinColumn(name = "api", foreignKey = @ForeignKey(name = "api_foreign_key_api_id"), referencedColumnName = "id")
    private Api api;

    @Column(name = "response")
    private String response;

    public ThirdPartyReqRes() {
    }

    public ThirdPartyReqRes(Integer id, String request, Api api, String response) {
        this.id = id;
        this.request = request;
        this.api = api;
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


}
