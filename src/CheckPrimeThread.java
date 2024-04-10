import java.util.ArrayList;
import java.util.List;

public class CheckPrimeThread implements Runnable {
    private static final List<Student> encryptedResults = new ArrayList<>();

    public static List<Student> getEncryptedResults() {
        return encryptedResults;
    }

    @Override
    public void run() {
        List<Student> results = CalculateAgeThread.getResults();
        encryptedResults.clear();

        for (Student result : results) {
            int sum = calculateSum(result.getDateOfBirth());
            boolean isPrime = checkPrime(sum);
            result.setSum(sum);
            result.setPrime(isPrime);
            encryptedResults.add(result);
        }

        System.out.println("Thread 3 đã kiểm tra tính nguyên tố cho tổng các chữ số.");
    }

    private int calculateSum(String dateOfBirth) {
        int sum = 0;
        for (int i = 0; i < dateOfBirth.length(); i++) {
            char c = dateOfBirth.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                sum += digit;
            }
        }
        return sum;
    }

    private boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}