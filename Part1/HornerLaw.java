public class HornerLaw {
    public static double calcPoly(int[] a, int x) {
        int y = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            y = a[i] + x * y;
        }

        return y;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        int x = 2;
        System.out.println(calcPoly(a, x));
    }
}
