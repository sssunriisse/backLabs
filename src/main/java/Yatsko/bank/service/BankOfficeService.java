package Yatsko.bank.service;

import Yatsko.bank.entity.Bank;
import Yatsko.bank.entity.BankOffice;

public interface BankOfficeService {
    /**
     * Create bank office.
     *
     * @param id            id of the office
     * @param name          name of the office
     * @param address       address of the office
     * @param status        status of the office
     * @param placeAtm      can to place an ATM in the office
     * @param countAtm      number of ATMs in the office
     * @param getCredit     can to apply for a credit in the office
     * @param getMoney      can get money in the office
     * @param giveMoney     can give money in the office
     * @param money         the money in the office
     * @param rent          the money needed to rent of office
     * @param bank          the bank that owns the office
     * @return              return an object of the BankOffice class
     */
    BankOffice createBankOffice(long id, String name, String address, boolean status, boolean placeAtm,
                                int countAtm, boolean getCredit, boolean getMoney, boolean giveMoney,
                                double money, double rent, Bank bank);

    /**
     * Get bank office by id.
     *
     * @param id            id of the office
     * @return              return an object of the BankOffice class
     */
    BankOffice getBankOffice(long id);

    /**
     * Update bank office by id.
     *
     * @param id            id of the office
     */
    void updateBankOffice(long id);

    /**
     * Delete bank office by id.
     *
     * @param id            id of the office
     */
    void deleteBankOffice(long id);
}
