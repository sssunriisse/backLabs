package Yatskol.bank.service;

import Yatskol.bank.entity.Bank;

public interface BankService {
    /**
     * Create bank.
     *
     * @param id        id of the bank
     * @param name      id of the name
     * @return          return an object of the Bank class
     */
    Bank createBank(long id, String name);

    /**
     * Get bank by id.
     *
     * @param id        id of the bank
     * @return          return an object of the Bank class
     */
    Bank getBank(long id);

    /**
     * Update bank by id.
     *
     * @param id        id of the bank
     */
    void updateBank(long id);

    /**
     * Delete bank by id.
     *
     * @param id        id of the bank
     */
    void deleteBank(long id);
}
