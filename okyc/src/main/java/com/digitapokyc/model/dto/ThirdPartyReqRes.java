package com.digitapokyc.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "third_party_req_resp")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyReqRes {
	@Id
    @GeneratedValue(strategy 
                    = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "request")
    private String request;
    @OneToOne
    @JoinColumn(name="api", foreignKey = @ForeignKey(name = "api_foreign_key_api_id"), referencedColumnName = "id")
    private Api api;
    @Column(name = "response")
    private String response;
}
