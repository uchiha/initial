package common;

public class LocatorWrapper {

	public enum LocatorType {
		XPATH, NAME, ID, CSS_SELECTOR;
	}
	
	public String elementName;
	public String elementValue;
	public LocatorType elementType;
	
	public LocatorWrapper(String elementName, String elementValue, LocatorType elementType) {
		this.elementName = elementName;
		this.elementValue = elementValue;
		this.elementType = elementType;
	}

}
