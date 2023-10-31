import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        String[] str = fileReader1.readLine().split(" ");
        double radius = Integer.parseInt(fileReader1.readLine());
        float[] center = new float[2];
        center[0] = Float.parseFloat(str[0]);
        center[1] = Float.parseFloat(str[1]);


        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));

        while (fileReader2.ready()) {
            String[] point = fileReader2.readLine().split(" ");

            float leg1 = Math.abs(center[0] - Float.parseFloat(point[0]));
            float leg2 = Math.abs(center[1] - Float.parseFloat(point[1]));

            double distance = Math.sqrt((leg1 * leg1) + (leg2 * leg2));

            if (distance < radius) {
                System.out.println(1);
            } else if (distance > radius) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }

        br.close();
        fileReader1.close();
    }
}
