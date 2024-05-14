package com.weavus.creditweb.repo;

import com.weavus.creditweb.dto.CreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditInfoRepo extends JpaRepository<CreditInfo, String> {
}
