package com.ecrops.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CultivatorEmbedableDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7934250696579026205L;

	@NotNull
	private Integer bookingid;

	@NotNull
	private String part_key;
	
	

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public String getPart_key() {
		return part_key;
	}

	public void setPart_key(String part_key) {
		this.part_key = part_key;
	}

	public CultivatorEmbedableDto(@NotNull Integer bookingid, @NotNull String part_key) {
		super();
		this.bookingid = bookingid;
		this.part_key = part_key;
	}

	public CultivatorEmbedableDto() {
		super();
	}

}
