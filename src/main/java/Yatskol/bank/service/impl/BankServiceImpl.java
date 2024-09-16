package Yatskol.bank.service.impl;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.service.BankService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class BankServiceImpl implements BankService {
    /**
     *
     * @param id        id of the bank
     * @param name      id of the name <br>
     *
     *                  number of offices at the bank (it is filled in and counted automatically when
     *                  <br> a new office is added, by default 0) <br>
     *
     *                  number of ATMs at the bank (it is filled in and counted automatically when
     *                  <br> a new ATM is added, by default 0) <br>
     *
     *                  number of employees at the bank (it is filled in and counted automatically when
     *                  <br> a new employee is added, by default 0) <br>
     *
     *                  number of users at the bank (it is filled in and counted automatically when
     *                  <br> a new user is added, by default 0) <br>
     *
     *                  rating of the bank (generated randomly, from 0 to 100, where 100 is the highest
     *                  <br> score, the higher the bank's rating, the lower the interest rate should be) <br>
     *
     *                  the money in the bank (generated randomly, but no more than 1,000,000) <br>
     *
     *                  the bank's interest rate (it is generated randomly, but no more than 20%, however,
     *                  <br> you need to take into account the bank's rating, the higher it is, the lower <br>
     *                  <br> the rate should be generated) <br>
     * @return          {@link Bank}
     */
    @Override
    public Bank createBank(long id, String name) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Bank bank = Bank.builder()
                .id(id)
                .name(name)
                .bankOffices(new ArrayList<>())
                .bankAtms(new ArrayList<>())
                .employees(new ArrayList<>())
                .users(new ArrayList<>())
                .rating(new Random().nextInt(101))
                .money((double) Math.round(new Random().nextDouble(100000000)*100)/100)
                //.money((double) Math.round(new Random().nextDouble(1000000)*100)/100)
                .build();
        bank.setInterestRate(((double) Math.round(Math.max(0, Math.min(20, new Random().nextDouble(20) + (double) bank.getRating() / 10)) * 100) /100));
        return bank;
    }

    @Override
    public Bank getBank(long id) {
        return null;
    }

    @Override
    public void updateBank(long id) {

    }

    @Override
    public void deleteBank(long id) {

    }
}
