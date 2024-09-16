package Yatsko.bank.service.impl;

import Yatsko.bank.entity.Bank;
import Yatsko.bank.entity.BankAtm;
import Yatsko.bank.entity.BankOffice;
import Yatsko.bank.entity.Employee;
import Yatsko.bank.service.BankAtmService;

public class BankAtmServiceImpl implements BankAtmService {

    /**
     * Constructor for the BankAtm class
     *
     * @param id                id of the ATM
     * @param name              name of the ATM
     *                          <br> address (matches the address of the bank office)
     * @param status            status of the ATM (working/not working/no money)
     * @param belongBank        the bank that owns the ATM
     * @param belongOffice      the office that owns the ATM (an ATM can only be located in a bank office)
     * @param serviceEmployee   the employee servicing the ATM
     * @param getMoney          can an ATM issue money (yes/no)
     * @param giveMoney         can an ATM receive money (yes/no)
     * @param money             the money in the ATM (directly depends on the "money" field
     *                          <br> in the "Bank" class)
     * @param serviceMoney      the money needed to service the ATM
     * @return                  {@link BankAtm}
     */
    @Override
    public BankAtm createBankAtm(long id, String name, String status,
                                 Bank belongBank, BankOffice belongOffice,
                                 Employee serviceEmployee, boolean getMoney,
                                 boolean giveMoney, double money, double serviceMoney) {
        BankAtm bankAtm = BankAtm.builder()
                .id(id)
                .name(name)
                .belongBank(belongBank)
                .belongOffice(belongOffice)
                .serviceEmployee(serviceEmployee)
                .canAcceptMoney(getMoney)
                .canGiveMoney(giveMoney)
                .costForMaintenance(serviceMoney)
                .address(belongOffice.getAddress())
                .build();
        if (belongBank.getMoney() < money) throw new
                IllegalArgumentException("Такого количества денег нет в банке");
        else bankAtm.setMoney(money);
        if (!status.equals("Working") && !status.equals("Not working") && !status.equals("No money"))
            throw new IllegalArgumentException("Неверно указан статус");
        else bankAtm.setStatus(status);
        return bankAtm;
    }

    @Override
    public BankAtm getBankAtm(long id) {
        return null;
    }

    @Override
    public void updateBankAtm(long id) {

    }

    @Override
    public void deleteBankAtm(long id) {

    }
}
