package com.nighthawk.spring_portfolio.mvc.jobAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
