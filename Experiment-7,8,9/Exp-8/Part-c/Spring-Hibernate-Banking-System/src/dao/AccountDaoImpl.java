package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.Account;
import entity.BankTransaction;

public class AccountDaoImpl implements AccountDao {

    private SessionFactory sf;

    public AccountDaoImpl(SessionFactory sf) {
        this.sf = sf;
    }

    public Account getAccount(int accNo) {
        return sf.getCurrentSession().get(Account.class, accNo);
    }

    public void updateAccount(Account acc) {
        sf.getCurrentSession().update(acc);
    }

    public void saveTransaction(int from, int to, int amount) {
        BankTransaction bt = new BankTransaction(from, to, amount);
        sf.getCurrentSession().save(bt);
    }
}
