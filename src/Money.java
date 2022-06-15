 class Money implements Expression{
    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

     Expression plus (Money added) {
         return new Sum(this, added);
     }

     public Money reduce (String to){
        return this;
     }

    public boolean equals (Object object){
        Money money = (Money) object;
        return amount == money.amount &&
                currency.equals(money.currency);
    }
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    static Money franc(int amount){
        return new Money(amount, "CHF");
    }


}
