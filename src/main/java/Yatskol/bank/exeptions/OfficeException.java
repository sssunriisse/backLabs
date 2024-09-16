package Yatskol.bank.exeptions;

public class OfficeException extends RuntimeException {
    public OfficeException() {
        super("Ни один офис не может выдать кредит");
    }
}