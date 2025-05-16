import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getAnswersToQueries' function below.
     *
     * The function is expected to return a INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY par
     *  2. 2D_INTEGER_ARRAY query
     */

    public static List<Integer> getAnswersToQueries(List<Integer> par, List<List<Integer>> query) {
        // Write your code here
        return null;
    }

}

public class TrackCommandPosition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> par = IntStream.range(0, parCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int queryRows = Integer.parseInt(bufferedReader.readLine().trim());
        int queryColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> query = new ArrayList<>();

        IntStream.range(0, queryRows).forEach(i -> {
            try {
                query.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(String::trim)
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.getAnswersToQueries(par, query);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}