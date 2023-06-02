package PriorityQueue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
华为OD机试 - 打印机队列
 */
public class Printer_Queue {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<PriorityQueue<Document>> storeQueue = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i <= 5; i++) {
            storeQueue.add(new PriorityQueue<Document>( (a, b) -> a.documentPriority == b.documentPriority ? a.document_Num - b.document_Num : b.documentPriority - a.documentPriority  ));
        }
        //注意打印机的个数 Or 下标

        int documentCount = 0;
        while (N-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            if ("IN".equals(input[0])) {
                intputString(Integer.parseInt(input[1]), Integer.parseInt(input[2]), ++documentCount);
            } else {
                writer.write(outputString(Integer.parseInt(input[1])));
                writer.newLine();
            }
        }
        writer.flush();
    }

    public static String outputString(int printLocation) {
        PriorityQueue<Document> documents = storeQueue.get(printLocation);
        if (documents.isEmpty()) {
            return "NULL";
        } else {
            return String.valueOf(documents.poll().document_Num);
        }
    }

    public static void intputString(int documentPrintLocation, int documentPriority, int document_Num) {
        PriorityQueue<Document> documents = storeQueue.get(documentPrintLocation);
        documents.add(new Document(documentPriority, document_Num));
    }

    static class Document {
        int documentPriority;
        int document_Num;

        public Document() {

        }

        public Document(int documentPriority, int document_Num) {
            this.documentPriority = documentPriority;
            this.document_Num = document_Num;
        }

    }

}

