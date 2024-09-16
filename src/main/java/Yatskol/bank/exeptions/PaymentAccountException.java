package Yatskol.bank.exeptions;

public class PaymentAccountException extends RuntimeException {
    public PaymentAccountException() {
        super("В искомом банке не обнаружен счёт клиента");
    }
}