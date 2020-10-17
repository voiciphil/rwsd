import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser parser)
        throws IOException {
        final Path path = Paths.get(RESOURCES, fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        System.out.println("The total for all transactions is "
            + processor.calculateTotalAmount());
        System.out.println("The total for all transactions in January is "
            + processor.calculateTotalInMonth(Month.JANUARY));

        final List<BankTransaction> transactionsInJanuary
            = processor.findTransactions(
                bankTransaction -> bankTransaction.getDate().getMonth().equals(Month.JANUARY));
        for (BankTransaction bankTransaction : transactionsInJanuary) {
            System.out.println(bankTransaction);
        }
    }
}
