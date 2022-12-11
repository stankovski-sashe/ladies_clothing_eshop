package com.ladywears.emtproekt.repository;

import com.ladywears.emtproekt.model.Ladywear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LadywearRepository extends JpaRepository<Ladywear, Long> {
    //boolean existsByManufacturerId(Long manufacturerId);
}
