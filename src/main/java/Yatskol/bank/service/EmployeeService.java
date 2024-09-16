package Yatskol.bank.service;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.BankOffice;
import Yatskol.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    /**
     *
     * @param id            id of the employee
     * @param name          name of the employee
     * @param lastName      last name of the employee
     * @param middleName    middle name of the employee
     * @param dateOfBirth   employee's date of birth
     * @param post          employee's post
     * @param bankPost      which bank does employee work
     * @param distantly     does employee work distantly
     * @param officeWork    which office does employee work
     * @param giveCredit    can an employee issue a loan
     * @param salary        employee's salary
     * @return              return an object of the Employee class
     */
    Employee createEmployee(long id, String name, String lastName, String middleName,
                            LocalDate dateOfBirth, String post, Bank bankPost,
                            boolean distantly, BankOffice officeWork, boolean giveCredit,
                            double salary);

    /**
     * Get employee by id.
     *
     * @param id            id of the employee
     * @return              return an object of the Employee class
     */
    Employee getEmployee(long id);

    /**
     * Update employee by id.
     *
     * @param id            id of the employee
     */
    void updateEmployee(long id);

    /**
     * Delete bank office by id.
     *
     * @param id            id of the employee
     */
    void deleteEmployee(long id);
}
