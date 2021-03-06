package tafe;

//package com.carmax.tafe.calculate.subobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Inputs {

	public Integer id = 0;
	public String name = "";
	public String description = "";
	public String displayName = "";
	public String validationMessage = "";
	public Integer dataTypeId = 0;
	public String validation = "";
	public Integer ruleId = 0;
	public Integer ruleInstanceId = 0;
	public String ruleName = "";
	public Boolean isEnumerated = false;
	public String value = "";
	public String tag = "";
	
	Inputs(Integer id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
}
