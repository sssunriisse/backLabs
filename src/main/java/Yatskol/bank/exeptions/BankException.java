package Yatskol.bank.exeptions;

public class BankException extends RuntimeException{
    public BankException() {
        super("Не найден ни один банк");
    }
}
