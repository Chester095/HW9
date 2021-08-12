public class exceptions {
    public static void main(String[] args) {
        String[][] array3x3 = {{"1", "2", "3" }, {"4", "5", "6" }, {"7", "8", "9" }};
        String[][] array4x3 = {{"1", "2", "3" }, {"5", "6", "7" }, {"9", "10", "11" }, {"9", "10", "11" }};
        String[][] array4x4 = {{"1", "2", "3", "4" }, {"5", "6", "g", "8" }, {"9", "10", "11", "12" }, {"13", "14", "15", "16" }};
        String[][] array4x4_2 = {{"1", "2", "3", "4" }, {"5", "6", "9", "8" }, {"9", "10", "11", "12" }, {"13", "14", "15", "16" }};

        try {System.out.println("Сумма элементов массива = " + sumArray(array3x3));
        } catch (ArrayOutOf4x4Exception | MyArrayDataException e) {e.printStackTrace();}

        try {System.out.println("Сумма элементов массива = " + sumArray(array4x3));
        } catch (ArrayOutOf4x4Exception | MyArrayDataException e) {e.printStackTrace();}

        try {System.out.println("Сумма элементов массива = " + sumArray(array4x4));
        } catch (ArrayOutOf4x4Exception | MyArrayDataException e) {e.printStackTrace();}

        try {System.out.println("Сумма элементов массива = " + sumArray(array4x4_2));
        } catch (ArrayOutOf4x4Exception | MyArrayDataException e) {e.printStackTrace();}
    }

    public static int sumArray(String[][] array) throws ArrayOutOf4x4Exception, MyArrayDataException {
        int summ = 0;
        if (array.length == 4) {
            for (int j = 0, arrayLength = array.length; j < arrayLength; j++) {
                String[] array1 = array[j];
                if (array1.length == 4) {
                    for (int i = 0, array1Length = array1.length; i < array1Length; i++) {
                        String array2 = array1[i];
                        try {
                            summ += Integer.parseInt(array2);
                        } catch (NumberFormatException ex) {
                            throw new MyArrayDataException(i, j, array2);
                        }
                    }
                } else {
                    throw new ArrayOutOf4x4Exception("Кол-во столбцов массива не равно 4");
                }
            }
            return summ;
        } else {
            throw new ArrayOutOf4x4Exception("Кол-во строк массива не равно 4");
        }
    }


    static class ArrayOutOf4x4Exception extends Exception {
        public ArrayOutOf4x4Exception(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(int x, int y, String text) {
            System.out.println("В строке " + (y + 1) + " столбца " + (x + 1) + " находится не число, а символ - '" + text + "' !!!");
        }

    }
}
