import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }


    @Test
    public void testSimpleAdditon() {
       Expression sum = new Sum(Money.dollar(3),
               Money.dollar(4));
       Bank bank = new Bank();
       Money result = bank.reduce(sum, "USD");
       assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);

    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenfrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenfrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenfrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenfrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    /*
    @Test
    public void testPlusSameCurrencyReturnsMoney(){
        Expression sum = Money.dollar(1).plus(Money.dollar(1));
        assertTrue(sum instanceof Money);
    }

     */



}