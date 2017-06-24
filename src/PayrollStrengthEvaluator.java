import java.util.List;
import java.util.Map;

public class PayrollStrengthEvaluator {

    public static void evaluate(List<Transaction> transactions, AccountManager accountManager) {

        for (Transaction transaction: transactions) {
            // based on account type
            AccountType accountType = accountManager.getAccountType(transaction.accountId);
            if (accountType == AccountType.CHECKING) {
                transaction.paycheckSignalStrength = transaction.paycheckSignalStrength + 1;
            } else if (accountType == AccountType.SAVING) {
                transaction.paycheckSignalStrength = transaction.paycheckSignalStrength + 2;
            } else {
                transaction.paycheckSignalStrength = transaction.paycheckSignalStrength - 1;
            }

            // based on name
            if(transaction.name.toLowerCase().contains("payroll") || transaction.name.toLowerCase().contains("dir dep")) {
                transaction.paycheckSignalStrength = transaction.paycheckSignalStrength + 5;
            }

            // based on value being neg
            if (transaction.quantity > 0) {
                transaction.paycheckSignalStrength = transaction.paycheckSignalStrength - 10;
            }
        }
    }
}
