package Yatskol.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class User {
    private long id;
    private String name;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String placeOfWork;
    private double monthlyProfit;
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;
    private double rating;

    @Override
    public String toString()
    {
        return "Id клиента: " + id
                + "\nИмя клиента: " + name
                + "\nФамилия клиента: " + lastName
                + "\nОтчество клиента: " + middleName
                + "\nДата рождения клиента: " + dateOfBirth
                + "\nМесто работы клиента: " + placeOfWork
                + "\nПрибыль клиента: " + monthlyProfit
                + "\nКредитный рейтинг: " + rating;
    }

    private <T> String getIdFromList(List<T> list)
    {
        String stringOfId = "";
        if (list == null)
        {
            stringOfId = "Клиент пока не пользовался этим";
            return stringOfId;
        }
        for (T object: list)
        {
            if (object instanceof Bank || object instanceof CreditAccount || object instanceof PaymentAccount)
            {
                stringOfId += String.valueOf(((Bank)object).getId());
                stringOfId += " ";
            }
        }
        return stringOfId;
    }
}
