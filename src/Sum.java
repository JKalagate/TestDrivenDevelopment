public class Sum implements Expression {
    Expression augend;
    Expression addend;
    Sum(Expression augend,Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Expression plus (Expression addend){
        return null;
    }

    public Money reduce(Bank bank, String to){
        int amout = augend.reduce(bank, to).amount
                + addend.reduce(bank, to).amount;
        return new Money(amout, to);
    }



}
