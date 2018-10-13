package ru.sfedu.alex.csvgenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    private static Properties property = new Properties();

    static {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getConfigValue(String name) throws IOException {
            return property.getProperty(name);
    }

    public static int randomNum(int min, int max) {
        Random rnd = new Random();
        return min + rnd.nextInt(max - min + 1);
    }

    public static String randomDate(){
        GregorianCalendar cal = new GregorianCalendar(2000, 12, 12);
        Date startDate = cal.getTime();
        Date endDate = new Date();
        Date randomDate = new Date(ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime()));

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(randomDate);
        return date;
    }

    public static CustomerName randomCustomer() {
        int pick = new Random().nextInt(CustomerName.values().length);
        return CustomerName.values()[pick];
    }


}
