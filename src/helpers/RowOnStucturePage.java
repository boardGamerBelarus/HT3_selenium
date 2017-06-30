package helpers;

public class RowOnStucturePage {

	public String inputNameValue;
	public String inputNameLocator;
	public String selectorTypeLocator;
	public String optionTypeLocator;
	public String inputValuesLocator;
	public String inputValuesName;
	public String checkboxAILocator;
	public String checkboxAIValue;

	public RowOnStucturePage(Integer rowNumber, String inputName, 
			String selectorType, String inputValues, String checkboxAI){
		this.inputNameValue = inputName;
		this.inputNameLocator="field_"+rowNumber+"_1";					
		this.selectorTypeLocator = "field_"+rowNumber+"_2";
			
		switch(selectorType){
		case "INT":
			this.optionTypeLocator = "//select[@id='field_"+rowNumber+"_2']/option[contains(text(), 'INT')]";
			break;
			
		case "CHAR":
			this.optionTypeLocator = "//select[@id='field_"+rowNumber+"_2']//option[text()='CHAR']";
			break;
			
		case "VARCHAR":
			this.optionTypeLocator = "//select[@id='field_"+rowNumber+"_2']/option[contains(text(), 'VARCHAR')]";
			break;
		}
		this.inputValuesLocator = "field_"+rowNumber+"_3";
		this.inputValuesName = inputValues;
		
		this.checkboxAILocator = "field_"+rowNumber+"_8";
		this.checkboxAIValue=checkboxAI;
	}
}
