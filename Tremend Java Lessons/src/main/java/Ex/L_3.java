package Ex;

import java.util.Arrays;

public class L_3 {

    public static void main(String[] args) {
        /*
        Exerciţiul 1

        Este necesară următoarea construcție logică: dacă x primește o
        valoare mai mare decât zero, se intră în blocul de cod și x este egal cu 3.
         */

        int x = 0;
        if (x > 0) {
            x = 3;
        }


        /*
        Trebuie modificat codul următor pentru a fi scris corect:
        if(x=y)
        {
        //logic goes here
        }
        else if(x=0);
        {
        //logic goes here
        }
        else(x)
        {
        //logic goes here
         */
        int y = 1;
        if (x == y) {
            //logic goes here
        } else if (x == 0) {
            //logic goes here
        } else {
            //logic goes here
        }


        /*
        Exerciţiul 1
        În program, intră următoarele date:
        //input data
        int x = 523134;
        int y = 325423;
        Trebuie să verificăm restul împărţirii dintre x şi y. Dacă nu există rest,
        trebuie să se afişeze mesajul că restul nu există, în caz contrar, trebuie
        să se verifice dacă restul este mai mare sau mai mic decât o mie şi să
        se afişeze mesajul corespunzător.
         */
        //input data
        int a = 523134;
        int b = 325423;
        int rest = a % b;
        switch (rest) {
            case 0:
                System.out.println("no rest");
                break;
            default:
                if (rest > 1000)
                    System.out.println("Rest > 100");
                else
                    System.out.println("Rest < 100");
                break;
        }

        /*Exerciţiul 2
        Avem următoarele date de intrare pentru un automobil:
        String carMake = "Ford";
        int doors = 4;
        Trebuie să se facă o structură condițională care va verifica dacă
        producătorul automobilului este Ford și, dacă este, în funcție de
        numărul de uși, să afișeze mesajul adecvat.*/

        String carMake = "Ford";
        int doors = 4;

        if (carMake == "Ford") {
            switch (doors) {
                case 0:
                    System.out.println("0 doors");
                    break;
                case 1:
                    System.out.println("1 doors");
                    break;
                case 2:
                    System.out.println("2 doors");
                    break;
                case 3:
                    System.out.println("3 doors");
                    break;
                case 4:
                    System.out.println("4 doors");
                    break;
            }
        } else {
            System.out.println("No Ford");
        }


        /*
        Exerciţiul 1
        Avem şirul următor:
        int[] arr = {1,2,-1,4,5,-1};
        Cu ajutorul buclei for, trebuie să copiem acest şir în şirul arr1, unde
        toţi membrii cu valoarea -1 trebuie înlocuiţi de membrii cu valoarea
        zero. Arr1 trebuie afişat apoi la ieşire.
         */

        int[] arr = {1, 2, -1, 4, 5, -1};
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                arr1[i] = 0;
            } else {
                arr1[i] = arr[i];
            }
        }
        System.out.println("new array: " + Arrays.toString(arr1));

        /*
        String[][] users = { { "petar" , "petrovic" , "1111" },
        {"jovan","jovanovic","2222"} , {"zoran","ivanovic","3333"}
               };
        Trebuie să separăm numele utilizatorilor şi să le stocăm într-un şir
        separat. Acest şir trebuie emis la ieşire.
         */
        String[][] users = {{"petar", "petrovic", "1111"},

                {"jovan", "jovanovic", "2222"}, {"zoran", "ivanovic", "3333"}};

        String[] usersNames = new String[users.length];

        for (int userNumber = 0; userNumber < users.length; userNumber++) {

            usersNames[userNumber] = users[userNumber][0] + " " + users[userNumber][1];
        }

        System.out.println("Names array: " + Arrays.toString(usersNames));

        /*
        Exerciţiul 1
        Este dat următorul şir de numere:
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Trebuie să listăm şirul dat folosind bucla while.
                */
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2N = 0;
        while (arr2N < arr2.length) {
            System.out.println("arr2 value: " + arr2[arr2N]);
            arr2N++;
        }

        /*
        Exerciţiul 2
        Modificați codul din exerciţiul precedent pentru a se executa folosind
        bucla do-while.
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 0;
         */
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x3 = 0;

        do {
            System.out.println("arr3 do value: " + arr3[x3]);
            x3++;
        }
        while (x3 < arr3.length);


////////////end
    }
}
