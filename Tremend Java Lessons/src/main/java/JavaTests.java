import Ex.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class JavaTests {

    private int classVariable;

    private static int classVariable2;

    private static int variableA; // variabila de clasă

// variabile de instanţă

    private int variableB;

    private String variableC;

    private boolean variableD;

    private static final double PI = 3.14;

    public enum DaysOfWeek {
        MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7), UNSPECIFIED(8);

        public int position;

        DaysOfWeek(int p) {
            position = p;
        }
    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {

        System.out.println("Geani test");
       /* System.out.println("Geani test2");
        System.out.println("Geani test3");*/

        Integer xn = 81;
        if (xn < 10) {
            System.out.println("\n" + "Ei manacrena");
        } else {
            System.out.println("\n" + "no macarena");
        }

        Object obj = new Object();

        int variableNum = 32;

        int[] anArray;

        int decVal = 26;

        int octVal = 032; // 2 * 8^0 + 3 * 8^1 = 2 + 24 = 26

        int hexVal = 0x1a; // 10 * 16^0 + 1 * 16^1 = 10 + 16 = 26

        int binVal = 0b11010; // 2^1 + 2^3 + 2^4 = 2 + 8 + 16 = 26

        System.out.println(xn.getClass());

        double z = 10.5;

        int y = (int) z;

        System.out.println(y);


        String geaniString = "Geani String test";

        System.out.println("\n" + geaniString);


        long creditCardNumber = 1234_5678_9012_3456L;

        long socialSecurityNumber = 999_99_9999L;

        float pi = 3.14_15F;

        long hexBytes = 0xFF_EC_DE_5E;

        long hexWords = 0xCAFE_BABE;

        long maxLong = 0x7fff_ffff_ffff_ffffL;

        byte nybbles = 0b0010_0101;

        long bytes = 0b11010010_01101001_10010100_10010010;

        System.out.println("\n");


        JavaTests objClass = new JavaTests();

        objClass.classVariable = 7;

        System.out.println("cls var = " + objClass.classVariable);

        JavaTests.classVariable2 = 37;
        System.out.println("cls var2 = " + JavaTests.classVariable2);

        System.out.println("\n");

        System.out.println(variableA);

        System.out.println(objClass.variableB);

        System.out.println(objClass.variableC);

        System.out.println(objClass.variableD);

        int varE = 12312312;
        System.out.println(varE);

        System.out.println("\n");


        System.out.println(PI);

        int w = 55555;

        System.out.printf("The value of variable x is %d", w);

        double zz = 12.1313467445;

        System.out.printf("The value of variable x is %d%n " +
                "The value of variable y is %.4f", w, zz);

        System.out.println("\n");

        int zx = 3;

        int yx = zx;

        System.out.println(yx);

        System.out.println("\n");

        int a = 10;

        int b = a << 1;

        System.out.println(a); // 10

        System.out.println(b); // 20

        // metoda toBinaryString()returnează reprezentaţia binară string a numărului întreg (în baza 2)

        System.out.println(Integer.toBinaryString(a)); // 1010

        System.out.println(Integer.toBinaryString(b)); // 10100

        int aa = 10;

        int ab = ~aa;

        System.out.println(ab); // -11

        System.out.println(Integer.toBinaryString(ab));
        // 11111111111111111111111111110101
        System.out.println(Integer.toBinaryString(5 & 11)); // 1 tj. 0001

        System.out.println("\n");

        int[] arrayx = new int[5];
        arrayx[0] = 1314;
        arrayx[3] = 5;
        int[] array2 = {131, 312, 312, 321, 312};

        Object objectArray[] = {3, 6.5, 2, 6, 1, 6};

        System.out.println(arrayx.length);

        System.out.println("\n");

        int array[] = {3, 5, 2, 6, 1, 6};

        int array1[] = {12, 13, 14};

        int destArray[] = new int[array.length + array1.length];

        System.arraycopy(array, 0, destArray, 0, array.length);

        System.arraycopy(array1, 0, destArray, array.length, array1.length);

        System.out.println("Array length is: " + destArray.length);

        System.out.println("Elements are: ");

        System.out.println(Arrays.toString(destArray));
        System.out.println("\n");


        int arr[] = {3, 5, 2, 6, 1, 6};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        int[] a6 = {5, 1, 3, 4, 2};

        Arrays.sort(a6);

        System.out.println(Arrays.binarySearch(a6, 2));

        System.out.println(Arrays.binarySearch(a6, 6));

        System.out.println("\n");

        int[] array3 = new int[6];

        Arrays.fill(array, 7);
        int[] array4 = new int[6];

        System.out.println("\n");

        int[][] matrix

                = {
                {1, 2, 3, 4},

                {5, 6, 7, 8},

                {9, 10, 11, 12}
        };

        System.out.println(matrix[1][2]);

        System.out.println("\n");

        int xi = 0;

        if (xi != 0) {
            System.out.println("x is different from zero");
        } else {
            System.out.println("x is equal to zero");
        }

        System.out.println("\n");

        int num = 15;
        if (num < 10) {
            System.out.println("number < 10");
        } else if (num > 10) {
            System.out.println("num > 10");
        } else if (num == 10) {
            System.out.println("num = 10");
        }

        System.out.println("\n");

        boolean isHappy = true;

        String mood = (isHappy == true) ? "I'm Happy!" : "I'm Sad!";
        System.out.println(mood);

        System.out.println("\n");

        int x = 36;

        if ((x > 1 && x < 25 && x != 10) || (x == 35))

            System.out.println("Condition is fulfilled");

        else

            System.out.println("Condition is not fulfilled");


        System.out.println("\n");

        int xs = 5;

        switch (xs)

        {

            case 1:

                System.out.println("x = 1");

                break;

            case 2:

                System.out.println("x = 2");

                break;

            case 3:

                System.out.println("x = 3");

                break;

            default:

                System.out.println("x!=1, x!=2, x!=3");

        }

        System.out.println("\n");

        String carMake = "Ford";

        int doors = 4;
        switch (carMake) {

            case "Ford":

                switch (doors) {

                    case 3:

                        System.out.println("You drive a Ford with three doors.");

                        break;

                    case 4:

                        System.out.println("You drive a Ford with four doors.");

                        break;

                    case 5:

                        System.out.println("You drive a Ford with five doors.");

                        break;

                }

                break;

            default:

                System.out.println("We're sorry. You do not drive a Ford car.");

                break;

        }


        System.out.println("\n");

        int counter;
        for (counter = 0; counter <= 5; counter++) {

            System.out.println(counter);

        }

        System.out.println(counter);

        System.out.println("\n");


        String[] colors = {"red", "green", "blue", "yellow", "white"};

        for (int i = 0; i < colors.length; i++)

        {

            System.out.println("Color of element " + i + " is " + colors[i] + ".");
        }


        System.out.println("\n");

        int i = 0;

        for (i = 0; i < 33; i++)

            System.out.println(i);

        System.out.println("\n");


        int[] numbers = {3, 5, 9, 45, 6546, 8756123, 65};

        System.out.println("Numbers in this array are: ");

        for (int number : numbers) {

            System.out.println(number);
        }

        System.out.println("\n");

        for (int yy = 0; yy < 10; yy++)

        {

            System.out.print("\n" + yy + ":");

            for (int u = 0; u < 10; u++)

            {

                System.out.print(u);

                if (u == 5)

                    break;

            }

        }

        System.out.println("\n");

        int number = 5;

        do {

            System.out.println(number);

            number--;

        }

        while (number >= 2);

        System.out.println("\n");

        Ex.Car car1 = new Ex.Car();
        Ex.Car car2 = new Ex.Car("Ford");

        Ex.Car car3 = new Ex.Car("Ford", "Fiesta");
        Ex.Car car4 = new Ex.Car("Ford", "Fiesta", 3);

        System.out.println("\n");

        car4.printDetails();

        System.out.println("\n");

        Conversions.f2c(117.3);

        int xm = 5;
        System.out.println("This is initial value: " + xm);
        passMethod(xm);
        System.out.println("This is the value after the completion of the method: " + xm);

        System.out.println("\n");

        int xrt = 5;


        ReferenceType rt = new ReferenceType();

        System.out.println("This is initial value: " + rt.xrt);
        passMethodrt(rt);
        System.out.println("This is the value after the completion of the method: " + rt.xrt);

        System.out.println("\n");

        getPerimeter(13, 13, 13);

        System.out.println("\n");

        //Person person = new Person("John", "Davidson");
        Student student = new Student("John", "Smith", "10/2014");
        Professor professor = new Professor("Edward", "Owen", "Java Programming");

        student.show();
        professor.show();


        System.out.println("\n");

        double res1 = Calc2.add(4, 6);
        double res2 = Calc2.add(4, 6, 8);
        System.out.println(res1);
        System.out.println(res2);


        System.out.println("\n");


        StringBuilder sb = new StringBuilder();
        sb.append("My ");
        sb.append("string");
        System.out.println(sb);

        System.out.println("\n");

        String word = "Hello";
        char[] charArray = word.toCharArray();

        for (int ii = 0; ii < charArray.length; ii++) {
            System.out.println(charArray[ii]);
        }

        System.out.println("\n");


        String str = "This is a sentence. This is a question, right? Yes! It is.";
        System.out.println("Return Value :");
        String[] wordArray = str.split("[ .,?!]");
        for (int vi = 0; vi < wordArray.length; vi++) {
            System.out.println(wordArray[vi]);
        }

        System.out.println("\n");

        System.out.println(Arrays.toString(DaysOfWeek.values())
                .replace("[", "")
                .replace("]", ""));
        System.out.println(DaysOfWeek.FRIDAY.position);
        System.out.println(DaysOfWeek.values().length);

        for (int ie = 0; ie < DaysOfWeek.values().length; ie++) {
            System.out.println(DaysOfWeek.values()[ie]);
        }

        System.out.println("\n");

        String day = "bambucea";

        DaysOfWeek daysOfWeek = DaysOfWeek.UNSPECIFIED;

        try {
            daysOfWeek = DaysOfWeek.valueOf(day);
        } catch (Exception exc) {
            System.out.println(exc);
        }

        switch (daysOfWeek) {
            case MONDAY:
                System.out.println("Day is MONDAY");
                break;
            case TUESDAY:
                System.out.println("Day is TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Day is WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Day is THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Day is FRIDAY");
                break;
            case SATURDAY:
                System.out.println("Day is SATURDAY");
                break;
            case SUNDAY:
                System.out.println("Day is SUNDAY");
                break;
            case UNSPECIFIED:
                System.out.println("Input error");
                break;
        }

        System.out.println("\n");

        List myList = new ArrayList();

        myList.add("my");
        myList.add("name");
        myList.add("is...");
        System.out.println(myList.get(1));
        myList.remove(1);
        System.out.println(myList.get(1));

        for (int zi = 0; zi < myList.size(); zi++)
            System.out.println(myList.get(zi));
        for (Object ss : myList)
            System.out.println(ss);

        ArrayList myList2 = new ArrayList();
        myList2.add("my");
        myList2.add("name");
        myList2.add("is...");
        myList2.add(123);
        for (Object s : myList2)
            System.out.println(s);

        System.out.println("\n");

        ArrayList<String> myList3 = new ArrayList<>();
        System.out.println(myList2.contains("name"));
        Object[] niz = myList.toArray(new String[myList.size()]);
        System.out.println(Arrays.toString(niz));

        System.out.println("\n");

        HashMap hashMap = new HashMap();
        hashMap.put("1234567890123", "John Davidson");
        hashMap.put("1234567890124", "Tom Dvorak");
        System.out.println(hashMap.get("1234567890124"));

        System.out.println("\n");

        NodeList list = new NodeList();
        list.add(1);
        list.add(5);
        list.add(10);
        System.out.println(list.getValue(2));


        System.out.println("\n");

        System.out.println(LocalDate.now().getEra());

        LocalDate date = LocalDate.of(2000, 11, 20);
        LocalTime time = LocalTime.now();
        System.out.println("Hour: " + time.getHour() + " Minutes: " + time.getMinute() + " Seconds: "
                + time.getSecond());

        System.out.println(LocalDateTime.now());

        System.out.println("\n");

        LocalDateTime dateTime = LocalDateTime.now();
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day2 = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minutes = dateTime.getMinute();
        int seconds = dateTime.getSecond();
        System.out.println("Today is " + dateTime.getMonth() + " " + day2 + ", " + year);
        System.out.println("It is " + hour + " hours " + minutes + " minutes and " + seconds + "                seconds");
        System.out.println("6 months from now: " + dateTime.plusMonths(6));
        System.out.println("6 months ago: " + dateTime.minusMonths(6));

        System.out.println("\n");

        LocalDate localDate = LocalDate.of(1999, 12, 13);
        LocalTime localTime = LocalTime.of(17, 50);
        LocalDateTime localDateTime = LocalDateTime.of(localDate,
                localTime);
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = LocalDateTime.of(1999, 12,
                13, 17, 50);
        System.out.println(localDateTime2);

        System.out.println("\n");

        Instant instant = Instant.now();
        System.out.println(instant.toString());


        //Thread.sleep(3000);
        long period = instant.until(Instant.now(),
                ChronoUnit.SECONDS);
        System.out.println(period);

        System.out.println("\n");
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(),
                ldt.getDayOfMonth(), ldt.getYear(), ldt.getHour(), ldt.getMinute());

        System.out.println("\n");
        String in = "19880705";
        LocalDate date2 = LocalDate.parse(in, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date2);


        System.out.println("\n");

        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(1991, Month.JUNE, 23);
        Period p = Period.between(birthday, now);
        long p2 = ChronoUnit.DAYS.between(birthday, now);
        long p3 = ChronoUnit.MONTHS.between(birthday, now);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months, and " +
                p.getDays() + " days old. (" + p2 + " days total or " + p3 + " months)");


        System.out.println("\n");

        String myText = "Hello World";
        try (FileOutputStream fs = new FileOutputStream("myFile.txt");) {
            fs.write(myText.getBytes());
        } catch (IOException exc) {
            System.out.println(exc);
        }

        try (FileInputStream fs = new FileInputStream("myFile.txt");) {
            int content = fs.read();
            while (content != -1) {
                System.out.print((char) content);
                content = fs.read();
            }
        } catch (IOException exc) {
            System.out.println(exc);
        }
        System.out.println("\n");

        String myText2 = "Hello World2";
        try (FileWriter fw = new FileWriter("myFile2.txt");) {
            fw.write(myText2);
        } catch (IOException exc) {
            System.out.println(exc);
        }

        try (FileReader fr = new FileReader("myFile2.txt");) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print(c);
            }
        } catch (IOException exc) {
            System.out.println(exc);
        } finally {
            System.out.println();
        }

        System.out.println("\n");

        try (BufferedReader br = new BufferedReader(new FileReader("myFile2.txt"));) {
            String l;
            while ((l = br.readLine()) != null) {
                System.out.println(l);
            }
        } catch (IOException exc) {
            System.out.println(exc);
        }

        System.out.println("\n");

        try {
            BufferedInputStream input = new BufferedInputStream(
                    new FileInputStream("myFile.txt "));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader input = new BufferedReader(new
                    FileReader("myFile.txt "));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n");

        int variableA = 13;
        double variableB = 13.13;
        String variableC = "Hello!";
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("myFile3.txt"));
        ) {
            out.writeInt(variableA);
            out.writeDouble(variableB);
            out.writeUTF(variableC);

        } catch (IOException exc) {
            System.out.println(exc);
        }

        try (DataInputStream in2 = new DataInputStream(new FileInputStream("myFile3.txt"));) {
            System.out.println(in2.readInt());
            System.out.println(in2.readDouble());
            System.out.println(in2.readUTF());
        } catch (IOException exc) {
            System.out.println(exc);
        }

        System.out.println("\n");

        Car c = new Car();
        c.setId(10);
        c.setModel("Audi A8");
        c.setMaximumSpeed(270.00);

        FileOutputStream fos = new FileOutputStream("MyCar.xml");
        XMLEncoder s = new XMLEncoder(fos);
        s.writeObject(c);
        s.close();

        FileInputStream fis = new FileInputStream("MyCar.xml");
        XMLDecoder objIn = new XMLDecoder(fis);
        c = (Car) objIn.readObject();
        System.out.println(c);

        System.out.println("\n");

        File[] roots = File.listRoots();
        for (int fi = 0; fi < roots.length; fi++) {
            System.out.println(roots[fi]);
        }

        System.out.println("\n");

        File file = new File("user3_xmlFile.xml");
        System.out.println("Absolute path = " + file.getAbsolutePath());
        System.out.println("Name = " + file.getName());
        System.out.println("Parent = " + file.getParent());
        System.out.println("Path = " + file.getPath());
        System.out.println("Is absolute = " + file.isAbsolute());

        System.out.println("\n");
        if (file.exists()) {
            System.out.println("Is file = " + file.isFile());
            System.out.println("Is directory = " + file.isDirectory());
            System.out.println("Lenght = " + file.length());
            instant = Instant.ofEpochMilli(file.lastModified());
            dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM. yyyy. HH:mm:ss");

            System.out.println("Last modified = " + dateTime.format(dateTimeFormatter));
            file.setReadOnly();
        }

        System.out.println("\n");

        File path = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\src\\main\\java\\Ex");
        if (path.exists() && path.isDirectory()) {
            File[] elements = path.listFiles();
            for (int fi = 0; fi < elements.length; fi++) {
                System.out.println(elements[fi].getName());
            }
        }

        System.out.println("\n");

        File testDirectory = new File("C:\\test");
        try {
            if (!testDirectory.exists()) {
                testDirectory.mkdir();
                System.out.println("Created a directory called " + testDirectory.getName());
            } else {
                System.out.println("Directory called " + testDirectory.getName() + " already exists.");
            }

        } catch (Exception e) {
            System.out.println("Couldn't create a directory called "
                    + testDirectory.getName());
        }
        System.out.println("\n");

        File file2 = new File("C:\\test ");
        if (file2.exists()) {
            file2.delete();
            System.out.println("File successfully deleted!");
        } else {
            System.out.println("Cannot delete " + file2.getName() + " because " + file2.getName() + " does not exist.");
        }
        System.out.println("\n");

        File oldfile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\thirdFile2.txt");
        File newfile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\thirdFile.txt");

        if (!oldfile.exists()) {
            System.out.println("File doesn't exists!");
        }
        if (newfile.exists()) {
            System.out.println("File with desired name already exists!");
        }
        if (oldfile.renameTo(newfile)) {

            System.out.println("Rename succesful");
        } else {
            System.out.println("Rename failed");
        }


        System.out.println("\n");

        File afile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users.txt");
        File bfile = new File("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users3.txt");
        try (FileInputStream inStream = new FileInputStream(afile);
             FileOutputStream outStream = new FileOutputStream(bfile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            System.out.println("File is copied successfuly!");
        } catch (IOException exc) {
            System.out.println(exc);
        }

        System.out.println("\n");

        Path source = Paths.get("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users3.txt");
        Path destination = Paths.get("C:\\Users\\gfleancu\\IdeaProjects\\GeaniFleancu\\users4.txt");
        try {
            if (!Files.exists(source)) {
                System.out.println("File doesn't exists!");
                return;
            }
            if (!Files.exists(destination.getParent())) {
                System.out.println("Location doesn't exists!");
                return;
            }
            if (Files.exists(destination)) {
                System.out.println("File already exists on the location!");
                return;
            }
            Files.copy(source, destination);
            System.out.println("File " + source.getFileName() + " is copied!");
        } catch (IOException ex) {
            System.out.println(ex);
        }

//////////////////////end
    }


    public static void passMethod(int xm) {
        xm = 10;
        System.out.println("This is the value from method: " + xm);
    }

    public static void passMethodrt(ReferenceType rt) {
        rt.xrt = 10;
        System.out.println("This is the value from method: " + rt.xrt);
    }

    public static void getPerimeter(int... edges) {
        int perimeter = 0;
        if (edges.length < 3) {
            System.out.println("Polygon must have more than two sides.");
        } else {
            for (int i = 0; i < edges.length; i++) {
                perimeter += edges[i];
            }
            System.out.println(perimeter);
        }

    }
}


