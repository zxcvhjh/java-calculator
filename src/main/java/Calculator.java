import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private String[] splitInput(String input) {

        String delimiter = ",|:";
        return input.split(delimiter);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Calculator calculator = new Calculator();
    }
}
