package com.cheetah.client.tasks;

import com.cheetah.client.beans.Product;
import com.cheetah.client.constants.Constants;
import com.cheetah.client.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class ScheduledTaskReadCsv extends TimerTask {

    private Logger log = LoggerFactory.getLogger(ScheduledTaskReadCsv.class);
    private static final String CSV_DATA_DELIMITER = ";";
    private final static int TWO_AM = 2;
    private final static int ZERO_MINUTES = 0;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        processInputFile(rootPath + Constants.CSV_MOCK_DATA);
    }

    private synchronized List<Product> processInputFile(String inputFilePath) {
        List<Product> inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            log.error("ERROR: " + e.getMessage());
        }
        return inputList;
    }

    private Function<String, Product> mapToItem = (line) -> {
        String[] p = line.split(CSV_DATA_DELIMITER);
        Product item = new Product();

        int curLength = p.length;
        if (curLength > 0 && isFieldExist(p[0])) {
            item.setProduct_name(p[0]);
        }
        if (curLength > 1 && isFieldExist(p[1])) {
            item.setPhoto_url(p[1]);
        }
        if (curLength > 2 && isFieldExist(p[2])) {
            item.setBarcode(p[2]);
        }
        if (curLength > 3 && isFieldExist(p[3])) {
            item.setPrice_cents(p[3]);
        }
        if (curLength > 4 && isFieldExist(p[4])) {
            item.setSku(p[4]);
        }
        if (curLength > 5 && isFieldExist(p[5])) {
            item.setProducer(p[5]);
        }

        productRepository.save(item);
        log.debug(item.toString());
        return item;
    };

    private boolean isFieldExist(String parameter) {
        return parameter != null && parameter.trim().length() > 0;
    }

    public Date getTomorrowMorning2AM() {
        Date date2am = new java.util.Date();
        date2am.setHours(TWO_AM);
        date2am.setMinutes(ZERO_MINUTES);
        return date2am;
    }

}
