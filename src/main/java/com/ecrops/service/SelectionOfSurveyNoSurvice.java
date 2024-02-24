
package com.ecrops.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ecrops.dto.SelectionOfSurvyPojo;

public interface SelectionOfSurveyNoSurvice {

	List<SelectionOfSurvyPojo> getData(HttpServletRequest request, HttpSession session);

	List<String> getDataForAllotedArea(HttpServletRequest request, HttpSession session);

}
