package Yatsko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder

public class CreditAccount {
    private long id;
    private User user;
    private String bankName;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int countMoth;
    private long loanAmount;
    private long monthlyPayment;
    private double interestRate;
    private Employee issuedEmployee;
    private PaymentAccount paymentAccount;

    @Override
    public String toString()
    {
        return "Id кредитного аккаунта: " + id
                + "\nId клиента: " + user.getId()
                + "\nНазвание банка: " + bankName
                + "\nОткрытие счёта: " + dateStart
                + "\nЗакрытие счёта: " + dateEnd
                + "\nКоличество месяцев: " + countMoth
                + "\nСумма кредита: " + loanAmount
                + "\nЕжемесячный платёж: " + monthlyPayment
                + "\nПроцентная ставка: " + interestRate
                + "\nВыдавший сотрудник (id): " + issuedEmployee.getId()
                + "\nПлатёжный аккаунт: " + paymentAccount;
    }
}
