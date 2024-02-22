package com.techfolks.repository;

import com.techfolks.model.dto.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {
    @Query(value = "SELECT * FROM api WHERE api = :apiName", nativeQuery = true)
    Api findByApi(@Param("apiName") String api);
}
