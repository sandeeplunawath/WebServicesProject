package tafe;

import java.util.ArrayList;
import java.util.List;

/*package com.carmax.tafe.calculateobjects;


import com.carmax.tafe.calculate.subobjects.Inputs;
import com.carmax.tafe.calculate.subobjects.Calculations;
import com.carmax.tafe.calculate.subobjects.MissingInputs;
import com.carmax.tafe.calculate.subobjects.ValidationErrors;
import com.carmax.tafe.getinputs.subobjects.InputParameters;*/

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Calculate {

	@Getter @Setter @NoArgsConstructor
	public static class CalculateRequest {
		public String excludeCalculationTypes = ""; 
		//public InputParameters inputparameters = new InputParameters();		
		public List<Inputs> inputs = new ArrayList<Inputs>();
	}
		
	@Getter @Setter @NoArgsConstructor
		public static class CalculateResponse {
		/*public Calculations[] calculations = {new Calculations()};
		public MissingInputs[] missingInputs = {new MissingInputs()};
		public ValidationErrors[] validationErrors = {new ValidationErrors()};
*/		
//		"ruleLogs": [],
//	    "ruleCalculationTraces": []
//		Get confirmation with Dev team
		}
		
	
}
