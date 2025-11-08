package service;

public interface FeeService {
    void payFees(int studentId, int amount);
    void refund(int studentId, int amount);
}
