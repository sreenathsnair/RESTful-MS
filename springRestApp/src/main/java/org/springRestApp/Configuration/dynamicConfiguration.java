package org.springRestApp.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class dynamicConfiguration {
	private int intData;
	private String strData;
	private boolean boolData;
	public dynamicConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public dynamicConfiguration(int intData, String strData, boolean boolData) {
		super();
		this.intData = intData;
		this.strData = strData;
		this.boolData = boolData;
	}

	public int getIntData() {
		return intData;
	}
	
	public void setIntData(int intData) {
		this.intData = intData;
	}
	public String getStrData() {
		return strData;
	}
	public void setStrData(String strData) {
		this.strData = strData;
	}
	public boolean isBoolData() {
		return boolData;
	}
	public void setBoolData(boolean boolData) {
		this.boolData = boolData;
	}

}
