package valueReference;

import org.testng.annotations.Test;

public class ValueReferenceTest {

    //variabilele pot să fie primitive și non-primitive
    //primitivă = un tip de dată predefinit, care poate doar să primească o valoare specifică
    //ex. primitive: int, double, float, char, boolean, byte (încep cu litere mici)
    //ex. non-primitive: String, orice instanțiere care se face cu "new"
    //wrapper class = o nouă implementare care este construită pe implementarea veche
    //ex. wrapper class: Integer, Double, Float, Character, Boolean (încep cu litere mari)

    public Integer varsta = 10;
    public String nume = "Gabriel";
    public StringBuilder prenume = new StringBuilder("Alex ");

    @Test
    public void testMethod() {
        System.out.println("Valoare inițială este: " + varsta);
        calcul(varsta);
        System.out.println("Valoare actuală este: " + varsta);

        System.out.println();
        System.out.println("Valoare inițială este: " + nume);
        concatenare(nume);
        System.out.println("Valoare actuală este: " + nume);

        System.out.println();
        System.out.println("Valoare inițială este: " + prenume);
        concatenare(prenume);
        System.out.println("Valoare actuală este: " + prenume);

        double a = 12.34;
        System.out.println(Integer.valueOf((int)a));
    }

    public void calcul(Integer value) {
        value = value + 5;
        System.out.println("Valoarea nouă este: " + value);
    }

    public void concatenare(String value) {
        value = value + " Turcu";
        System.out.println("Valoarea nouă este: " + value);
    }

    public void concatenare(StringBuilder value) {
        value.append("Dorha");
        System.out.println("Valoarea nouă este: " + value);
    }

}
