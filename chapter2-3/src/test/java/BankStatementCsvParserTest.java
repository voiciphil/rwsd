import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

public class BankStatementCsvParserTest {

    private final BankStatementParser parser = new BankStatementCsvParser();

    @Test
    public void shouldParseOneCorrectLine() {
        String line = "17-10-2020,4700,Lemonade";

        final BankTransaction actual = parser.parseFrom(line);
        final BankTransaction expected
            = new BankTransaction(LocalDate.of(2020, Month.OCTOBER, 17), 4700, "Lemonade");

        Assert.assertEquals(expected, actual);
    }
}
