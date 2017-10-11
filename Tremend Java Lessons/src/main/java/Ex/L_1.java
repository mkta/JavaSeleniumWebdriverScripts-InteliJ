package Ex;

public class L_1 {

    public static void main(String[] args) {

        // 1.1
        /*
        Întâi vom crea programul. Acest program va fi asemănător cu
        programul din exemplul precedent:
        public class Add
        {
        public static void main(String[] args)
        {
        //metoda println()tipăreşte întregul număr la ieşire şi trece în rând nou
        System.out.println(2+3);
         */
        System.out.println(5 + 3);

        System.out.println("Geani test");

        //1.3
        //ex 1
        System.out.println("\n");
        /* cerinta
       Exercițiul 1
       Se dă următorul cod care adună două numere:
       int operand1=2;
       int operand2=3;
       int sum=operand1+operand2;
       System.out.println(sum);
       Trebuie să facem o descriere a codului pentru documentație. */


        //primul sumator
        int operand1 = 2;

        //al doilea sumator
        int operand2 = 3;

        //calculul adunării
        int sum = operand1 + operand2;

        //scrierea rezultatului
        System.out.println("Rezultat ex 1: " + sum);

        //Ex 2
        System.out.println("\n");
        /*
        Se dă codul următor:
        int a=2,b=3;
        System.out.print("First operand: ");
        System.out.println(a);
        System.out.print("Second operand: ");
        System.out.println(b);
        System.out.print("Sum: ");
        System.out.println(a+b);

        Codul dă următoarea ieşire:
        First operand: 2
        Second operand: 3
        Sum: 5
        Trebuie să ne asigurăm că la ieşire codul afişează doar rezultatul
        (numărul 5) şi că toate liniile de cod rămân disponibile pentru o
        utilizare viitoare.
         */

        int a = 2, b = 3;

        /*System.out.print("First operand: ");

        System.out.println(a);

        System.out.print("Second operand: ");

        System.out.println(b);

        System.out.print("Sum: ");*/

        System.out.println("Rezultat ex 2: " + a + b);


        ///end
    }
}
