package com.alvonellos.interview.Interviews.Charter.Fidelity;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    // Let's say there's a mart contract that has a function to transfer eth to multiple addresses.
    // The receiving address can either be a smart contract that has the same functionality or a non-smart contract address.
    // If receiving address is a non-smart contract, no further nested calls happened.
    // If receiving address is a smart contract, further nested calls to transfer eth to other addresses will happen, until no further smart contract addresses involved.
    //
    // An application needs to process all eth transactions to record all of the calls that transfers eth to any of the addresses it cares about.
    // So given an execution result of a transaction that's calling this batch transfer function of a smart contract and a set of addresses, write a function to list
    // all the call ids that send eth to any of the addresses in the set.
    // Ex:
    // Inputs:
    // addresses = {"D", "E"};
    // ExecutionResult =
    // {
    //     "id": 1,
    //     "from": "A",
    //     "to": "B",
    //     "amount": 10,
    //     "calls": [
    //         {
    //             "id": 2,
    //             "from": "B",
    //             "to": "C",
    //             "amount": 4,
    //             "calls": [
    //                 {
    //                     "id": 5,
    //                     "from": "C",
    //                     "to": "D",
    //                     "amount": 2
    //                 },
    //                 {
    //                     "id": 6,
    //                     "from": "C",
    //                     "to": "Z",
    //                     "amount": 2
    //                 }
    //             ]
    //         },
    //         {
    //             "id": 3,
    //             "from": "B",
    //             "to": "E",
    //             "amount": 4
    //         },
    //         {
    //             "id": 4,
    //             "from": "B",
    //             "to": "D",
    //             "amount": 2
    //         }
    //     ]
    // }
    //
    // Output:
    // {3,4,5} // ids can be in any order
    // Explaination: Looking at the execution result, transfers with id "3","4","5" are sending fund to addresses "D" and "E",
    // which are known addresses that we care about, so return those transfer ids.
    public static void main(String[] args) {
        Set<String> addresses = new HashSet<String>(Arrays.asList("D", "E"));
        ExecutionResult seventhCall = new ExecutionResult(7, "Z", "E", 2, null);
        ExecutionResult sixthCall = new ExecutionResult(6, "C", "Z", 2, Collections.singletonList(seventhCall));
        ExecutionResult fifthCall = new ExecutionResult(5, "C", "D", 2, null);
        ExecutionResult fourthCall = new ExecutionResult(4, "B", "D", 2, null);
        ExecutionResult thirdCall = new ExecutionResult(3, "B", "E", 4, null);
        ExecutionResult secondCall = new ExecutionResult(2, "B", "C", 4, Stream.of(fifthCall, sixthCall).collect(Collectors.toList()));
        ExecutionResult firstCall = new ExecutionResult(1, "A", "B", 10, Stream.of(thirdCall, secondCall, fourthCall).collect(Collectors.toList()));

        List<Integer> result = listTransferIds(addresses, firstCall);
        System.out.println(result);

        Set<String> addresses2 = new HashSet<String>(Arrays.asList("B", "C"));

        List<Integer> result2 = listTransferIds(addresses2, firstCall);
        System.out.println(result2);


    }

    private static class ExecutionResult {
        Integer id;
        String from;
        String to;
        Integer amount;
        List<ExecutionResult> calls;

        public ExecutionResult() {}

        public ExecutionResult(Integer id, String from, String to, Integer amount, List<ExecutionResult> calls) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.amount = amount;
            this.calls = calls;
        }
    }

    public static List<Integer> listTransferIds(final Set<String> addresses, final ExecutionResult executionResult) {
        ArrayList<Integer> resultIds = new ArrayList<>();
        listTransferIds(addresses, executionResult, resultIds);
        return resultIds;
    }

    private static void listTransferIds(final Set<String> addresses, final ExecutionResult executionResult, List<Integer> result) {
        if(executionResult.calls == null) {
            if(addresses.contains(executionResult.to)) {
                result.add(executionResult.id);
            }
            return;
        }

        if(addresses.contains(executionResult.to)) {
            System.err.println("hit to" + executionResult.id);
            result.add(executionResult.id);
            for(ExecutionResult subExecutionResult : executionResult.calls) {
                listTransferIds(addresses, subExecutionResult, result);
            }
        } else {
            System.err.println("hit not it" + executionResult.id);
            for(ExecutionResult subExecutionResult : executionResult.calls) {
                listTransferIds(addresses, subExecutionResult, result);
            }
        }
    }
}
