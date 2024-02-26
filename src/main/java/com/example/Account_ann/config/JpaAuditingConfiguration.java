package com.example.Account_ann.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // Spring application 이 실행할 때 자동 등록 bean
@EnableJpaAuditing
public class JpaAuditingConfiguration {
}
