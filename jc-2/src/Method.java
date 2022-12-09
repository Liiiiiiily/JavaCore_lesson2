public class Method {

    static String[][] massive1 = {{"98", "25", "352", "562"}, {"2432", "zcvx", "324q", "fsd"}, {"649", "ш", "736", "85"}, {"2345", "75436", "790808", "813212"}};
    static String[][] massive2 = {{"1", "2"}, {"0", "6",}, {"9", "9"}, {"5", "6"}};
    static String[][] massive3 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "8", "7", "6"}, {"5", "4", "3", "2"}};

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {

        try {
            System.out.println("Sum of it is " + getSum(massive1));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Sum of it is " + getSum(massive2));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Sum of it is " + getSum(massive3));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void checkValue(String[][] array) throws MyArraySizeException {
        if (array.length != sizeA || array[0].length != sizeB) throw new MyArraySizeException();
    }

    static Integer getSum(String[][] array) throws MyArrayDataException, MyArraySizeException {
        checkValue(array);
        Integer answer = 0;
        int i = 0;
        int j = 0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array.length; j++) {
                    answer = answer + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Error in this position: " + i + ", " + j);
        }

        return answer;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Error of size! ");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}


//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
//При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
// и вывести результат расчета.
