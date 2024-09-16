package Yatskol.bank.exeptions;

public class UserRatingException extends RuntimeException {
    public UserRatingException() {
        super("У пользователя недостаточный рейтинг для получения кредита");
    }
}
