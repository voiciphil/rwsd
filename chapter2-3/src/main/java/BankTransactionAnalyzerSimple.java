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

        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        System.out.println("The total for all transactions is "
            + processor.calculateTotalAmount());
        System.out.println("The total for all transactions in January is "
            + processor.calculatoTotalInMonth(Month.JANUARY));
    }
}
