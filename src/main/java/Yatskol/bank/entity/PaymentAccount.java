package Yatskol.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PaymentAccount {
    private long id;
    private User user;
    private String bankName;
    private double money;

    @Override
    public String toString()
    {
        return "Id платёжного аккаунта: " + id
                + "\nId клиента: " + user.getId()
                + "\nНазвание банка: " + bankName
                + "\nКол-во денег: " + money;
    }
}
