package Ex;

public class L_6 {

    /*
    Exercițiul 1
    Securizați aplicația existentă astfel încât să nu raporteze o eroare.
     */
    private static int calculate(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("/"))
            return a / b;
        if (op.equals("*"))
            return a * b;
        return 0;
    }

    public static void main(String[] args) {
        try {
            int x = calculate(5, 0, "/");
            System.out.println(x);
        } catch (Exception ex) {
            System.out.println("Operatie imposibila");
        }

        System.out.println("\n");
        /*
        Exercițiul 2
        Avem clasa User2:
        Creați o clasă de excepții pentru ID, nume, prenume și e-mail incorect.
        Trebuie să implementați un sistem de verificare în constructorul clasei
        User, astfel încât, dacă ID-ul este mai mare decât 100, să fie afișat
        mesajul InvalidIdException, iar dacă sunt goale câmpurile firstName,
        lastName și E-mail, să fie afișate mesajele InvalidFirstNameException,
        InvalidLastNameException sau InvalidEmailException.
        Instanțiați această clasă în proiectul Main.
         */
        try {
            User2 user2 = new User2(10, "", "Petrovic", "petrov@mail.mm");
        } catch (InvalidIdException ex) {
            System.out.println("ID incorect");
        } catch (InvalidFirstNameException ex) {
            System.out.println("Nume incorect");
        } catch (InvalidLastNameException ex) {
            System.out.println("Prenume incorect");
        } catch (InvalidEmailException ex) {
            System.out.println("E-mail incorect");
        }

/////////////////////end
    }
}




