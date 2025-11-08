package dao;
import entity.Account;

public interface AccountDao {
    Account getAccount(int accNo);
    void updateAccount(Account acc);
    void saveTransaction(int from, int to, int amount);
}
