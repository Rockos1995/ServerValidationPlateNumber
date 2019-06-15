
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oswal
 */
public class TestValidation {
 
    @Test
    public void testValidationDate(){
        try {
            Date dateFormat = null;
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = "2019-06-16";
            dateFormat = format.parse(date);
            cal.setTime(dateFormat);
            System.out.println("date "+ cal.get(Calendar.DAY_OF_WEEK));
        } catch (ParseException e) {
            System.out.println("Error to parse string");
        }
        
    }
    
}
