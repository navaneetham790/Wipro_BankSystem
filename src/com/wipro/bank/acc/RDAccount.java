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
        int n = 4; 
        float r = rateOfInterest / 100; 
        int t = tenure;
        float amount = (float) (principal * (Math.pow((1 + r / n), n * t)));
        return amount - principal;
	}
}
