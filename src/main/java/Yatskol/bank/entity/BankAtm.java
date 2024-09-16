package Yatskol.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankAtm {
    private long id;
    private String name;
    private String address;
    private String status;
    private Bank belongBank;
    private BankOffice belongOffice;
    private Employee serviceEmployee;
    private boolean canAcceptMoney;
    private boolean canGiveMoney;
    private double money;
    private double costForMaintenance;

    @Override
    public String toString()
    {
        return "Id банкомата: " + id
                + "\nНазвание банкомата: " + name
                + "\nАдрес банкомата: " + address
                + "\nСтатус: " + status
                + "\nБанк, которому принадлежит (id): " + belongBank.getId()
                + "\nОфис, которому принадлежит (id): " + belongOffice.getId()
                + "\nОтветственный сотрудник (id): " + serviceEmployee.getId()
                + "\nМожет принять деньги: " + canAcceptMoney
                + "\nМожет выдать деньги: " + canGiveMoney
                + "\nКол-во денег: " + money
                + "\nСодержание банкомата: " + costForMaintenance;
    }
}
