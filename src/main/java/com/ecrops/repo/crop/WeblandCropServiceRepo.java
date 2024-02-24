package com.ecrops.repo.crop;

import com.ecrops.dto.crop.response.WeblandCropDetails;

import com.ecrops.dto.crop.response.WeblandPullResponse;
import com.ecrops.dto.webland.WeblandCropData;
import com.ecrops.entity.crop.PattadarmastWbEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList; 
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class WeblandCropServiceRepo {

    @PersistenceContext
    private EntityManager entityManager;


    public List<PattadarmastWbEntity> getCropDetails(String wbdcode, int vCode, String season, int cropYear) {
    	
    	
    	
    	
    	if(wbdcode.length()==1){
    		wbdcode="0"+ wbdcode;
    		}
    	
    	String tableName = "pattadarmast_wb_partition_"+ season + wbdcode + cropYear ;
        String tbname="ecrop"+cropYear+"."+tableName;

        String QRY_GET_CROP_DET = "SELECT cr_dist_code, cr_mand_code, cr_vcode, cr_farmeruid, farmername, \n" +
                "fathername, mobileno, kh_no, cr_sno, tot_extent, \n" +
                "occupname, occupfname, occup_extent, regno,sjointoccupant, \n" +
                "cultivable_land, uncultivable_land, cropyear, season, status, \n" +
                "dcode, mcode, part_key,  digitally_signed FROM " + tbname + " where cr_vcode=?";
        Query query = entityManager.createNativeQuery(QRY_GET_CROP_DET);
        query.setParameter(1, vCode);
        List<Object[]> resultList = query.getResultList();
        List<PattadarmastWbEntity> entities = new ArrayList<>();
        for (Object[] ob:resultList){
            PattadarmastWbEntity entity = new PattadarmastWbEntity();
            entity.setCrDistCode(((BigDecimal)ob[0]).intValue());
            entity.setCrMandCode(((BigDecimal)ob[1]).intValue());
            entity.setCrVcode((Integer)ob[2]);
            entity.setCrFarmeruid((String) ob[3]);
            entity.setFarmername((String) ob[4]);
            entity.setFathername((String) ob[5]);
            entity.setMobileno(((BigDecimal)ob[6]).intValue());
            entity.setKhNo(((BigDecimal)ob[7]).intValue());
            entity.setCrSno((String)ob[8]);
            entity.setTotExtent(((BigDecimal)ob[9]).doubleValue());
            entity.setOccupname((String)ob[10]);
            entity.setOccupfname((String)ob[11]);
            entity.setOccupExtent(((BigDecimal)ob[12]).doubleValue());
            entity.setRegno((Integer)ob[13]);
            entity.setSjointoccupant((Integer) ob[14]);
            entity.setCultivableLand(((BigDecimal)ob[15]).doubleValue());
            entity.setUncultivableLand(((BigDecimal)ob[16]).doubleValue());
            entity.setCropyear((Integer) ob[17]);
            entity.setSeason((Character) ob[18]);
            entity.setStatus((Character)ob[19]);
            entity.setDcode((Integer)ob[20]);
            entity.setMcode((Integer)ob[21]);
            entity.setPartKey((String)ob[22]);
            entity.setDigitallySigned((String)ob[23]);
            entities.add(entity);
        }
        return entities;
    }

    public boolean checkRecordIsAvailableInDatabase(int vCode, String season, int cropYear) {
    	
//        String downtab="ecrop"+cropYear+"."+"download";
//
//    	
//        String QRY_GET_RECORDS_CNT = "select no_of_records as cnt from "+ downtab +" where  vcode=:vcode  " +
//                "and cropyear=:cropyear and season=:season";
//
//        Query query = entityManager.createNativeQuery(QRY_GET_RECORDS_CNT);
//        query.setParameter("vcode", vCode);
//        query.setParameter("cropyear", cropYear);
//        query.setParameter("season", season);
    	
    	String downtab = "ecrop" + cropYear + "." + "verify_datadownload";

		String QRY_GET_RECORDS_CNT = "select wb_cnt as cnt from " + downtab + " where  cr_vcode= ? "
				+ "and cr_year= ? and cr_season= ?";

		Query query = entityManager.createNativeQuery(QRY_GET_RECORDS_CNT);
		query.setParameter(1, vCode);
		query.setParameter(2, cropYear);
		query.setParameter(3, season);
    	
        List<Object> results = query.getResultList();
        if (null != results && !results.isEmpty() && null != results.get(0)) {
            return ((int) results.get(0)) > 0;
        }
        return false;
    }

    @Transactional
    public WeblandPullResponse checkInsertAndViewWeblandCropDetails(String userId, String ipAddress,
                                                                    String wbdcode,int wbmcode, int vCode, String season, int cropYear,int sesdcode,int sesmcode) {
    	
    	
        ModelMapper mapper = new ModelMapper();

        WeblandPullResponse pullResponse = new WeblandPullResponse();

        //CheckRecordIs Available
        if (checkRecordIsAvailableInDatabase(vCode, season, cropYear)) {

            List<PattadarmastWbEntity> cropDetails = getCropDetails(wbdcode, vCode, season, cropYear);
            List<WeblandCropDetails> collect = mapper.map(cropDetails, new TypeToken<List<WeblandCropDetails>>() {
            }.getType());


            pullResponse.setMessage("Records already available in database");
            pullResponse.setCropData(collect);
            return pullResponse;
        }else {

        
        
    	
    	if(wbdcode.length()==1){
    		wbdcode="0"+ wbdcode;
    		}

        
    	String tableName = "pattadarmast_wb_partition_"+ season + wbdcode + cropYear ;
        String tbname="ecrop"+cropYear+"."+tableName;
        
        


        String QRY_INS_CROP_DET = "INSERT INTO " + tbname + " (\n" +
                "cr_dist_code, cr_mand_code, cr_vcode, cr_farmeruid, farmername, \n" +
                "fathername, mobileno, kh_no, cr_sno, tot_extent, \n" +
                "occupname, occupfname, occup_extent, regno,sjointoccupant, \n" +
                "cultivable_land, uncultivable_land, cropyear, season, status, \n" +
                "dcode, mcode, part_key,  digitally_signed) \n" +
                "VALUES (?,?,?,?,?,\n" +
                "?,?,?,?,?, \n" +
                "?,?,?,?,?, \n" +
                "?,?,?,?,?,\n" +
                "?,?,?,?)";

//        String downtab="ecrop"+cropYear+"."+"downloaddetails";
//
//        
//        String QRY_INS_USER_DET = "INSERT INTO "+ downtab + "( vcode, userid, no_of_records, downloadtime, ipaddress,ccrc_status,cropyear,season)\n" +
//                "VALUES (?, ?, ?, now(), ?, ?,?,?)";
        
        String downtab = "ecrop" + cropYear + "." + "verify_datadownload";

		String updateQuery = "UPDATE " + downtab + " SET wb_cnt = ?, wbland = 'Y', dt_wbland = now() "
				+ " WHERE cr_dist_code = ? AND cr_mand_code = ? AND cr_vcode = ? AND cr_year = ? AND cr_season = ?";

        int insCount = 0;
        List<WeblandCropData> weblandCropData = getWeblandCropData(String.valueOf(wbdcode), String.valueOf(vCode));
        for (WeblandCropData data : weblandCropData) {

            String status;
            double occupext = 0.0;
            double totext = Double.parseDouble(data.getTotalextent());

            if (null != data.getPextent() && !data.getPextent().isEmpty()) {
                occupext = Double.parseDouble(data.getPextent());
            }

            if (occupext == 0.0 || totext == 0.0 || occupext > totext || data.getOccuptFname().equals("") || data.getpFname().equals("") || totext < 0) {
                status = "N";
            } else {
                status = "Y";
            }

            String isDigitallySigned = "";
            if (data.getIsSignedorNot().equalsIgnoreCase("Yes")) {
                isDigitallySigned = "Y";
            } else if (data.getIsSignedorNot().equalsIgnoreCase("No")) {
                isDigitallySigned = "N";
            }

            double mobileNo = 0;

            if (null != data.getpMobileno() && data.getpMobileno().length() == 10) {
                mobileNo = Double.parseDouble(data.getpMobileno());
            }


            insCount += entityManager.createNativeQuery(QRY_INS_CROP_DET)
                    .setParameter(1, Integer.parseInt(data.getDist_code()))
                    .setParameter(2, Integer.parseInt(data.getMand_code()))
                    .setParameter(3, Integer.parseInt(data.getVillage_Code()))
                    .setParameter(4, data.getPattadar_uid())
                    .setParameter(5, data.getpName())
                    .setParameter(6, data.getpFname())
                    .setParameter(7, mobileNo)
                    .setParameter(8, Long.parseLong(data.getpKhatano()))
                    .setParameter(9, data.getpSurveyno())
                    .setParameter(10, Double.parseDouble(data.getTotalextent()))
                    .setParameter(11, data.getOccuptName())
                    .setParameter(12, data.getOccuptFname())
                    .setParameter(13, Double.parseDouble(data.getPextent()))
                    .setParameter(14, Integer.parseInt(data.getRegno()))
                    .setParameter(15, data.getSinglejointoccupant())
                    .setParameter(16, Double.parseDouble(data.getCultivatable_land()))
                    .setParameter(17, Double.parseDouble(data.getUncultivated_Land()))
                    .setParameter(18, cropYear)
                    .setParameter(19, season)
                    .setParameter(20, status)
                    .setParameter(21, sesdcode)
                    .setParameter(22, sesmcode)
                     .setParameter(23, season + wbdcode + cropYear)
                    .setParameter(24, isDigitallySigned)
                    .executeUpdate();
        }

        //Insert User Details
//        entityManager.createNativeQuery(QRY_INS_USER_DET)
//                .setParameter(1, vCode)
//                .setParameter(2, userId)
//                .setParameter(3, insCount)
//                .setParameter(4, ipAddress)
//                .setParameter(5, "W") 
//                .setParameter(6, cropYear)
//                .setParameter(7, season)
//                .executeUpdate();
        
        
        Query insertCdown = entityManager.createNativeQuery(updateQuery);
		insertCdown.setParameter(1, insCount);
		insertCdown.setParameter(2, Integer.parseInt(wbdcode));
		insertCdown.setParameter(3, wbmcode);
		insertCdown.setParameter(4, vCode);
		insertCdown.setParameter(5, cropYear);
		insertCdown.setParameter(6, season);
		int cdowndet = insertCdown.executeUpdate();

		System.out.println("cdowndet----->" + cdowndet);

        List<PattadarmastWbEntity> cropDetails = getCropDetails(wbdcode, vCode, season, cropYear);
        List<WeblandCropDetails> collect = mapper.map(cropDetails, new TypeToken<List<WeblandCropDetails>>() {
        }.getType());
        pullResponse.setMessage("WebLand Records Inserted successfully.");
        pullResponse.setCropData(collect);
        return pullResponse;
    }
    }

    public List<WeblandCropData> getWeblandCropData(String wbdcode, String vCode) {
        String weblandDetails = fetchWeblandDetailsFromURL(wbdcode, vCode);

        ObjectMapper mapper = new ObjectMapper();
        List<WeblandCropData> cropList = new ArrayList<WeblandCropData>();
        try {
            cropList = mapper.readValue(weblandDetails, new TypeReference<List<WeblandCropData>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cropList;
    }

    public String fetchWeblandDetailsFromURL(String wbdcode, String vCode) {
        String url = "http://webland.ap.gov.in/srosubdivision.asmx/StartEcropProcess?Dcode=" + wbdcode + "&Vcode=" + vCode
                + "&UsrId=crop&Password=crop@2019";
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL apiUrl = new URL(url);
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                String xmlResponse = response.toString();
                String jsonResponse = xmlResponse.substring(xmlResponse.indexOf("[{"), xmlResponse.indexOf("}]") + 2);
                return jsonResponse;
            } else {
                System.out.println("Error: " + responseCode);
                throw new RuntimeException("URL Response error. " + responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("URL Reading error");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    throw new RuntimeException("URL Reader closing error");
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
