package com.automobiles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ExcelData {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partid;
	private String partname;
	private int partqty;
	
	public ExcelData() {}
		
	public ExcelData(int partid, String partname, int partqty) {
		super();
		this.partid = partid;
		this.partname = partname;
		this.partqty = partqty;
	}

	public int getPartid() {
		return partid;
	}

	public void setPartid(int partid) {
		this.partid = partid;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public int getPartqty() {
		return partqty;
	}

	public void setPartqty(int partqty) {
		this.partqty = partqty;
	}

	@Override
	public String toString() {
		return "ExcelData [partid=" + partid + ", partname=" + partname + ", partqty=" + partqty + "]";
	}

	
	
	
	
	
	
}
