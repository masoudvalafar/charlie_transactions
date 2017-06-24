import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    public static List<Transaction> readTransactionTable(List<List<String>> transactionsTable) {
        List<Transaction> transactions = new ArrayList();
        // skipping the first input line as it is the name of the columns
        for (List<String> transaction: transactionsTable.subList(1, transactionsTable.size())){
            transactions.add(new Transaction(transaction.get(0), transaction.get(1), transaction.get(2), transaction.get(3)));
        }
        return transactions;
    }
}
