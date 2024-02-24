package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecrops.entity.Master;

public interface MasterRepo extends JpaRepository<Master, Integer>{
@Query(value="select distinct(wbedname),wbemname,user_registration.userid from user_registration inner join wbvillage_mst on wbvillage_mst.wbdcode=? and wbvillage_mst.wbmcode=? and user_registration.type_user='?' where  wbvillage_mst.wbdcode=user_registration.wbdcode and wbvillage_mst.wbmcode=user_registration.wbmcode", nativeQuery = true)
			List<Master> findAll(String wbeDname,String wbeMname);
}
