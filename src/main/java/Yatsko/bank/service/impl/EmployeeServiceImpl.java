package Yatsko.bank.service.impl;

import Yatsko.bank.entity.Bank;
import Yatsko.bank.entity.BankOffice;
import Yatsko.bank.entity.Employee;
import Yatsko.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    /**
     *
     * @param id            id of the employee
     * @param name          name of the employee
     * @param lastName      last name of the employee
     * @param middleName    middle name of the employee
     * @param dateOfBirth   employee's date of birth
     * @param post          employee's post
     * @param bankPost      which bank does employee work
     * @param distantly     does employee work distantly (yes/no)
     * @param officeWork    which office does employee work
     * @param giveCredit    can an employee issue a loan (yes/no)
     * @param salary        employee's salary
     * @return              {@link Employee}
     */
    @Override
    public Employee createEmployee(long id, String name, String lastName,
                                   String middleName, LocalDate dateOfBirth,
                                   String post, Bank bankPost, boolean distantly,
                                   BankOffice officeWork, boolean giveCredit,
                                   double salary) {
        Employee employee = Employee.builder()
                .id(id)
                .name(name)
                .lastName(lastName)
                .middleName(middleName)
                .dateOfBirth(dateOfBirth)
                .post(post)
                .bankPost(bankPost)
                .isWorkingDistantly(distantly)
                .belongOffice(officeWork)
                .canGiveCredit(giveCredit)
                .salary(salary)
                .build();
        return employee;
    }

    @Override
    public Employee getEmployee(long id) {
        return null;
    }

    @Override
    public void updateEmployee(long id) {

    }

    @Override
    public void deleteEmployee(long id) {

    }
}
