package man.kuke.transaction.demo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {
    private final Map<String,List<Transaction>> transactionPool;
    private final List<String> badTransactions;

    {
        transactionPool = new LinkedHashMap<>();
        badTransactions = new LinkedList<>();
    }

    public List<String> invalidTransactions(String[] transactions) {
        for (String transaction : transactions) {
            dealElement(transaction);
        }
        dealTransactionMap(transactionPool);

        return badTransactions;
    }


    private void dealElement(String element) {
        String[] infor = element.split(",");

        Transaction transaction = new Transaction();
        transaction.setName(infor[0]);
        transaction.setInfo(element);
        transaction.setTime(Integer.parseInt(infor[1]));
        transaction.setPrice(Integer.parseInt(infor[2]));
        transaction.setCity(infor[3]);
        List<Transaction> transactions = transactionPool.computeIfAbsent(transaction.getName(), k -> new ArrayList<>());
        if (transaction.getPrice() > 1000) {
            addBadTransaction(transaction);
        }
        transactions.add(transaction);
    }

    public  void addBadTransaction(Transaction transaction ) {
         if (!transaction.isAddBad()) {
             badTransactions.add(transaction.toString());
             transaction.setAddBad(true);
         }
    }

    public  void dealTransactionMap(Map<String, List<Transaction>> transactionPool) {
        Set<String> keys = transactionPool.keySet();

        for (String key : keys) {
            List<Transaction> transactions = transactionPool.get(key);

            transactions.sort(new Comparator<Transaction>() {
                @Override
                public int compare(Transaction o1, Transaction o2) {
                    return o1.getTime() - o2.getTime();
                }

            });

            dealTransactions(transactions);
        }
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


    public  boolean isInnerTime(Transaction one, Transaction another) {
        return Math.abs(one.getTime() - another.getTime()) < 61;
    }

    public class Transaction {
        private String name;
        private int time;
        private int price;
        private String city;
        private boolean isAddBad;
        private String info;

        public void setInfo(String info) {
            this.info = info;
        }

        public boolean isAddBad() {
            return isAddBad;
        }

    public Transaction() {
        }

    public Transaction(String name, int time, int price, String city) {
            setName(name);
            setTime(time);
            setPrice(price);
            setCity(city);
        }


        public String getName() {
            return name;
        }

        public void setAddBad(boolean addBad) {
            isAddBad = addBad;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }


        @Override
        public String toString() {
            return  info;
        }
    }
}