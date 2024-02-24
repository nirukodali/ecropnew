package com.ecrops.repo.crop;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecrops.dto.crop.request.EfishLandData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
@Transactional
public class EfishService {

	@PersistenceContext
	private EntityManager entityManager;
	
    public int getCr_Vcode(int cropYear, String season) {
        if (cropYear <= 0) {
            throw new IllegalArgumentException("Crop year must be a positive integer.");
        }

        if (season == null || season.isEmpty()) {
            throw new IllegalArgumentException("Season must not be empty.");
        }

        String downtab = "ecrop" + cropYear + "." + "verify_datadownload";
        String QRY_GET_Cr_Vcode = "SELECT cr_vcode FROM " + downtab + " WHERE efish_cnt = 10 AND cr_year = ? AND cr_season = ?";
        Query query = entityManager.createNativeQuery(QRY_GET_Cr_Vcode);
        query.setParameter(1, cropYear);
        query.setParameter(2, season);

        Number crVcode;
        try {
            crVcode = (Number) query.getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("No result found for the specified criteria.", e);
        }

        return crVcode.intValue();
    }

    @Transactional
    public int checkRecordIsAvailableInDatabase(int villageCode, String season, int cropYear) {
        if (villageCode <= 0) {
            throw new IllegalArgumentException("Village code must be a positive integer.");
        }

        if (season == null || season.isEmpty()) {
            throw new IllegalArgumentException("Season must not be empty.");
        }

        String downtab = "ecrop" + cropYear + "." + "verify_datadownload";
        String QRY_GET_RECORDS_CNT = "SELECT efish_cnt AS count FROM " + downtab + " WHERE cr_vcode = ? AND cr_year = ? AND cr_season = ?";

        Query query = entityManager.createNativeQuery(QRY_GET_RECORDS_CNT);
        query.setParameter(1, villageCode);
        query.setParameter(2, cropYear);
        query.setParameter(3, season);

        Number result;
        try {
            result = (Number) query.getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("No records found for the specified criteria.", e);
        }

        return (result != null) ? result.intValue() : 0;
    }

    public int inserVillageDataIntoVerifyDownloadTable(int cropYear, String season, int Cr_vcode, String ipAddress, int wbdcode, int wbmcode) {
        if (cropYear <= 0) {
            throw new IllegalArgumentException("Crop year must be a positive integer.");
        }

        if (season == null || season.isEmpty()) {
            throw new IllegalArgumentException("Season must not be empty.");
        }

        if (Cr_vcode <= 0) {
            throw new IllegalArgumentException("Cr_vcode must be a positive integer.");
        }

        if (ipAddress == null || ipAddress.isEmpty()) {
            throw new IllegalArgumentException("IP address must not be empty.");
        }

        String downtab = "ecrop" + cropYear + "." + "verify_datadownload";

        String QRY_INS_USER_DET = "INSERT INTO " + downtab + "(cr_dist_code, cr_mand_code, cr_vcode, cr_year, cr_season, efish_cnt, efish, dt_efish, clientip) VALUES (?, ?, ?, ?, ?, ?, 'Y', now(), ?)";
        
        Query insertQuery = entityManager.createNativeQuery(QRY_INS_USER_DET);
        insertQuery.setParameter(1, wbdcode);
        insertQuery.setParameter(2, wbmcode);
        insertQuery.setParameter(3, Cr_vcode);
        insertQuery.setParameter(4, cropYear);
        insertQuery.setParameter(5, season);
        insertQuery.setParameter(6, 0);
        insertQuery.setParameter(7, ipAddress);

        int villageCount;
        try {
            villageCount = insertQuery.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert village data into verify download table.", e);
        }

        return villageCount;
    }

	public int insertEfishDetails(String ipaddress, int cropyear, String season) {
		String insertQuery = "INSERT INTO ecrop2023.cr_details_efish_2023 "
				+ "(cr_sno, total_extent, uncultivated_land, cultivatable_land, land_nature,"
				+ " tax, land_classification, water_source, ayakat_extent, kh_no,"
				+ " pattadar_name, pattadar_father_name, base_survey_no, occupant_name, occupant_father_name,"
				+ " occupant_extent, enjoyment_nature, dist_code, dist_name, mand_code,"
				+ " mand_name, cr_vcode, village_name, aqua_zone_y_n, webland_id, mapped_extent) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		String downtab = "ecrop" + cropyear + "." + "verify_datadownload";

		//
		String QRY_INS_USER_DET = "INSERT INTO " + downtab
				+ "(cr_dist_code, cr_mand_code, cr_vcode, cr_year, cr_season, "
				+ "   efish_cnt, efish,  dt_efish, clientip) " + "VALUES (?, ?, ?, ?, ?, ?,  'Y',now(), ? ) ";
		
		
		
			

		String token = getToken(); // Get token from eFish API

		List<EfishLandData> cropDataList = getEfishServiceData(token); // Fetch crop data from eFish API
		int efishcount = 0;

		for (EfishLandData data : cropDataList) {
			try {
				// Execute insert query for each crop data
				efishcount += entityManager.createNativeQuery(insertQuery).setParameter(1, data.getSurveyNo())
						.setParameter(2, Double.parseDouble(data.getTotalExtent()))
						.setParameter(3, Double.parseDouble(data.getUncultivatedLand()))
						.setParameter(4, Double.parseDouble(data.getCultivatableLand()))
						.setParameter(5, data.getLandNature()).setParameter(6, data.getTax())
						.setParameter(7, data.getLandClassification()).setParameter(8, data.getWaterSource())
						.setParameter(9, Double.parseDouble(data.getAyakatExtent())).setParameter(10, data.getKhataNo())
						.setParameter(11, data.getPattadarName()).setParameter(12, data.getPattadarFatherName())
						.setParameter(13, data.getBaseSurveyNo()).setParameter(14, data.getOccupantName())
						.setParameter(15, data.getOccupantFatherName())
						.setParameter(16, Double.parseDouble(data.getOccupantExtent()))
						.setParameter(17, data.getEnjoymentNature()).setParameter(18, data.getDistCode())
						.setParameter(19, data.getDistName()).setParameter(20, data.getMandCode())
						.setParameter(21, data.getMandName()).setParameter(22, data.getVillageCode())
						.setParameter(23, data.getVillageName()).setParameter(24, data.getAquaZoneStatus())
						.setParameter(25, data.getWebLandId()).setParameter(26, data.getMappedExtent()).executeUpdate();
			} catch (Exception e) {
				System.out.println("Error inserting data: " + e.getMessage());
				throw new RuntimeException("Error inserting data", e);
			}
		}
		if (efishcount >= 0) {
			try {
				int temp = 0;
				for (EfishLandData data : cropDataList) {
					entityManager.createNativeQuery(QRY_INS_USER_DET).setParameter(1, data.getDistCode())
							.setParameter(2, data.getMandCode())
							.setParameter(3, Integer.parseInt(data.getVillageCode())).setParameter(4, cropyear)
							.setParameter(5, season).setParameter(6, efishcount).setParameter(7, ipaddress)
							.executeUpdate();
					temp++;
					if (temp == 1) {
						break;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error inserting user details: " + e.getMessage());
			}
		}

		return efishcount;
	}

	// Method to fetch crop data from eFish API

	@Transactional
	public List<EfishLandData> getEfishServiceData(String accessToken) {
		try {
			String efishData = fetchEfishServiceData(accessToken);
			ObjectMapper mapper = new ObjectMapper();

			JsonNode rootNode = mapper.readTree(efishData);

			JsonNode resultNode = rootNode.get("result");

			List<EfishLandData> efishLandDataList = mapper.readValue(resultNode.toString(),
					new TypeReference<List<EfishLandData>>() {
					});

			return efishLandDataList;
		} catch (IOException e) {
			System.err.println("Error reading eFish service data: " + e.getMessage());
			throw new RuntimeException("Error reading eFish service data", e);
		}
	}

	public String getToken() {
		String apiUrl = "http://efish.co.in/api2/thirdPartyAPI/APItoken";
		StringBuilder response = new StringBuilder();
		String accessToken = null;

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");

			String jsonInputString = "{\"userName\":\"EFISH\", \"password\":\"EFisheries@987\"}";
			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
			}

			Gson gson = new Gson();
			Map<String, Object> responseMap = gson.fromJson(response.toString(), Map.class);
			Object access_Token = responseMap.get("access_token");
			accessToken = (String) access_Token;
			connection.disconnect();
		} catch (IOException e) {
			System.out.println("Error getting token: " + e.getMessage());
			throw new RuntimeException("Error getting token", e);
		}

		return accessToken;
	}

	public String fetchEfishServiceData(String accessToken) throws IOException {
		String apiUrl = "http://efish.co.in/api2/thirdPartyAPI/VillageSurveyData";
		String requestBody = "{\"PUSERNAME\":\"EFISH\"}";
		StringBuilder response = new StringBuilder();

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", accessToken);

			try (OutputStream os = connection.getOutputStream();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
				writer.write(requestBody);
				writer.flush();
			}

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
			}
			connection.disconnect();
		} catch (IOException e) {
			System.out.println("Error fetching eFish service data: " + e.getMessage());
			throw e;
		}
		return response.toString();
	}
}
