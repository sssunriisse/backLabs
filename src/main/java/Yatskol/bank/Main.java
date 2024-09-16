package Yatskol.bank;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.BankOffice;
import Yatskol.bank.entity.Employee;
import Yatskol.bank.exeptions.PaymentAccountException;
import Yatskol.bank.exeptions.UserRatingException;
import Yatskol.bank.utils.BankContentGenerator;
import Yatskol.bank.utils.GetCreditForUser;
import Yatskol.bank.entity.User;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankContentGenerator generator = new BankContentGenerator();
        generator.generateBanks();
        generator.generateOffices();
        generator.generateEmployees();
        generator.generateATMs();
        generator.generateUsers();
        generator.paymentAccount();
        generator.creditAccount();

        int number = 0;
        System.out.println("\nВывод клиентов...\n************************");
        generator.viewAllUsers();
        System.out.print("\nВведите номер клиента для начала оформления кредита: ");
        number = scanner.nextInt();
        User user = generator.getUser(number);

        generator.viewBanks();
        System.out.println("Выберите желаемый банк: ");
        int choseBank = scanner.nextInt();
        GetCreditForUser getCreditForUser = new GetCreditForUser();
        Bank bank = generator.getBank(choseBank);
        System.out.println("************************\nВведите сумму кредита: ");
        long creditSum = scanner.nextInt();
        BankOffice bankOffice = getCreditForUser.pickBankOffice(bank, creditSum);
        Employee employee = getCreditForUser.pickEmployee(bank.getEmployees().stream()
                .filter(Employee -> Employee.getBelongOffice().getId() == bankOffice.getId()).collect(Collectors.toList()));
        try {
            getCreditForUser.pickPaymentAccount(bank, user);

        } catch (PaymentAccountException e) {
            generator.addPaymentAccount(bank, user);
            System.out.println("Был создан новый счёт для клиента");
        }
        try {
            getCreditForUser.pickRating(user.getRating(), bank.getRating());
            generator.addCreditAccount(bank, user, employee, user.getPaymentAccounts().getLast(), creditSum);
            System.out.println("Кредит был создан");
        } catch (UserRatingException e) {
            System.out.println("У пользователя недостаточный рейтинг для получения кредита");
        }
    }

}
//.stream()
//        .filter(employee -> employee.getBelongOffice().getId() == office.getId())
//        .collect(Collectors.toList());