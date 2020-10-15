import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
        BankStatementParser parser = new BankStatementCsvParser();
        analyzer.analyze("transactions.csv", parser);
    }
}
