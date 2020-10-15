import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/transactions.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementCsvParser parser = new BankStatementCsvParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = parser.parseLinesFromCsv(lines);

        System.out.println("The total for all transactions is "
            + calculateTotalAmount(bankTransactions));
        System.out.println("The total for all transactions in January is "
            + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static double selectInMonth(final List<BankTransaction> bankTransactions,
        final Month month) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth().equals(month)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
