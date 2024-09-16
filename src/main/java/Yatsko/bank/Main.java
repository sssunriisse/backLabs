package Yatsko.bank;

import Yatsko.bank.utils.BankContentGenerator;

import java.util.Scanner;

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

        while (true)
        {
            generator.openMenu();
            int count = scanner.nextInt();
            int number = 0;
            switch (count)
            {
                case 1: System.out.println("\nВывод банков...\n************************");
                        generator.viewBanks(); System.out.print("\nВведите номер банка для получения подробной информации: ");
                        number = scanner.nextInt(); System.out.println("\nВывод банка...\n************************");
                        generator.viewBank(number); break;
                case 2: System.out.println("\nВывод клиентов...\n************************");
                        generator.viewAllUsers(); System.out.print("\nВведите номер клиента для получения подробной информации: ");
                        number = scanner.nextInt(); System.out.println("\nВывод информации о клиенте...\n************************");
                        generator.viewUserFromAll(number); break;
                case 3: return;
                default: return;
            }
        }
    }

}
