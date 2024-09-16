package Yatskol.bank.service;

import Yatskol.bank.entity.PaymentAccount;
import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.User;

public interface PaymentAccountService {
    /**
     *
     * @param id        id of the payment account
     * @param user      user of the payment account
     * @param bank      the bank where the payment account is registered
     * @return          return an object of the PaymentAccount class
     */
    PaymentAccount createPaymentAccount(long id, User user, Bank bank);

    /**
     * Get bank office by id.
     *
     * @param id        id of the payment account
     * @return          return an object of the PaymentAccount class
     */
    PaymentAccount getPaymentAccount(long id);

    /**
     * Update bank office by id.
     *
     * @param id        id of the payment account
     */
    void updatePaymentAccount(long id);

    /**
     * Delete bank office by id.
     *
     * @param id        id of the payment account
     */
    void deletePaymentAccount(long id);
}
