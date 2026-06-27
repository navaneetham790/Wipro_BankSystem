package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;
public class BankService {
    public boolean validateData(float principal, int tenure, int age, String gender) {
        try {
            if (principal < 500)
                throw new BankValidationException();
            if (tenure != 5 && tenure != 10)
                throw new BankValidationException();
            if (age < 1 || age > 100)
                throw new BankValidationException();
            if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")))
                throw new BankValidationException();
            return true;
        } catch (BankValidationException e) {
            System.out.println(e);
            return false;
        }
    }
    public void calculate(float principal, int tenure, int age, String gender) {
        if (validateData(principal, tenure, age, gender)) {
            RDAccount rd = new RDAccount(tenure, principal);
            rd.setInterest(age, gender);
            float amountDeposited = rd.calculateAmountDeposited();
            float interest = rd.calculateInterest();
            float maturityAmount = rd.calculateMaturityAmount(amountDeposited, interest);
            System.out.println("Amount Deposited : " + amountDeposited);
            System.out.println("Interest         : " + interest);
            System.out.println("Maturity Amount  : " + maturityAmount);
        }
    }
}