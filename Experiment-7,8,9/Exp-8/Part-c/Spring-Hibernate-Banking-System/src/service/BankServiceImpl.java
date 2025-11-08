package service;

import javax.transaction.Transactional;
import dao.AccountDao;
import entity.Account;

public class BankServiceImpl implements BankService {

    private AccountDao dao;

    public BankServiceImpl(AccountDao dao) {
        this.dao = dao;
    }

    @Transactional  // ✅ ensures rollback if something fails
    public void transfer(int fromAcc, int toAcc, int amount) {

        Account a1 = dao.getAccount(fromAcc);
        Account a2 = dao.getAccount(toAcc);

        // Deduct from sender
        a1.setBalance(a1.getBalance() - amount);
        dao.updateAccount(a1);

        // Add to receiver
        a2.setBalance(a2.getBalance() + amount);
        dao.updateAccount(a2);

        // Save transaction record
        dao.saveTransaction(fromAcc, toAcc, amount);

        // Example of forced failure test: uncomment to test rollback
        // if(true) throw new RuntimeException("Error! Rollback Test");
    }
}
