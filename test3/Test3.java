import java.io.*;
import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String t = args[0];
        String v = args[1];

        BufferedReader valuesReader = new BufferedReader(new FileReader(v));
        HashMap<Long, String> values = new HashMap<>();

        while (valuesReader.ready()) {      // разбиваем values.json на  хеш-таблицу
            String s = valuesReader.readLine().replaceAll("\\D", "");
            if (s.length() > 0) {
                long id = Long.parseLong(s);
                String[] str = valuesReader.readLine().split(" ");
                String val = str[str.length - 1];
                values.put(id, val);
            }
        }

        BufferedReader testsReader = new BufferedReader(new FileReader(t));
        BufferedWriter reportWriter = new BufferedWriter(new FileWriter("report.json"));

        while (testsReader.ready()) {
            // принцип такой, берем строку, ищем есть ли в ней id, ищем id в хеш-таблице форматируем нужную строку,
            // записываем в репорт. Все остальное просто записываем без изменений.

            String s = testsReader.readLine();

            if (s.contains("\"id\":")) {
                reportWriter.write(s);
                reportWriter.newLine();
                long id = Integer.parseInt(s.replaceAll("\\D", ""));

                if (!values.containsKey(id)) { // есть ли тест в тестовых списках, если нет то ищем дальше
                    continue;
                }

                reportWriter.write(testsReader.readLine()); // пропускаем строку с описанием
                reportWriter.newLine();

                String str = testsReader.readLine(); // далее задаем строке value нужное зачение

                boolean mark = str.charAt(str.length() - 1) == ',';
                String[] val = str.split(" ");
                if (mark) {
                    val[val.length - 1] = values.get(id) + ",";
                } else {
                    val[val.length - 1] = values.get(id);
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (String str1 : val) {
                    stringBuilder.append(str1).append(" ");
                }

                reportWriter.write(String.valueOf(stringBuilder));
                reportWriter.newLine();
            } else {
                reportWriter.write(s);
                reportWriter.newLine();
            }
        }

        valuesReader.close();
        testsReader.close();
        reportWriter.close();
    }
}
