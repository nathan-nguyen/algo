import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] freqMap = new int[1000001];
        for (List<Integer> l: queries) {
            int command = l.get(0);
            int value = l.get(1);
            if (command == 1) {
                int freq = map.getOrDefault(value, 0);

                --freqMap[freq];
                ++freqMap[++freq];
                map.put(value, freq);
            }
            else if (command == 2 && map.containsKey(value)) {
                int freq = map.get(value);

                --freqMap[freq];
                freq = Math.max(0, --freq);

                ++freqMap[freq];
                map.put(value, freq);
            }
            else if (command == 3) {
                result.add(value > 1000_000 || freqMap[value] == 0 ? 0 : 1);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

