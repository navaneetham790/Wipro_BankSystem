package com.wipro.bank.acc;

public class RDAccount extends Account{
	public RDAccount(int tenure,float principal) {
		this.tenure=tenure;
		this.principal=principal;
	}
	@Override
	public float calculateAmountDeposited() {
		return principal*tenure*12;
	}
	@Override
	public float calculateInterest() {
	    int months = tenure * 12;
	    float interest = (principal * months * (months + 1) * rateOfInterest)
	            / (2 * 12 * 100);
	    return interest;
	}
}
