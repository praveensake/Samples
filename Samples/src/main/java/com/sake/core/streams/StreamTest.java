package com.sake.core.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by sakez on 7/31/17
 * Add description here
 */
public class StreamTest {

    public static void main(String[] args) {

         Trader raoul = new Trader("Raoul", "Cambridge");
         Trader mario = new Trader("Mario", "Milan");
         Trader alan = new Trader("Alan", "Cambridge");
         Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(raoul, 2012, 700),
                new Transaction(alan, 2012, 950)

        );


        //All transactions in the year 2011 sorted by value
        List<Transaction> transactions2011 = transactionList.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("All transactions from 2011: "+transactions2011);

        //All the unique cities where traders work
        List<String> uniqueCities = transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique cities: "+uniqueCities);

        //All traders from Cambridge and sort them by name
        List<Trader> cambridgeTraders = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("Traders from Cambridge: "+cambridgeTraders);

        //Return a string of all trader names sorted alphabetically
        String traderStr = transactionList.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);

        //Are any traders based in milan
        boolean milan = transactionList.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("Any trader in Milan: "+milan);

        //Print all transaction values from traders living in cambridge
        transactionList.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);

        //What's the highest value of all transactions
        Optional<Integer> max = transactionList.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max);
        System.out.println("Max Value: "+max);

        //Find the transaction with the smallest value
        Optional<Transaction> smallestTransaction = transactionList.stream()
                .reduce((t1, t2) -> t1.getValue()< t2.getValue()?t1:t2);
        System.out.println("Smallest Transaction: "+smallestTransaction.get());

        //Find the transaction with the smallest value -> Optimized
        Optional<Transaction> smallestTransaction1 = transactionList.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("Smallest Transaction1: "+smallestTransaction1.get());


    }

}
