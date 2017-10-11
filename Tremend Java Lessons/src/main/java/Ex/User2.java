package Ex;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class User2 {

    public int id;
    public String firstName;
    public String lastName;
    public String email;

    public User2(int id, String firstName, String lastName, String email)
            throws InvalidIdException, InvalidFirstNameException,
            InvalidLastNameException, InvalidEmailException {

        if (id > 100) {
            throw new InvalidIdException();
        } else {
            this.id = id;
        }

        if (firstName.equals("")) {
            throw new InvalidFirstNameException();
        } else {
            this.firstName = firstName;
        }

        if (lastName.equals("")) {
            throw new InvalidLastNameException();
        } else {
            this.lastName = lastName;
        }

        if (email.equals("")) {
            throw new InvalidEmailException();
        } else {
            this.email = email;
        }
    }
}


