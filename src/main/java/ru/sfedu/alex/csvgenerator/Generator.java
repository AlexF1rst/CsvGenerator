package ru.sfedu.alex.csvgenerator;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.sfedu.alex.csvgenerator.Utils.randomDate;
import static ru.sfedu.alex.csvgenerator.Utils.randomNum;
import static ru.sfedu.alex.csvgenerator.Utils.randomCustomer;


public class Generator {
    static void genType1(String path, String fileName, int recordNum) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(path+"\\"+fileName));

        List<String[]> allLines = new ArrayList();
        allLines.add(new String[]{"accountName","traffic", "date","city", "street", "homeNumber"});
        for (int i = 0; i < recordNum; i++) {
            String[] record = {randomCustomer() + " " + i, randomNum(1_000_000, 30_000_000) + "", randomDate(), "City" + randomNum(1, 100), "Street" + randomNum(1, 100), randomNum(1, 100) + ""};
            allLines.add(record);
        }
        writer.writeAll(allLines);
        writer.close();
    }

    static void genType2(String path, int recordNum) throws IOException {
        for (int i = 0; i < recordNum; i++) {
            List<String[]> allLines = new ArrayList();
            allLines.add(new String[]{"traffic", "date", "address"});
            CSVWriter writer = new CSVWriter(new FileWriter(path + "//" + randomCustomer() + " " + (i*10) + ".csv"));

            String[] record = {randomNum(100, 1000) + "", randomDate(), "City" + randomNum(1000, 1_000_000) + " Street" + randomNum(1, 100) + " " + randomNum(1, 100)};
            allLines.add(record);

            writer.writeAll(allLines);
            writer.close();
        }

    }
}
