package com.mycompany.myapp.repository;
import com.mycompany.myapp.domain.STIRCase;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the STIRCase entity.
 */
@SuppressWarnings("unused")
@Repository
public interface STIRCaseRepository extends JpaRepository<STIRCase, Long> {

}
