package Yatskol.bank.utils;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.BankAtm;
import Yatskol.bank.entity.BankOffice;
import Yatskol.bank.entity.Employee;
import Yatskol.bank.entity.User;
import Yatskol.bank.entity.PaymentAccount;
import Yatskol.bank.exeptions.OfficeException;
import Yatskol.bank.exeptions.BankException;
import Yatskol.bank.exeptions.EmployeeException;
import Yatskol.bank.exeptions.PaymentAccountException;
import Yatskol.bank.exeptions.UserRatingException;

import java.util.List;

public class GetCreditForUser {
    public Bank pickBank(List<Bank> banks) throws BankException {
        if (banks.isEmpty()) {
            throw new BankException();
        }
        return banks.stream().max((bank1, bank2) -> {
                    double sum1 = bank1.getBankOffices().size() + bank1.getBankAtms().size() + bank1.getEmployees().size() + bank1.getInterestRate();
                    double sum2 = bank2.getBankOffices().size() + bank2.getBankAtms().size() + bank2.getEmployees().size() + bank1.getInterestRate();
                    if (sum1 != sum2) return Double.compare(sum1, sum2);
                    return 0;
                }).orElseThrow(BankException::new);
    }

    public BankOffice pickBankOffice(Bank bank, double sumRequested) throws OfficeException {
        List<BankOffice> bankOffices = bank.getBankOffices();
        return bankOffices.stream().filter(BankOffice::isStatus).filter(BankOffice::isCanIssueCredit)
                .filter(bankOffice -> bankOffice.getMoney() > sumRequested).filter(bankOffice -> {
                    List<BankAtm> atmsInOffice = bank.getBankAtms().stream().filter(atm -> atm.getBelongOffice().getId() == bankOffice.getId()).toList();
                    return atmsInOffice.stream().anyMatch(atm -> "Working".equals(atm.getStatus()) && atm.isCanGiveMoney() && atm.getMoney() > sumRequested);
                }).findFirst().orElseThrow(OfficeException::new);
    }

    public Employee pickEmployee(List<Employee> employees) throws EmployeeException {
        return employees.stream().filter(Employee::isCanGiveCredit).findFirst().orElseThrow(EmployeeException::new);
    }

    public boolean pickRating(double creditRatingOfUser, double ratingOfBank) {
        if (creditRatingOfUser < 500 && ratingOfBank > 50) {
            throw new UserRatingException();
        }

        return true;
    }
    public boolean pickPaymentAccount(Bank bank, User user) throws PaymentAccountException {
        List<PaymentAccount> paymentAccountList = user.getPaymentAccounts();
        List<PaymentAccount> paymentAccountsOfBanks = paymentAccountList.stream().filter(paymentAccount -> paymentAccount.getBankName().equals(bank.getName())).toList();
        if (paymentAccountsOfBanks.isEmpty()) {
            throw new PaymentAccountException();
        }

        return true;
    }
}