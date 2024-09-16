package Yatskol.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder

public class Employee {
    private long id;
    private String name;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String post;
    private Bank bankPost;
    private boolean isWorkingDistantly;
    private BankOffice belongOffice;
    private boolean canGiveCredit;
    private double salary;

    @Override
    public String toString()
    {
        return "Id сотрудника: " + id
                + "\nИмя сотрудника: " + name
                + "\nФамилия сотрудника: " + lastName
                + "\nОтчество сотрудника: " + middleName
                + "\nДата рождения: " + dateOfBirth
                + "\nДолжность: " + post
                + "\nБанк, в котором работает (id): " + bankPost.getId()
                + "\nРаботает дистанционно: " + isWorkingDistantly
                + "\nОфис, в котором работает (id): " + belongOffice.getId()
                + "\nМожет выдать кредит: " + canGiveCredit
                + "\nЗарплата: " + salary;
    }
}
