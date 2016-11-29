import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.lang.Math.abs;

/**
 * Created by Gennady on 29.11.2016.
 */
public class DataHelper {
    private GregorianCalendar start,finish;

    public DataHelper(){
        start=new GregorianCalendar();
        finish=new GregorianCalendar();
        start.add(Calendar.YEAR,-1500);
        finish.add(Calendar.YEAR,-1500);
    }

    public String getFormattedStartDate() {
        return start.get(Calendar.DAY_OF_MONTH)+"."+start.get(Calendar.MONTH)+"."+start.get(Calendar.YEAR)+" "+start.get(Calendar.HOUR)+":"+start.get(Calendar.MINUTE);
    }

    public void skipTime() {
        finish.add(Calendar.HOUR,1);
    }

    public String getFormattedFinishDate() {
        return finish.get(Calendar.DAY_OF_MONTH)+"."+finish.get(Calendar.MONTH)
                +"."+finish.get(Calendar.YEAR)
                +" "+finish.get(Calendar.HOUR)
                +":"+finish.get(Calendar.MINUTE);

    }

    public String getFormattedDiff() {
        return "After "+
                ((abs(finish.get(Calendar.MONTH)-start.get(Calendar.MONTH))))+" months, "
                +(abs(finish.get(Calendar.DAY_OF_MONTH)-start.get(Calendar.DAY_OF_MONTH)))+" days "
                +(abs(finish.get(Calendar.HOUR)-start.get(Calendar.HOUR))+" hours");
    }

}
