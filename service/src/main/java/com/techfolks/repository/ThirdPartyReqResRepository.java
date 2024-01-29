package com.techfolks.repository;


import com.techfolks.model.dto.ThirdPartyReqRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyReqResRepository extends JpaRepository<ThirdPartyReqRes, Long> {
}
