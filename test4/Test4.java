import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) throws IOException {
        String s = args[0];

        List<Integer> list = new ArrayList<>();

        BufferedReader file = new BufferedReader(new FileReader(s));
        while (file.ready()) {
            list.add(Integer.valueOf(file.readLine()));
        }
        file.close();

        int sum = 0;
        int mid = list.get(list.size() / 2);

        for (int i : list) {
            sum += Math.abs(mid - i);
        }

        System.out.println(sum);
    }
}
