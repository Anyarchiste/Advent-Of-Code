import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import secret.secret;

public class App {

    public static final String PATH = secret.INPUT_WIN11;

    public static Integer answer = 0;

    public static ArrayList<Report> reports = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        File file = new File(PATH);

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {

            ArrayList<Integer> report = new ArrayList<Integer>();

            for (String level : st.split(" ")) {
                report.add(Integer.parseInt(level));
            }

            reports.add(new Report(report));

        }

        br.close();

        for (Report report : reports) {
            if (report.getSafe()) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
