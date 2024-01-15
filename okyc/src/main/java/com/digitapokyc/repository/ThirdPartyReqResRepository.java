package com.digitapokyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitapokyc.model.dto.ThirdPartyReqRes;

@Repository
public interface ThirdPartyReqResRepository extends JpaRepository<ThirdPartyReqRes, Long> {
}
