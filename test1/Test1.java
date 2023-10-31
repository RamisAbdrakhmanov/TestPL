import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int step = Integer.parseInt(s[1]) - 1;

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

        br.close();
    }
}
