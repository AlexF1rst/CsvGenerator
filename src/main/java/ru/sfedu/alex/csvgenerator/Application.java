package ru.sfedu.alex.csvgenerator;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Generator.genType1(Utils.getConfigValue("path.type1"),"customers.csv",100);
        Generator.genType2(Utils.getConfigValue("path.type2"),100);
    }
}
