package Yatskol.bank.utils;

import Yatskol.bank.entity.*;
import Yatskol.bank.service.*;
import Yatskol.bank.service.impl.*;
import tech.reliab.course.kovaleval.bank.entity.*;
import tech.reliab.course.kovaleval.bank.service.*;
import tech.reliab.course.kovaleval.bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BankContentGenerator {
    private static final BankService bankService = new BankServiceImpl();
    private static final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final BankAtmService bankAtmService = new BankAtmServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private static final CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    private static final List<Bank> banks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    List<User> usersList = new ArrayList<>();

    public List<Bank> generateBanks() {
        String[] bankNames = {"Совкомбанк", "Банк Русский Стандарт", "ТарБанк", "Ренессанс Банк", "Wildberries Банк"};
        for (int i = 0; i < 5; i++) banks.add(bankService.createBank(i, bankNames[i]));
        return banks;
    }

    public void generateOffices() {
        int idCounter = 1;
        String[] officeAddresses = {"Белгород", "Москва", "Краснодон"};
        for (Bank bank : banks) {
            for (int i = 0; i < 3; i++) {
                bank.getBankOffices().add(bankOfficeService.createBankOffice(idCounter++, "Office" + i, officeAddresses[i], true,
                        true, 0, true, true, true, 50000, 50, bank));
            }
        }
    }

    public void generateEmployees() {
        int idCounter = 1;
        for (Bank bank : banks) {
            for (BankOffice bankOffice : bank.getBankOffices()) {
                for (int i = 0; i < 5; i++) {
                    bank.getEmployees().add(employeeService.createEmployee(idCounter++, "Name", "Lastname", "Middlename",
                            LocalDate.of(2004, 1, 1), "Employee", bank, false, bankOffice, true, 100));
                }
            }
        }
    }

    public void generateATMs() {
        int idCounter = 1;
        for (Bank bank : banks) {
            for (int i = 0; i < 3; i++) {
                bank.getBankAtms().add(bankAtmService.createBankAtm(idCounter++, "Atm" + i, "Working", bank,
                        getRandomOfficeOfBank(bank), getRandomEmployeeOfBank(bank),
                        true, true, 50000, 10));
            }
        }
    }

    public void generateUsers() {
        String[] userNames = {"Александр", "Иван", "Дмитрий", "Андрей", "Денис"};
        String[] userLastNames = {"Иванов", "Петров", "Смирнов", "Козлов", "Морозов"};
        String[] userMiddleNames = {"Александрович", "Иванович", "Дмитриевич", "Сергеевич", "Петрович"};
        String[] userPlaceOfWork = {"Газпром", "Теле2", "Лукойл", "Яндекс", "Магнит", "Роснефть", "Группа АФК \"Система\"", "Аэрофлот", "X5 Retail Group"};
        int idCounter = 1;
        for (Bank bank : banks) {
            for (int i = 0; i < 5; i++) {
                bank.getUsers().add(userService.createUser(idCounter++, userNames[new Random().nextInt(4)],
                        userLastNames[new Random().nextInt(4)], userMiddleNames[new Random().nextInt(4)],
                        LocalDate.of(2005, 1, 1), userPlaceOfWork[new Random().nextInt(8)], List.of(bank)));
            }
        }
    }

    public void paymentAccount() {
        int idCounter = 1;
        for (Bank bank : banks) {
            for (User user : bank.getUsers()) {
                for (int i = 0; i < 2; i++) {
                    user.getPaymentAccounts().add(paymentAccountService.createPaymentAccount(idCounter++, user, bank));
                }
            }
        }
    }

    public void creditAccount() {
        int idCounter = 1;
        for (Bank bank : banks) {
            for (User user : bank.getUsers()) {
                for (int i = 0; i < 2; i++) {
                    user.getCreditAccounts().add(creditAccountService.createCreditAccount(idCounter++, user,
                            LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1),
                            12, 120, 10, getRandomEmployeeOfBank(bank), getRandomPaymentAccount(user), bank));
                }
            }
        }
    }


    private PaymentAccount getRandomPaymentAccount(User user) {
        Random random = new Random();
        return user.getPaymentAccounts().get(random.nextInt(user.getPaymentAccounts().size()));
    }

    private BankOffice getRandomOfficeOfBank(Bank bank) {
        Random random = new Random();
        return bank.getBankOffices().get(random.nextInt(bank.getBankOffices().size()));
    }

    private Employee getRandomEmployeeOfBank(Bank bank) {
        Random random = new Random();
        return bank.getEmployees().get(random.nextInt(bank.getEmployees().size()));
    }

    public void openMenu() {
        System.out.println("\nВыберите один из пунктов меню:");
        System.out.println("1. Вывод существующих банков");
        System.out.println("2. Вывод существующих клиентов");
        System.out.println("3. Закрыть приложение");
        System.out.print("Ваш выбор: ");
    }

    private void openBankMenu() {
        System.out.println("Для вывода доступно:");
        System.out.println("1. Банкоматы данного банка");
        System.out.println("2. Офисы данного банка");
        System.out.println("3. Сотрудники данного банка");
        System.out.println("4. Клиенты данного банка");
        System.out.print("Ваш выбор: ");
    }

    private void openUserMenu() {
        System.out.println("Для вывода доступно:");
        System.out.println("1. Кредитные аккаунты данного клиента");
        System.out.println("2. Платёжные аккаунты данного клиента");
        System.out.print("Ваш выбор: ");
    }

    public void viewBanks() {
        int idCounter = 1;
        for (Bank bank : banks) {
            System.out.println(idCounter++ + ". " + bank.getName() + ", рейтинг банка: " + bank.getRating());
        }
        System.out.println("************************");
    }

    public Bank getBank(int number)
    {
        return banks.get(number - 1);
    }

    public void viewBank(int number) {
        Bank bank = banks.get(number - 1);
        System.out.println(bank.toString());
        System.out.println("************************\n");
        openBankMenu();
        number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("\nВывод банкоматов...\n************************");
                viewATMs(bank);
                break;
            case 2:
                System.out.println("\nВывод офисов...\n************************");
                viewOffices(bank);
                break;
            case 3:
                System.out.println("\nВывод сотрудников...\n************************");
                viewEmployees(bank);
                break;
            case 4:
                System.out.println("\nВывод пользователей...\n************************");
                viewUsers(bank);
                break;
            default:
                break;
        }
    }

    public void viewAllUsers() {
        int idCounter = 1;
        for (Bank bank : banks) {
            for (User user : bank.getUsers()) {
                System.out.println(idCounter++ + ". " + user.getName() + ' ' + user.getLastName()
                        + ' ' + user.getMiddleName() + ", банк " + bank.getName());
                usersList.add(user);
            }
        }
        System.out.println("************************");
    }

    public void viewUserFromAll(int number) {
        User user = usersList.get(number - 1);
        System.out.println(user.toString());
        System.out.println("************************\n");
        openUserMenu();
        number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("\nВывод кредитных аккаунтов...\n************************");
                viewCreditAccounts(user);
                break;
            case 2:
                System.out.println("\nВывод платёжных аккаунтов...\n************************");
                viewPaymentAccounts(user);
                break;
            default:
                break;
        }
    }
    public User getUser(int number) {
        User user = usersList.get(number - 1);
        return user;
    }

    private void viewATMs(Bank bank) {
        int idCounter = 1;
        for (BankAtm bankAtm : bank.getBankAtms()) {
            System.out.println(idCounter++ + ". " + bankAtm.getName() + ", адрес - " + bankAtm.getAddress());
        }
        System.out.println("************************");
        System.out.print("\nВыберите банкомат для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<BankAtm> atms = bank.getBankAtms();
        viewATM(atms.get(number));
    }

    private void viewATM(BankAtm bankAtm) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(bankAtm.toString());
        System.out.println("\n************************\n");
    }

    private void viewOffices(Bank bank) {
        int idCounter = 1;
        for (BankOffice bankOffice : bank.getBankOffices()) {
            System.out.println(idCounter++ + ". " + bankOffice.getName() + ", адрес - " + bankOffice.getAddress());
        }
        System.out.println("************************");
        System.out.print("\nВыберите офис для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<BankOffice> offices = bank.getBankOffices();
        viewOffice(offices.get(number));
    }

    private void viewOffice(BankOffice bankOffice) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(bankOffice.toString());
        System.out.println("\n************************\n");
    }

    private void viewEmployees(Bank bank) {
        int idCounter = 1;
        for (Employee employee : bank.getEmployees()) {
            System.out.println(idCounter++ + ". " + employee.getName() + ' ' + employee.getLastName()
                    + ' ' + employee.getMiddleName() + ", должность: " + employee.getPost());
        }
        System.out.println("************************");
        System.out.print("\nВыберите сотрудника для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<Employee> employees = bank.getEmployees();
        viewEmployee(employees.get(number));
    }

    private void viewEmployee(Employee employee) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(employee.toString());
        System.out.println("\n************************\n");
    }

    private void viewUsers(Bank bank) {
        int idCounter = 1;
        for (User user : bank.getUsers()) {
            System.out.println(idCounter++ + ". " + user.getName() + ' ' + user.getLastName()
                    + ' ' + user.getMiddleName() + ", кредитный рейтинг: " + user.getRating());
        }
        System.out.println("************************");
        System.out.print("\nВыберите клиента для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<User> users = bank.getUsers();
        viewUser(users.get(number));
    }

    private void viewUser(User user) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(user.toString());
        System.out.println("\n************************\n");
    }

    private void viewCreditAccounts(User user) {
        int idCounter = 1;
        for (CreditAccount creditAccount : user.getCreditAccounts()) {
            System.out.println(idCounter++ + ". Сумма - " + creditAccount.getLoanAmount() +
                    ", количество месяцев - " + creditAccount.getCountMoth());
        }
        System.out.println("************************");
        System.out.print("\nВыберите кредитный аккаунт для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<CreditAccount> creditAccounts = user.getCreditAccounts();
        viewCreditAccount(creditAccounts.get(number));
    }

    private void viewCreditAccount(CreditAccount creditAccount) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(creditAccount.toString());
        System.out.println("\n************************\n");
    }

    private void viewPaymentAccounts(User user) {
        int idCounter = 1;
        for (PaymentAccount paymentAccount : user.getPaymentAccounts()) {
            System.out.println(idCounter++ + ". Сумма - " + paymentAccount.getMoney());
        }
        System.out.println("************************");
        System.out.print("\nВыберите платёжный аккаунт для вывода подробной информации: ");
        int number = scanner.nextInt();
        number--;
        List<PaymentAccount> paymentAccounts = user.getPaymentAccounts();
        viewPaymentAccount(paymentAccounts.get(number));
    }

    private void viewPaymentAccount(PaymentAccount paymentAccount) {
        System.out.println("\nВывод информации...");
        System.out.println("************************\n");
        System.out.print(paymentAccount.toString());
        System.out.println("\n************************\n");
    }

    public PaymentAccount addPaymentAccount(Bank bank, User user) {
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount((user.getPaymentAccounts().size())+1, user, bank);
        user.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
    }

    public CreditAccount addCreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount, long requestedSum) {
        CreditAccount creditAccount = creditAccountService.createCreditAccount((user.getCreditAccounts().size())+1, user, LocalDate.of(2024, 1, 1),
                LocalDate.of(2025, 1, 1), 12, requestedSum, requestedSum/12, employee, paymentAccount, bank);
        user.getCreditAccounts().add(creditAccount);
        return creditAccount;
    }

    public List<Bank> getBanks()
    {
        return banks;
    }
}