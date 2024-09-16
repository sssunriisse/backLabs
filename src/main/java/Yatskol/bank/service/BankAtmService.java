package Yatskol.bank.service;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.BankAtm;
import Yatskol.bank.entity.BankOffice;
import Yatskol.bank.entity.Employee;

public interface BankAtmService {
    /**
     * Create bank ATM.
     *
     * @param id                id of the ATM
     * @param name              name of the ATM
     * @param status            status of the ATM
     * @param belongBank        the bank that owns the ATM
     * @param belongOffice      the office that owns the ATM
     * @param serviceEmployee   the employee servicing the ATM
     * @param getMoney          can an ATM issue money
     * @param giveMoney         can an ATM receive money
     * @param money             the money in the ATM
     * @param serviceMoney      the money needed to service the ATM
     * @return                  return an object of the BankAtm class
     */
    BankAtm createBankAtm(long id, String name, String status,
                          Bank belongBank, BankOffice belongOffice,
                          Employee serviceEmployee, boolean getMoney,
                          boolean giveMoney, double money, double serviceMoney);

    /**
     * Get bank ATM by id.
     *
     * @param id                id of the ATM
     * @return                  return an object of the BankAtm class
     */
    BankAtm getBankAtm(long id);

    /**
     * Update bank ATM by id.
     *
     * @param id                id of the ATM
     */
    void updateBankAtm(long id);

    /**
     * Delete bank ATM by id.
     *
     * @param id                id of the ATM
     */
    void deleteBankAtm(long id);
}
