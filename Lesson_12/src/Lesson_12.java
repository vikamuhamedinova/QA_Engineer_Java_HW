public class Lesson_12 {
    public static void main(String[] args) {
        String array[][] = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        int sum = 0;
        try {
            sum = sumElementsArray(array);
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.print(ex.getMessage());
            System.out.println(ex.getIndicesData());
        }
        System.out.println(sum);
    }

    public static int sumElementsArray(String array[][]) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива не соответствует 4x4.");
        } else {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new MyArrayDataException("Неверный формат данных", i, j);
                    }
                }
            }
            return sum;
        }
    }
}
