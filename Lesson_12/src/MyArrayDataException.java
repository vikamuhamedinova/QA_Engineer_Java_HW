public class MyArrayDataException extends NumberFormatException {
    int index1;
    int index2;

    public MyArrayDataException(String message, int i, int j) {
        super(message);
        index1 = i;
        index2 = j;
    }

    public String getIndicesData() {
        return " в ячейке " + index1 + " " + index2;
    }
}
