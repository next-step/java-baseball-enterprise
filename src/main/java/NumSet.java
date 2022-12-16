public class NumSet {
    public static int[] convertToList(int num) {
        return new int[]{
                num / 100,
                num / 10 % 10,
                num % 10
        };
    }
}
