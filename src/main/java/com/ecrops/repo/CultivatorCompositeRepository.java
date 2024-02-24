package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecrops.dto.CultivatorDto;
import com.ecrops.dto.CultivatorEmbedableDto;

@Repository
public interface CultivatorCompositeRepository extends JpaRepository<CultivatorDto, CultivatorEmbedableDto> {

}
