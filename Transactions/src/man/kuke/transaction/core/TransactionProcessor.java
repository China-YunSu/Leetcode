package man.kuke.transaction.core;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionProcessor {
    private final List<String> badTransactions;

    {
        badTransactions = new ArrayList<>();
    }


    private void addBadTransaction(Transaction transaction ) {
        if (!transaction.isAddBad()) {
            badTransactions.add(transaction.toString());
            transaction.setAddBad(true);
        }
    }

    public  void dealTransactionMap(Map<String, List<Transaction>> transactionPool) {
        Set<String> keys = transactionPool.keySet();

        for (String key : keys) {
            List<Transaction> transactions = transactionPool.get(key);

            transactions.sort((o1, o2) -> o1.getTime() - o2.getTime());

            dealTransactions(transactions);
        }
    }

    public void dealTransaction(Transaction transaction) {
        if (transaction.getPrice() > 1000) {
            addBadTransaction(transaction);
        }
    }

    private  boolean isInnerTime(Transaction one, Transaction another) {
        return Math.abs(one.getTime() - another.getTime()) < 61;
    }

    private  void dealTransactions(List<Transaction> transactions) {
        for (int i = 0; i + 1 < transactions.size(); i++) {
            Transaction one = transactions.get(i);
            for (int j = i + 1; j < transactions.size(); j++) {
                Transaction another = transactions.get(j);
                if (isInnerTime(one,another)
                        && !one.getCity().equalsIgnoreCase(another.getCity())) {
                    addBadTransaction(one);
                    addBadTransaction(another);
                }
            }
        }
    }

    public List<String> getBadList() {
        return badTransactions;
    }


}
