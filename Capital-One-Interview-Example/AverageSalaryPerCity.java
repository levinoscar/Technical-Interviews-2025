import java.util.*;

// This class is NOT public, so it can live in the same file
class SalaryDetails {
    double totalSalary;
    int numOfRecords;
    double cityAverageSalary;

    public SalaryDetails() {
        this.totalSalary = 0;
        this.numOfRecords = 0;
        this.cityAverageSalary = 0;
    }

    public void addSalary(double salary) {
        this.totalSalary += salary;
        this.numOfRecords++;
    }

    public void calculateAverage() {
        if (numOfRecords > 0) {
            this.cityAverageSalary = totalSalary / numOfRecords;
        }
    }

    @Override
    public String toString() {
        return String.format("SalaryDetails<totalSalary: %.2f, numRecords: %d, average: %.2f>",
                totalSalary, numOfRecords, cityAverageSalary);
    }
}

// This is the public class (must match the filename)
public class AverageSalaryPerCity {

    public static Map<String, SalaryDetails> computeAverageSalaries(List<String> cities, List<Double> salaries) {
        Map<String, SalaryDetails> averageSalaryMap = new HashMap<>();

        for (int i = 0; i < cities.size(); i++) {
            String city = cities.get(i);
            double salary = salaries.get(i);

            SalaryDetails details = averageSalaryMap.getOrDefault(city, new SalaryDetails());
            details.addSalary(salary);
            averageSalaryMap.put(city, details);
        }

        for (SalaryDetails details : averageSalaryMap.values()) {
            details.calculateAverage();
        }

        return averageSalaryMap;
    }

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Dover", "Washington DC", "New York City", "Dover", "Dallas", "Dover", "Washington DC");
        List<Double> salaries = Arrays.asList(80000.0, 150000.0, 200000.0, 60000.0, 58000.0, 160000.0, 100000.0);

        Map<String, SalaryDetails> result = computeAverageSalaries(cities, salaries);

        for (Map.Entry<String, SalaryDetails> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

/* 
 * # starting values Lowest = integer.MIN_VALUE Highest = integer.MAX_VALUE CityWithLowestSalary = Dover CityWithHighestSalary = Dover  # at the end Lowest = 58000 Highest = 200000 CityWithLowestSalary = Dallas CityWithHighestSalary = NYC 
*/