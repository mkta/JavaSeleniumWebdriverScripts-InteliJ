package Ex;

import java.io.*;
import java.util.ArrayList;

public class L_7 {
    public static void main(String[] args) throws IOException {

        /*
        Problemă:
        Avem fișierul users.txt cu următorul conținut:
        id:01|firstName:Petar|lastName:Petrovic|jmbg:1234567890123
        id:02|firstName:Jovan|lastName:Jovanovic|jmbg:1234567890124
        id:03|firstName:Nikola|lastName:Nikolic|jmbg:1234567890125
        Creați o aplicație care va citi fișierul și va afișa conținutul în următorul
        format:
        User Id: 01
        First name: Petar
        Last name: Petrovic
        Jmbg: 1234567890123
        ------------------------------------
        User Id: 02
        First name: Jovan
        Last name: Jovanovic
        Jmbg: 1234567890124
         */
        BufferedReader bufferReader = new BufferedReader(new FileReader("users.txt"));
        String line;
        while ((line = bufferReader.readLine()) != null) {
            String[] user = line.split("\\|");
            System.out.println("User Id: " + user[0].split("\\:")[1]);
            System.out.println("First name: " + user[1].split("\\:")[1]);
            System.out.println("Last name: " + user[2].split("\\:")[1]);
            System.out.println("Jmbg: " + user[3].split("\\:")[1]);

            System.out.println("------------------------------------");
        }
        bufferReader.close();

        System.out.println("\n");
    /*
    Exercițiul 2
    Creați o aplicație care concatenează fișierele (pune două fișiere într-
    unul singur). Denumirile acestor fișiere sunt: firstFile.txt și
    secondFile.txt. Uniți conținuturile acestor două fișiere și puneți-le în
    fișierul denumit thirdFile.txt.
     */

        String tmpLine;
        BufferedWriter bufferWritter = new BufferedWriter(new FileWriter("thirdFile.txt"));
        ArrayList<BufferedReader> filesToRead = new ArrayList<>();
        filesToRead.add(new BufferedReader(new FileReader("users.txt")));
        filesToRead.add(new BufferedReader(new FileReader("myFile3.txt")));
        for (BufferedReader bufferReader2 : filesToRead) {
            while ((tmpLine = bufferReader2.readLine()) != null) bufferWritter.write(tmpLine + "\n");
            bufferReader.close();
        }
        bufferWritter.close();


        System.out.println("\n");
        /*
            Este dată clasa User3:
            Trebuie să creăm metode adiţionale în această clasă: o metodă pentru
            serializarea XML a obiectului şi a doua metodă, care este statică,
            pentru crearea obiectului din documentul XML.
            Testaţi serializarea şi deserializarea în metoda Main.
        */
        User3 user3e = new User3();
        user3e.setId(117);
        user3e.setEmail("117.jon@spartan.unsc");
        user3e.setPassword("cortana");
        user3e.serializaeXml("user3_xmlFile.xml");

        User3 user3d = User3.deserializaeXml("user3_xmlFile.xml");
        System.out.println(user3d);

        System.out.println("\n");
        /*
        Creați un program ce va muta fișierul de pe o cale pe alta (opțiunea cut).
         */
        String source = "C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users4.txt";
        String destination = "C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\copytest";

        File copyDir = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\copytest");
        try {
            if (!copyDir.exists()) {
                copyDir.mkdir();
                System.out.println("Created a directory called " + copyDir.getName());
            } else {
                System.out.println("Directory called " + copyDir.getName() + " already exists.");
            }

        } catch (Exception e) {
            System.out.println("Couldn't create a directory called "
                    + copyDir.getName());
        }
        File sourceFile = new File(source);
        File destFile = new File(destination + "\\" + sourceFile.getName());
        //create a copy file for delete
        File afile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users.txt");
        File bfile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users4.txt");
        try (FileInputStream inStream = new FileInputStream(afile);
             FileOutputStream outStream = new FileOutputStream(bfile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            System.out.println("File user4 created!");
        } catch (IOException exc) {
            System.out.println(exc);
        }
        //cut part
        try (FileInputStream inStream = new FileInputStream(sourceFile);
             FileOutputStream outStream = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File copied with cut complete");
            inStream.close();
            outStream.close();
            sourceFile.delete();
        } catch (IOException exc) {
            System.out.println(exc);
        }


//////////////////////end
    }
}

