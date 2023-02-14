package com.swaggerwith.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaggerwith.spring.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
