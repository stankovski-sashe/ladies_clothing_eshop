package com.ladywears.emtproekt.repository;

import com.ladywears.emtproekt.model.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MarkaRepository extends JpaRepository<Marka, Long> {

    @Transactional
    Integer removeById(Long id);
//     boolean removeById(Long id);
}
