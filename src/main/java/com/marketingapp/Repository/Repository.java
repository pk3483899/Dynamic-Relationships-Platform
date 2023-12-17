package com.marketingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entity.Registration;

public interface Repository extends JpaRepository<Registration, Long> {

}
