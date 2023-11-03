public class Test1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int step = Integer.parseInt(args[1]);

        int numb = 1;
        System.out.print(1);

        boolean mark = true;

        while (mark) {
            numb += step;
            if (numb > n) {
                numb %= n;
            }

            if (numb != 1) {
                System.out.print(numb);
            } else {
                mark = false;
            }
        }
    }
}
