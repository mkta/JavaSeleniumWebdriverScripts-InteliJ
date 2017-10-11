package Ex;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class L_5 {

    public static void main(String[] args) {

    /*
    Exercițiul 1
    În aplicație intră o secvență de stringuri. Dimensiunea permisă a
    acestor stringuri la ieșire este de 25 de caractere, însă unele dintre ele
    sunt mai mari de atât la ieșire. Creați un program care, atunci când un
    string depășește dimensiunea de 25 de caractere, va întrerupe stringul
    și va introduce trei puncte în locul ultimelor trei caractere. Stringurile
    astfel procesate trebuie afișate la ieșire.
    Intrarea programului:
    String[] texts =
    { "Optimum pH of
    our water is between 6.0 and 7.0. However Oscars are okay in a pH up to 8.0.",
    "The Oscar fish is not a difficult fish to look after if you give it a suitable
    environment to live in. You may start having problems such as health issues if
    you keep your Oscar in an unsuitably small tank or feed it on a poor diet",
    "The Oscar has the potential to reach 18 inches. However in captivity Oscars
    normally growto between 8 and 12 inches" };

     */
        String[] texts =
                {"Optimum pH of your water is between 6.0 and 7.0. " +
                        "However Oscars are okay in a pH up to8.0.",
                        "The Oscar fish is not a difficult fish to look after if you " +
                                "give it a suitable environment to live in. " +
                                "You may start having problems such as health " +
                                "issues if you keep your Oscar in an unsuitably " +
                                "small tank or feed it on a poor diet ",
                        "The Oscar has the potential to reach 18 inches. " +
                                "However in captivity Oscars normally growto " +
                                "between 8 and 12 inches "};
        for (int i = 0; i < texts.length; i++) {
            if (texts[i].length() > 25) {
                String trimTxt = texts[i].substring(0, 22);
                trimTxt = trimTxt.concat("...");
                System.out.println(trimTxt);
            }
        }


        System.out.println("\n");
        /*
        Exercițiul 2
        În aplicație intră o listă de fișiere sub forma unui string. Trebuie
        recunoscute doar fișierele de tip jpg, png sau gif (prin utilizarea
        extensiilor acestora) și afișat un mesaj despre tipul lor la ieșire:
        Fișierul: picture1.jpg este de tip jpg
        Fișierul: picture2.png este de tip png
        Fișierul: picture3.gif este de tip gif
        Parametrul de intrare:
        String[] files = { "picture1.jpg", "text1.txt",
        "picture2.png", "text2.doc", "picture3.gif" };
         */
        String[] files = {"picture1.jpg", "text1.txt",
                "picture2.png", "text2.doc", "picture3.gif"};

        for (int u = 0; u < files.length; u++) {
            if (files[u].endsWith(".jpg")) {
                System.out.println("Fiserul " + files[u] + " are extensia .jpg");
            } else if (files[u].endsWith(".png")) {
                System.out.println("Fiserul " + files[u] + " are extensia .png");
            } else if (files[u].endsWith(".gif")) {
                System.out.println("Fiserul " + files[u] + " are extensia .gif");
            } /*else {
                System.out.println("Fiserul " + files[u] + " are extensie nerecunoscuta");
            }*/
        }

        System.out.println("\n");
        /*
        Datele intră în aplicație prin intermediul următorului string:
        String users = "firstName: Vladimir|lastName:
        Vladimirovic|firstName: Jovan|lastName:
        Jovanovicc|firstName: Petar|lastName: Petrovic";
        Formatați datele astfel încât să obțineți următoarea ieșire:
        user first name is : Vladimir, user last name is :
        Vladimirovic
         */
        String users = "firstName: Vladimir|lastName: Vladimirovic|" +
                "firstName: Jovan|lastName: Jovanovicc|" +
                "firstName: Petar|lastName: Petrovic";

        String[] usersArray = users.split("\\|");
        for (int i = 0; i < usersArray.length; i += 2) {
            String firstName = usersArray[i].split(" ")[1];
            String lastName = usersArray[i + 1].split(" ")[1];
            System.out.println("user first name is : " + firstName + ", user last name is : " + lastName);
        }

        System.out.println("\n");
        /*
        Datele intră în aplicație prin intermediul următoarelor două stringuri:
        String[] forbidenChars = { "<",">","'" };
        String input = "<div>my 'div' tag</div>";

        Trebuie să curățați stringul astfel încât la ieșire să nu apară
        caracterele: divmy div tag/div
         */

        String[] forbidenChars = {"<", ">", "'"};
        String input = "<div>my 'div' tag</div>";

        for (int y = 0; y < forbidenChars.length; y++) {
            input = input.replace(forbidenChars[y], "");
        }
        System.out.println(input);


        System.out.println("\n");
        /*
        Exercițiul 1
        În cadrul aplicației noastre web am obținut următorul string care
        transmite parametri în următoru format:
        serverId=25&serverName=my name&serverStatus=Running
        Creați o clasă Server cu următoarele câmpuri: Id, Name and Status.
        Creați o enumerare cu statusurile serverului (Stopped, Running,
        Unknown) și o metodă care izolează parametrii (din probleme) și
        creează o instanță a clasei Server pe baza lor.
        Trebuie suprascrisă metoda toString a clasei Server și afișat ID-ul,
        numele și statusul serverului în ea.
        Realizați soluții de test prin intermediul metodei Main a clasei Main.
         */

        Server server = new Server("serverId=25" +
                "&serverName=my name" +
                "&serverStatus=EEEEEEEEEEEEEI MACARENA");
        System.out.println(server);

        System.out.println("\n");
        /*
        Avem o clasă User:
        De asemenea, în metoda Main a aplicației, avem următorul cod:
        Adăugați toți utilizatorii din lista usersToAdd în lista Users. Dacă există
        deja un utilizator cu același ID, înlocuiți vechiul utilizator cu cel nou.
        Afișați lista Users.
         */
        ArrayList<User> usersToAdd = new ArrayList<>();
        usersToAdd.add(new User(4, "Goran"));
        usersToAdd.add(new User(2, "Ilija"));
        usersToAdd.add(new User(6, "Nikola"));
        ArrayList<User> users2 = new ArrayList<>();
        users2.add(new User(1, "Petar"));
        users2.add(new User(2, "Jovan"));
        users2.add(new User(3, "Zoran"));


        for (int uta = 0; uta < usersToAdd.size(); uta++) {
            boolean userExists = false;
            for (int u2 = 0; u2 < users2.size(); u2++) {
                if ((users2.get(u2)).Id == ((usersToAdd.get(uta)).Id)) {
                    users2.set(u2, usersToAdd.get(uta));
                    userExists = true;
                }
            }
            if (!userExists)
                users2.add(usersToAdd.get(uta));
            else
                userExists = false;
        }
        for (Object u3 : users2)
            System.out.println(((User) u3).Id + ":" + ((User) u3).name);

        System.out.println("\n");
        /*
        Exercițiul 2
        Pe baza clasei User existente (din exercițiul anterior), am creat
        următoarea listă.
        Sortați utilizatorii în funcție de ID și afișați lista la ieșire.
         */

        ArrayList<User> users3 = new ArrayList<>();
        users3.add(new User(4, "Goran"));
        users3.add(new User(2, "Ilija"));
        users3.add(new User(6, "Nikola"));
        users3.add(new User(1, "Petar"));
        users3.add(new User(2, "Jovan"));
        users3.add(new User(3, "Zoran"));

        int min;
        User tmp;
        for (int ui = 0; ui < users3.size(); ui++) {
            min = ui;
            for (int au = ui; au < users3.size(); au++) {
                if ((users3.get(au)).Id < (users3.get(min)).Id) {
                    min = au;
                }
            }
            tmp = users3.get(min);
            users3.set(min, users3.get(ui));
            users3.set(ui, tmp);
        }
        for (Object u4 : users3)
            System.out.println(((User) u4).Id + ":" + ((User) u4).name);

        System.out.println("\n");
        /*
        Exercițiul 1
        Creați un program care va afișa la ieșire toate lunile anului curent și
        durata lor.
         */
        LocalDate now = LocalDate.now();
        for (Month month : Month.values()) {
            System.out.println(month + " " + month.length(now.isLeapYear()));
        }


//////////////////////////////////////end
    }
}



