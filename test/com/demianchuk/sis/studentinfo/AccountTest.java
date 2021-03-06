package com.demianchuk.sis.studentinfo;

import java.math.BigDecimal;
import junit.framework.TestCase;


public class AccountTest extends TestCase {
    public void testTransactions(){
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        assertEquals(new BigDecimal("11.10"), account.getBalance());
        assertNotSame(new BigDecimal("11.1"), account.getBalance());
        
        assertEquals(new BigDecimal("5.300"), 
                new BigDecimal("5.000").add(new BigDecimal("0.3")));      
    }

    public void testTransactionAverage(){
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));
        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }
}
