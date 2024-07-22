package com.pwskills.danish.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo {
	
	@EmbeddedId
	private ProgramCompositeId id;
	@Column
	private String pName;
	@Column
	private String projName;

	public ProgramCompositeId getId() {
		return id;
	}

	public void setId(ProgramCompositeId id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	
}
