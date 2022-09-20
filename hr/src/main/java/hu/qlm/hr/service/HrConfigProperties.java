package hu.qlm.hr.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigProperties {

	private int payRaiseLimitInYears;
	private double payRaiseBeforeLimit;
	private double payRaiseAfterLimit;
	
	public int getPayRaiseLimitInYears() {
		return payRaiseLimitInYears;
	}
	public void setPayRaiseLimitInYears(int payRaiseLimitInYears) {
		this.payRaiseLimitInYears = payRaiseLimitInYears;
	}
	public double getPayRaiseBeforeLimit() {
		return payRaiseBeforeLimit;
	}
	public void setPayRaiseBeforeLimit(double payRaiseBeforeLimit) {
		this.payRaiseBeforeLimit = payRaiseBeforeLimit;
	}
	public double getPayRaiseAfterLimit() {
		return payRaiseAfterLimit;
	}
	public void setPayRaiseAfterLimit(double payRaiseAfterLimit) {
		this.payRaiseAfterLimit = payRaiseAfterLimit;
	}
	
}
