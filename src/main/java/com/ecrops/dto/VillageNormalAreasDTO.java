package com.ecrops.dto;

import java.math.BigDecimal;

public class VillageNormalAreasDTO {
    private int vcode;
    private BigDecimal normalarea;
    private String wbvname;
    private String selectedCrop;
  //  private BigDecimal targetarea;
    
	public int getVcode() {
		return vcode;
	}
	public void setVcode(int vcode) {
		this.vcode = vcode;
	}
	public BigDecimal getNormalarea() {
		return normalarea;
	}
	public void setNormalarea(BigDecimal normalarea) {
		this.normalarea = normalarea;
	}
	public String getWbvname() {
		return wbvname;
	}
	public void setWbvname(String wbvname) {
		this.wbvname = wbvname;
	}
	public String getSelectedCrop() {
		return selectedCrop;
	}
	public void setSelectedCrop(String selectedCrop) {
		this.selectedCrop = selectedCrop;
	}
	/*public BigDecimal getTargetarea() {
		return targetarea;
	}
	public void setTargetarea(BigDecimal targetarea) {
		this.targetarea = targetarea;
		}
	*/

    
    
}
