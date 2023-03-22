package com.nomad.k8example.gateway.repository;

import com.nomad.k8example.gateway.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
}
