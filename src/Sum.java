public class Sum implements Expression {
    Money augend;
    Money addend;
    Sum(Money augend,Money addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to){
        int amout = augend.amount + addend.amount;
        return new Money(amout, to);
    }



}
