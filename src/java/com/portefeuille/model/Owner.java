package com.portefeuille.model;


//@XmlRootElement
//@XmlType(propOrder={"id", "name"})
public class Owner {
	
	//@XmlElement
	private Integer id;
	//@XmlElement
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
