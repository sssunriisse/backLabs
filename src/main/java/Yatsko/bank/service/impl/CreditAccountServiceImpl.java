package Yatsko.bank.service.impl;

import Yatsko.bank.entity.*;
import Yatsko.bank.service.CreditAccountService;
import tech.reliab.course.kovaleval.bank.entity.*;

import java.time.LocalDate;
import java.util.Random;

public class CreditAccountServiceImpl implements CreditAccountService {
    /**
     *
     * @param id                id of the credit account
     * @param user              credit account user
     * @param dateStart         credit start date
     * @param dateEnd           credit end date
     * @param countMoth         the length of the loan in months
     * @param loanAmount        credit amount
     * @param monthlyPayment    monthly credit payment <br>
     *                          credit interest rate (it must be equal to the interest rate of the bank
     *                          <br> where the loan was taken out or lower)
     * @param issuedEmployee    the employee who issued the credit
     * @param paymentAccount    the payment account that pays off the credit
     * @param bank              the bank where the credit was taken
     * @return                  {@link CreditAccount}
     */
    @Override
    public CreditAccount createCreditAccount(long id, User user, LocalDate dateStart,
                                             LocalDate dateEnd, int countMoth, long loanAmount,
                                             long monthlyPayment,
                                             Employee issuedEmployee, PaymentAccount paymentAccount,
                                             Bank bank) {
        CreditAccount creditAccount = CreditAccount.builder()
                .id(id)
                .user(user)
                .bankName(bank.getName())
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .countMoth(countMoth)
                .loanAmount(loanAmount)
                .monthlyPayment(monthlyPayment)
                .interestRate((double) (Math.round(Math.max(bank.getInterestRate() - new Random().nextDouble(5), 0) * 100)) /100)
                .issuedEmployee(issuedEmployee)
                .paymentAccount(paymentAccount)
                .build();
        return creditAccount;
    }

    @Override
    public CreditAccount getCreditAccount(long id) {
        return null;
    }

    @Override
    public void updateCreditAccount(long id) {

    }

    @Override
    public void deleteCreditAccount(long id) {

    }
}
