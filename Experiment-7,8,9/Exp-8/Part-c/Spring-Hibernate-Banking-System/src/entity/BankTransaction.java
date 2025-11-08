package entity;

import javax.persistence.*;

@Entity
@Table(name="bank_transaction")
public class BankTransaction {

    @Id
    @GeneratedValue
    private int id;

    private int fromAcc;
    private int toAcc;
    private int amount;

    public BankTransaction() {}

    public BankTransaction(int fromAcc, int toAcc, int amount) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
    }
}
