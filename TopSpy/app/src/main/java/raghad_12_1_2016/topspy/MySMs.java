package raghad_12_1_2016.topspy;

import java.util.Date;

/**
 * Created by user on 11/17/2016.
 */
public class MySMs
{
    private boolean Inout;//in =true
    private String Text;
    private String SmsNumber;
    private Date time;



    public MySMs() {
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public boolean isInout() {
        return Inout;
    }

    public void setInout(boolean inout) {
        Inout = inout;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSmsNumber() {
        return SmsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        SmsNumber = smsNumber;
    }

    @Override
    public String toString() {
        return "MySMs{" +
                "Inout=" + Inout +
                ", Text='" + Text + '\'' +
                ", SmsNumber=" + SmsNumber +
                '}';
    }
}
