package Ex;

import static Ex.Circle.r;
import static Ex.Rectangle.*;
import static Ex.Produs.*;


public class L_4 {

    public static void main(String[] args) {

        /*
        Exerciţiul 1
        Trebuie creată clasa Animal care va fi definită ca una abstractă, iar
        apoi trebuie create două clase, Horse şi Dog, care vor moşteni prima
        clasă Animal.
         */

        System.out.println("\n");
        /*
        Exerciţiul 2
        Trebuie executată instanţierea claselor din exerciţiul precedent.
         */
        Horse horse = new Horse();
        Dog dog = new Dog();
        // Animal nu merge instintat pentru ca este abstract

        System.out.println("\n");
        /*
        Exerciţiul 1
        Trebuie creată clasa Calculator (de buzunar) care are trei proprietăţi:
        operand1, operand2 şi operator. Clasa posedă metoda calculate() care,
        pe baza operatorului, execută operaţia de calcul adecvată asupra
        operanzilor şi returnează un rezultat. Sunt suficiente cele 4 operaţii de
        bază (+, -, *, / - adunarea, scăderea, înmulţirea şi împărţirea).
        Toate valorile sunt de tip double.
         */

        Calculator calc = new Calculator();
        calc.operand1 = 2;
        calc.operand2 = 0;
        calc.operator = "/";
        calc.calculate();

        System.out.println("\n");
        /*
        Exerciţiul 2
        Trebuie create 3 clase. Prima este clasa Circle şi ea conţine
        proprietatea r (raza). A doua clasă este Rectangle şi conţine
        proprietăţile a şi b. A treia clasă se numeşte Calc şi conţine metoda
        statică area care, ca parametru, acceptă o instanţă a clasei (Circle sau
        Rectangle), iar ca rezultat prezintă aria formei introduse. În funcţie
        dacă în metodă a intrat instanţa clasei Circle sau Rectangle, va fi
        executată formula de calculare a ariei pentru Circle sau Rectangle.
         */

        Calc area = new Calc();
        r = 117.117;
        a = 33.89;
        b = 45.3;
        area.areaType = "circle";
        area.calcArea();

        //the right way ...
        System.out.println("The rightway..");

        Circle circleArea = new Circle(73);
        Rectangle rectangleArea = new Rectangle(56, 123.55);

        Calc.area(rectangleArea);
        Calc.area(circleArea);

        System.out.println("\n");
        /*
        Exerciţiul 1
        Trebuie creată o clasă Shape care va conţine unele date referitoare la
        forma geometrică, precum: poziţia (x,y), culoarea şi denumirea.
        Trebuie create trei clase care vor moşteni clasa Shape. O clasă trebuie
        creată pentru cerc, una pentru pătrat şi una pentru dreptunghi. Fiecare
        trebuie să conţină o metodă pentru calcularea ariei, precum şi propriile
        atribute necesare pentru această calculare (laturile pentru dreptunghi
        şi pătrat şi raza pentru cerc). De asemenea, cercul trebuie să posede şi
        constanta PI.
        Toate valorile pot fi întregi (dar nu şi PI).
         */
        Circle2 c2 = new Circle2();
        c2.cirle2Radius = 117;
        c2.shapeColor = "Red";
        c2.xShape = 33;
        c2.yShape = 77;
        c2.circle2Area();
        Rectangle2 r2 = new Rectangle2();
        r2.rectangleSide_1 = 117;
        r2.rectangleSide_2 = 337;
        r2.shapeColor = "Red";
        r2.xShape = 33;
        r2.yShape = 77;
        r2.rectangleeArea();

        System.out.println("\n");
        /*
        Exerciţiul nr. 1
        Pentru aplicaţia unui restaurant de fast food, trebuie creată clasa
        abstractă Produs. Această clasă conţine proprietăţi publice: int
        tipProdus, String nume şi double preţul de bază, precum şi un şir de
        stringuri adaosuri, care poate conţine cel mult 10 adaosuri. De
        asemenea, această clasă conţine şi metoda introducere adaos care
        introduce adaosul pentru produs (salată, condimente etc.) şi metoda
        toateAdaosurile, care returnează toate adaosurile sub formă de string.
        Clasa trebuie să aibă şi o metodă abstractă, calcularePreţ, care va
        calcula preţul pe baza tipului de produs. În timpul calculării preţului
        produsului, trebuie să aveţi grijă la taxa pentru pizza de 10%, în timp
        ce taxa pentru sendvişuri este de 15%.
        Clasa trebuie să posede şi metoda suprascrisă toString care va afişa
        datele despre produs în următoarea formă:
        Produs: pizza, preţ: 25,45, adaosuri: roşii, muştar, maioneză.
        Trebuie create clasele Pizza şi Sendviş care moştenesc clasa Produs şi
        trebuie creat codul pentru crearea unei instanţe a claselor Pizza şi
        Sendviş în metoda Main. Clasele Pizza şi Sendviş necesită în
        constructor numele şi preţul produsului.
         */


        Pizza p1 = new Pizza();
        p1.pretBaza = 55;
        p1.nume = "Capriciosa";
        p1.adaosuri = new String[]{"ciuperci", "masilne", "extra mozzarela"};

        Sendvis s1 = new Sendvis();
        s1.pretBaza = 35;
        s1.nume = "Sanvis sunca";


        System.out.println(p1);
        System.out.println(s1);

        System.out.println("\n");
        /*
        Exerciţiul nr. 2
        Trebuie creată clasa abstractă Quad care va conţine 3 câmpuri
        (x, y şi a) şi o metodă abstractă (Setxya).
        Trebuie creată interfaţa IGeom care va conţine semnăturile
        metodelor pentru calcularea ariei şi a perimetrului.
        Trebuie creată clasă Square care moşteneşte clasa Quad şi
        implementează interfaţa IGeom.
        Trebuie creată o instanţă a clasei Square în programul
        principal.
         */
        Square2 s = new Square2();
        s.Setxya(1, 117, 7);
        System.out.println("Arie = " + s.arie());
        System.out.println("Perimetru = " + s.perimetru());

        System.out.println("\n");
        /*
        Exerciţiul nr. 3
        Sunt necesare două interfeţe pentru aplicaţia calculator (de
        buzunar): Operands şi Operations. Operands conţine semnătura
        metodei setOperands care pune operanzii la valorile iniţiale, în
        timp ce Operations conţine semnături ale metodelor cu operaţii
        (sunt suficente doar două).
        Trebuie creată clasa Calculator care va implementa interfeţele
        Operands şi Operations.
        Trebuie instanţiată clasa Calculator în aplicaţia principală şi
        trebuie activate metodele sale Adunare şi Scădere.
         */

        Calculator2 calc2 = new Calculator2();
        calc2.setOperands(117, 7);
        System.out.println(calc2.add());
        System.out.println(calc2.sub());

        System.out.println("\n");
        /*

         */
///////////////////////////////////end
    }
}
