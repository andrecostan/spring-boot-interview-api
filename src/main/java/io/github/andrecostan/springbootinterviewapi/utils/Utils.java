package io.github.andrecostan.springbootinterviewapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static Date formatarData(String data, String formato) {
        SimpleDateFormat sdt = new SimpleDateFormat(formato);
        try {
            return sdt.parse(data);
        } catch (ParseException e) {
            log.error("Erro ao formatar data: {} com formato: {}", data, formato);
            return null;
        }
    }

    public static String formatarData(Date data, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String dataFormatada = sdf.format(data);
        return dataFormatada;
    }

    public static int idade(Date nascimento) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(nascimento));
        int d2 = Integer.parseInt(formatter.format(new Date()));
        int age = (d2 - d1)/10000;
        return age;
    }
}
