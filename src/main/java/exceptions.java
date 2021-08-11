public class exceptions {
    public static void main(String[] args) {
        String[][] array2x2 =  {{"1","2"},{"3","4"}};
        String[][] array3x3 =  {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        String[][] array4x4 =  {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};

        System.out.println(sumArray4x4(array2x2));
        System.out.println(sumArray4x4(array3x3));
        System.out.println(sumArray4x4(array4x4));
    }

    public static int sumArray4x4(String[][] array){
        int summ=0;
        for (String[] array1: array){
            for (String array2: array1) {
                summ+= Integer.parseInt (array2);
            }
        }
        return summ;
    }
}
