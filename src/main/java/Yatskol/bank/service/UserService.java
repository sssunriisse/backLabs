package Yatskol.bank.service;

import Yatskol.bank.entity.Bank;
import Yatskol.bank.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    /**
     *
     * @param id            id of the user
     * @param name          name of the user
     * @param lastName      last name of the user
     * @param middleName    middle name of the user
     * @param dateOfBirth   user's date of birth
     * @param placeOfWork   user's place of work
     * @param banks         banks that a user uses
     * @return              return an object of the User class
     */
    User createUser(long id, String name, String lastName, String middleName, LocalDate dateOfBirth,
                    String placeOfWork, List<Bank> banks);

    /**
     * Get user by id.
     *
     * @param id            id of the user
     * @return              return an object of the User class
     */
    User getUser(long id);

    /**
     * Update user by id.
     *
     * @param id            id of the user
     */
    void updateUser(long id);

    /**
     * Delete user by id.
     *
     * @param id
     */
    void deleteUser(long id);
}
