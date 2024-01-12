package com.digitapokyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitapokyc.model.dto.Api;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
}
