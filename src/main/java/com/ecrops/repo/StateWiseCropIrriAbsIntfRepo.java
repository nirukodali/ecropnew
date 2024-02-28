package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.StateWiseCropIrriAbsIntf;

public interface StateWiseCropIrriAbsIntfRepo  extends JpaRepository<StateWiseCropIrriAbsIntf, Integer>{
	
	
   //vill//        
            @Query(value= " select sum(totextent) as totext,cr_vcode from ecrop2023.rep_vill_wise_irrgcropwise_ext_v "
            		+ " where mcode=:mcode  and grpcode=:grpcode   "
                     + "and wsrcid=:wsrcid and cr_year=:cr_year and cr_season=:cr_season "
                     + "group by cr_vcode order by cr_vcode",nativeQuery=true)
            List<StateWiseCropIrriAbsIntf> getWsrcVill(@Param("mcode")Integer mcode,
            		                                   @Param("grpcode") Integer grpcode,
            		                                   @Param("wsrcid") Integer wsrcid,
            		                                   @Param("cr_year") Integer cr_year,
            		                                   @Param("cr_season") String cr_season);
        
             @Query(value=" select sum(totextent) as totext, cr_vcode from ecrop2023.rep_vill_wise_irrgcropwise_ext_v  "
             		+ "where mcode=:mcode  and grpcode=:grpcode "
                     + " and cr_crop =:cr_crop and wsrcid=:wsrcid and cr_year=:cr_year and cr_season=:cr_season"
                     + " group by cr_vcode order by cr_vcode",nativeQuery=true)
            List<StateWiseCropIrriAbsIntf> getWsrcVill1(@Param("mcode")Integer mcode,
                                                        @Param("grpcode") Integer grpcode,
                                                        @Param("cr_crop") Integer cr_crop,
                                                        @Param("wsrcid") Integer wsrcid,
                                                        @Param("cr_year") Integer cr_year,
                                                        @Param("cr_season") String cr_season);
 //dist// 
             
             @Query(value=" select dcode,dname,sum(totextent) as totext from ecrop2023.rep_dist_wise_irrigwise_ext_v "
             		+ "where dcode=:dcode  and grpcode=:grpcode  and wsrcid=:wsrcid "
                     + "and cr_year=:cr_year and cr_season=:cr_season group by "
                     + "dcode,dname order by dname,mname ",nativeQuery=true) 
             List<StateWiseCropIrriAbsIntf> getWsrcDist(@Param("dcode")Integer dcode,
                                                        @Param("grpcode") Integer grpcode,
                                                        @Param("wsrcid") Integer wsrcid,
                                                        @Param("cr_year") Integer cr_year,
                                                        @Param("cr_season") String cr_season);
             @Query(value= " select dcode,dname,sum(totextent) as totext from ecrop2023.rep_dist_wise_irrigwise_ext_v  "
             		+ "where dcode=:dcode and grpcode=:grpcode  and cr_crop=:cr_crop "
                     + "and wsrcid=:wsrcid  and cr_year=:cr_year and cr_season=:cr_season"
                     + " group by dcode,dname",nativeQuery=true)
            
             List<StateWiseCropIrriAbsIntf> getWsrcDist1(@Param("dcode")Integer dcode,
                                                         @Param("grpcode") Integer grpcode,
                                                         @Param("cr_crop") Integer cr_crop,
                                                         @Param("wsrcid") Integer wsrcid,
                                                         @Param("cr_year") Integer cr_year,
                                                         @Param("cr_season") String cr_season);
             
      //mand//
             
           @Query(value= " select mcode,mname,sum(totextent) as totext from rep_mand_wise_irrgcropwise_ext_v "
           		+ " where dcode=:dcode  and grpcode=:grpcode   and wsrcid=:wsrcid "
           		+ " and cr_year=:cr_year and cr_season=:cr_season "
           				+ "group by mcode,mname  ",nativeQuery=true)
           
           List<StateWiseCropIrriAbsIntf> getWsrcMand(@Param("dcode")Integer dcode,
                                                      @Param("grpcode") Integer grpcode,
                                                      @Param("wsrcid") Integer wsrcid,
                                                      @Param("cr_year") Integer cr_year,
                                                      @Param("cr_season") String cr_season);
            
           @Query(value= " select mcode,mname,sum(totextent) as totext from rep_mand_wise_irrgcropwise_ext_v "
           		+ " where dcode=:dcode and grpcode=:grpcode and cr_crop=:cr_crop and wsrcid=:wsrcid"
           		+ " and cr_year=:cr_year and cr_season=:cr_season group by mcode,mname  ",nativeQuery=true)
           
           List<StateWiseCropIrriAbsIntf> getWsrcMand1(@Param("dcode")Integer dcode,
                                                       @Param("grpcode") Integer grpcode,
                                                       @Param("cr_crop") Integer cr_crop,
                                                       @Param("wsrcid") Integer wsrcid,
                                                       @Param("cr_year") Integer cr_year,
                                                       @Param("cr_season") String cr_season);
            

}
