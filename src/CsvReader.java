import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvReader {
    public static List<List<String>> readFile(String fileAddr) {
        List<List<String>> results = new ArrayList<List<String>>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(fileAddr));
            while ((line = br.readLine()) != null) {
                List input = new ArrayList<>(Arrays.asList(line.split(cvsSplitBy)));
                results.add(input);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return results;
    }
}
