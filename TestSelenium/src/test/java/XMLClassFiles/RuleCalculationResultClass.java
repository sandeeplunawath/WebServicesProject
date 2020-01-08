package XMLClassFiles;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RuleCalculationResultClass {

	public String CalculationId;
	public String CalculationType;
	public String Description;
	public String DisplayName;
	public boolean IsCalculated;
	public String Name;
	public int RuleId;
	public int RuleInstanceId;
	public int StatusId;
	public String Trace;
	public float Value;
	public String Tag;
}
