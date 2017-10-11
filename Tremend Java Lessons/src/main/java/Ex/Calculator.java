package Ex;

class Calculator {

    double operand1;
    double operand2;
    String operator;

    void calculate() {
        switch (operator) {
            case "+":
                System.out.println("Result: " + (operand1 + operand2));
                break;
            case "-":
                System.out.println("Result: " + (operand1 - operand2));
                break;
            case "*":
                System.out.println("Result: " + (operand1 * operand2));
                break;
            case "/":
                System.out.println("Result: " + (operand1 / operand2));
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

}
