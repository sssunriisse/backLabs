package Yatskol.bank.exeptions;

public class EmployeeException extends RuntimeException {
    public EmployeeException() {
        super("Ни один сотрудник не может выдавать кредиты");
    }
}