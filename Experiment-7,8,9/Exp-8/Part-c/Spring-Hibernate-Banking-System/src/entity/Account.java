package entity;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {

    @Id
    private int accNo;

    private String name;
    private int balance;

    public int getAccNo() { return accNo; }
    public String getName() { return name; }
    public int getBalance() { return balance; }

    public void setAccNo(int accNo) { this.accNo = accNo; }
    public void setName(String name) { this.name = name; }
    public void setBalance(int balance) { this.balance = balance; }
}
