package Yatskol.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Bank {
    private long id;
    private String name;
    private List<BankOffice> bankOffices;
    private List<BankAtm> bankAtms;
    private List<Employee> employees;
    private List<User> users;
    private int rating;
    private double money;
    private double interestRate;

    @Override
    public String toString()
    {
        return "Id банка: " + id
                + "\nНазвание банка: " + name
                + "\nРейтинг банка: " + rating
                + "\nКол-во денег: " + money
                + "\nПроцентная ставка банка: " + interestRate;
    }
}

