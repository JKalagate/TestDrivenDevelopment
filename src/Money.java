 class Money {
    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals (Object object){
        Money money = (Money) object;
        return amount == money.amount &&
                currency.equals(money.currency);
    }

    Money time (int multiplier){
        return new Money(amount * multiplier, currency);
    }

    //abstract Money times (int multiplier);

    static Money dollar(int amount){
        return new Dollar(amount, "USD");
    }
    static Money franc(int amount){
        return new Franc(amount, "CHF");
    }
}
