//На будущее: смысл передавать кол-во банкоматов, если их можно создать отдельно и
//сказать, где и в каком банке будут. Может легко возникнуть путаница из-за того,
//как сделано сейчас
package Yatsko.bank.service.impl;

import Yatsko.bank.entity.Bank;
import Yatsko.bank.entity.BankOffice;
import Yatsko.bank.service.BankOfficeService;
public class BankOfficeServiceImpl implements BankOfficeService {
    /**
     *
     * @param id            id of the office
     * @param name          name of the office
     * @param address       address of the office
     * @param status        status of the office (work/not work)
     * @param placeAtm      can to place an ATM in the office (yes/no)
     * @param countAtm      number of ATMs in the office (directly depends on the total number
     *                      <br> of ATMs at the bank)
     * @param getCredit     can to apply for a credit in the office (yes/no)
     * @param getMoney      can get money in the office (yes/no)
     * @param giveMoney     can give money in the office (yes/no)
     * @param money         the money in the office (directly depends on the "money" field
     *                      <br> in the "Bank" class)
     * @param rent          the money needed to rent of office
     * @param bank          the bank that owns the office
     * @return              {@link BankOffice}
     */
    @Override
    public BankOffice createBankOffice(long id, String name, String address,
                                       boolean status, boolean placeAtm, int countAtm,
                                       boolean getCredit, boolean getMoney, boolean giveMoney,
                                       double money, double rent, Bank bank) {
        BankOffice bankOffice = BankOffice.builder()
                .id(id)
                .name(name)
                .address(address)
                .status(status)
                .placeAtm(placeAtm)
                .canIssueCredit(getCredit)
                .canAcceptMoney(getMoney)
                .canGiveMoney(giveMoney)
                .rentCost(rent)
                .build();
        return bankOffice;
    }

    @Override
    public BankOffice getBankOffice(long id) {
        return null;
    }

    @Override
    public void updateBankOffice(long id) {

    }

    @Override
    public void deleteBankOffice(long id) {

    }
}
