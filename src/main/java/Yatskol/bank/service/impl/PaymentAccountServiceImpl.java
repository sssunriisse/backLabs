package Yatskol.bank.service.impl;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.PaymentAccount;
import Yatskol.bank.entity.User;
import Yatskol.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    /**
     *
     * @param id        id of the payment account
     * @param user      user of the payment account
     * @param bank      the bank where the payment account is registered <br>
     *
     *                  <br> the money in the payment account (by default 0) <br>
     * @return          {@link PaymentAccount}
     */
    @Override
    public PaymentAccount createPaymentAccount(long id, User user, Bank bank) {
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .id(id)
                .user(user)
                .bankName(bank.getName())
                .money(0)
                .build();
        return paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccount(long id) {
        return null;
    }

    @Override
    public void updatePaymentAccount(long id) {

    }

    @Override
    public void deletePaymentAccount(long id) {

    }
}
