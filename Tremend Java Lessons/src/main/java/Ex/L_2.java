package Ex;

import java.util.Arrays;

public class L_2 {

    public static void main(String[] args) {

        //Ex1

        /*cerinta

        Exerciţiul 1

        Trebuie să păstrăm în program anii de muncă și salariul unui angajat.
        Sarcina dvs. este să declarați variabilele care se pot utiliza în acestscop.
         */

        int aniDeMunca;
        double salariu;

        /*Exerciţiul 2
        Trebuie să declarăm două variabile. O variabilă de tip double cu
        valoarea 15,757 și o variabilă întreagă de tip int. Trebuie să convertiți
        variabila cu virgulă mobilă într-o valoare întreagă.
        */

        double varDbl = 15.757;
        int varConv = (int) varDbl;
        System.out.println("Var converita " + varConv);



        /*
        Exercițiul 1
        Numele variabilelor trebuie schimbate astfel încât să fie corecte
        sintactic şi în acord cu convenţiile:
        String 1stUserName;
        int bdt; //date of birthday
        float o1; //first operand
         */
        String firstUserName;
        int birthDate;
        float firstOperand;

        /*
        Exercițiul 2
        Editaţi numele constantei:
        public static final short pageWidth = 800;
         */

        /*public static*/
        final short PAGE_WIDTH = 800;

        /*
        Exerciţiul 1:
        Unitate: Operatori
        Este necesar să creăm un program care adună două numere
        reprezentate prin două variabile. Primul număr este variabila x, cu
        valoarea 1, iar celălalt este variabila y, cu valoarea 2. Trebuie să
        atribuim variabilei z rezultatul adunării acestor două variabile.
         */

        //definire x
        int x = 1;
        //definire y
        int y = 2;
        //calcul z=x+y
        int z = x + y;
        //afisare z
        System.out.println("Valoare z = " + z);

        /*
        Exerciţiul 2
        Trebuie să creăm un program care calculează aria unui cerc.
         */

        //definire PI
        final double PI = 3.14;
        //definire raza
        double r = 15;
        //calcul arie PI*r^2
        double arie = PI * (r * r);
        //afisare arie
        System.out.println("Arie  = " + arie);


        /*
        Exerciţiul 1
        Trebuie creat un program care adună două matrice. Prima matrice are
        valoarea:
        1 2 3
        5 6 7
        9 0 1
        A doua matrice are valoarea:
        4 1 6
        2 3 5
        7 4 3
         */

        int[][] array1 = {{1, 2, 3}, {5, 6, 7}, {9, 0, 1}};
        int[][] array2 = {{4, 1, 6}, {2, 3, 5}, {7, 4, 3}};
        int[][] array3 = new int[3][3];

        array3[0][0] = array1[0][0] + array2[0][0];
        array3[0][1] = array1[0][2] + array2[0][1];
        array3[0][2] = array1[0][2] + array2[0][2];
        array3[1][0] = array1[1][0] + array2[1][0];
        array3[1][1] = array1[1][1] + array2[1][1];
        array3[1][2] = array1[1][2] + array2[1][2];
        array3[2][0] = array1[2][0] + array2[2][0];
        array3[2][1] = array1[2][1] + array2[2][1];
        array3[2][2] = array1[2][1] + array2[2][2];



        /*Exerciţiul 2
        Trebuie să creat un program care va sorta şirul dat şi la ieşire va da
        şirul vechi şi cel nou:
        int[] array = {1, 5, 33, 563, 0, 2, 23, 9, 9, 11, 987, 23,
        934, 999, 43};*/

        int[] array = {1, 5, 33, 563, 0, 2, 23, 9, 9, 11, 987, 23,
                934, 999, 43};
        System.out.println("Original array" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted array" + Arrays.toString(array));
        //end
    }
}