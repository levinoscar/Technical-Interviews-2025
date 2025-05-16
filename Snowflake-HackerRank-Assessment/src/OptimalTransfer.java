import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY capacity
     *  2. INTEGER_ARRAY fromServer
     *  3. INTEGER_ARRAY toServer
     */

    public static List<Integer> getMinCost(List<Integer> capacity, List<Integer> fromServer, List<Integer> toServer) {
        // Write your code here
        
        return null;
    }
}

public class OptimalTransfer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int capacityCount  = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> capacity = IntStream.range(0, capacityCount).mapToObj(i-> {
        try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    })

        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());
    int fromServerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> fromServer = IntStream.range(0, fromServerCount).mapToObj(i-> {
        try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    })

        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());
    int toServerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> toServer = IntStream.range(0, toServerCount).mapToObj(i-> {
        try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    })

        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());
    List<Integer> result = Result.getMinCost(capacity, fromServer, toServer);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n")) + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}
