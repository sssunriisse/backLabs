package Yatskol.bank.service;

import Yatskol.bank.entity.*;
import tech.reliab.course.kovaleval.bank.entity.*;

import java.time.LocalDate;


public interface CreditAccountService {
    /**
     *
     * @param id                id of the credit account
     * @param user              credit account user
     * @param dateStart         credit start date
     * @param dateEnd           credit end date
     * @param countMoth         the length of the loan in months
     * @param loanAmount        credit amount
     * @param monthlyPayment    monthly credit payment
     * @param issuedEmployee    the employee who issued the credit
     * @param paymentAccount    the payment account that pays off the credit
     * @param bank              the bank where the credit was taken
     * @return                  return an object of the CreditAccount class
     */
    CreditAccount createCreditAccount(long id, User user, LocalDate dateStart, LocalDate dateEnd,
                                      int countMoth, long loanAmount, long monthlyPayment,
                                      Employee issuedEmployee,
                                      PaymentAccount paymentAccount, Bank bank);

    /**
     * Get credit account by id.
     *
     * @param id                id of the credit account
     * @return                  return an object of the CreditAccount class
     */
    CreditAccount getCreditAccount(long id);

    /**
     * Update credit account by id.
     *
     * @param id                id of the credit account
     */
    void updateCreditAccount(long id);

    /**
     * Delete credit account by id.
     *
     * @param id                id of the credit account
     */
    void deleteCreditAccount(long id);
}
