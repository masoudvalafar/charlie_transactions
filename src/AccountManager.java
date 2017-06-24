import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManager {
    private Map<String, AccountType> accountsToTypeMap = new HashMap<>();
    private static AccountManager accountManager;

    public void loadAccounts(List<List<String>> accounts) {
        for (List<String> account: accounts) {
            if ("checking".equals(account.get(4))) {
                accountsToTypeMap.put(account.get(0), AccountType.CHECKING);
            } else if ("creditcard".equals(account.get(4))) {
                accountsToTypeMap.put(account.get(0), AccountType.CREDIT);
            } else if ("savings".equals(account.get(4))) {
                accountsToTypeMap.put(account.get(0), AccountType.SAVING);
            } else {
                accountsToTypeMap.put(account.get(0), AccountType.UNKNOWN);
            }
        }
    }

    public static AccountManager getAccountManager() {
        if (accountManager == null) {
            accountManager = new AccountManager();
        }
        return accountManager;
    }

    public AccountType getAccountType(String accountId) {
        return accountsToTypeMap.getOrDefault(accountId, AccountType.UNKNOWN);
    }
}
