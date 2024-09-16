package Yatsko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankOffice {
    private long id;
    private String name;
    private String address;
    private boolean status;
    private boolean placeAtm;
    private boolean canIssueCredit;
    private boolean canAcceptMoney;
    private boolean canGiveMoney;
    private double money;
    private double rentCost;

    @Override
    public String toString()
    {
        return "Id офиса: " + id
                + "\nНазвание офиса: " + name
                + "\nАдрес офиса: " + address
                + "\nСтатус: " + status
                + "\nМожно разместить банкомат: " + placeAtm
                + "\nМожет выдать кредит: " + canIssueCredit
                + "\nМожет положить деньги: " + canAcceptMoney
                + "\nМожет выдать деньги: " + canGiveMoney
                + "\nКол-во денег: " + money
                + "\nАренда: " + rentCost;
    }
}
