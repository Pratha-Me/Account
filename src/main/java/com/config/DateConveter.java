/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.config.ad.AdToBs;
import com.config.bs.BsToAd;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConveter {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static String today() {
        return df.format(new Date());
    }

    public static Date toDate(String date) {
        try {
            return df.parse(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static String adToBs(Date date) {
        return new AdToBs().convet(df.format(date));
    }

    public static String adToBs(String date) {
        return new AdToBs().convet(date);
    }

    public static String bsToAd(String date) {
        return new BsToAd().convet(date);
    }

    public static Date bsToAdDate(String date) {
        try {
            return df.parse(new BsToAd().convet(date));
        } catch (Exception e) {
        }
        return null;
    }

}
