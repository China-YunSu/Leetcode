package man.kuke.transaction.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionFactory {
    private final Map<String,List<Transaction>> transactionPool;
    private final TransactionProcessor processor;

    {
        transactionPool = new HashMap<>();
    }

    public TransactionFactory(TransactionProcessor processor) {
        this.processor = processor;
    }

    public  void dataInput(String inputData) {
        int begin = inputData.indexOf('[') + 1;
        int end = inputData.indexOf(']');
        String substring = inputData.substring(begin, end);
        String[] split = substring.split("\"");

        for (String element : split) {
            if (element.length() <= 1) {
                continue;
            }

            Transaction transaction = creatTransaction(element);
            processor.dealTransaction(transaction);
            List<Transaction> transactions = transactionPool.computeIfAbsent(transaction.getName(), k -> new ArrayList<>());
            transactions.add(transaction);
        }
        processor.dealTransactionMap(transactionPool);
    }

    private Transaction creatTransaction(String element) {
        String[] infor = element.split(",");

        Transaction transaction = new Transaction();
        transaction.setName(infor[0]);
        transaction.setInfo(element);
        transaction.setTime(Integer.parseInt(infor[1]));
        transaction.setPrice(Integer.parseInt(infor[2]));
        transaction.setCity(infor[3]);

        return transaction;
    }


    public List<String> getBadTransaction() {
        return processor.getBadList();
    }


}
