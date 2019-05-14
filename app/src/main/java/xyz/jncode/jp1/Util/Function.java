package xyz.jncode.jp1.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {

    public static final String getDateString(String inputdate) throws ParseException {


                String realDate = inputdate.substring(0,10);

                //DateFormat df = new SimpleDateFormat("dd-MMMM HH:mm a");
                DateFormat df = new SimpleDateFormat("dd MMMM YYYY ");
                SimpleDateFormat formatStringtoDate=new SimpleDateFormat("dd-MMM-yyyy");

                //Date date = new Date(System.currentTimeMillis());
                Date date = formatStringtoDate.parse(inputdate);
                String infi = df.format(date);


                return infi;


    }
}
