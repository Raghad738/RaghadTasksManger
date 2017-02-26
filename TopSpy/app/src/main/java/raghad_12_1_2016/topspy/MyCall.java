package raghad_12_1_2016.topspy;

import java.util.Date;

/**
 * Created by user on 11/17/2016.
 */
public class MyCall
{
    private boolean InOut;//in= true
    private String Number;
    private String Name;
    private String File;//
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public MyCall() {
    }

    public boolean isInOut() {
        return InOut;
    }

    public void setInOut(boolean inOut) {
        InOut = inOut;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    @Override
    public String toString() {
        return "MyCall{" +
                "InOut=" + InOut +
                ", Number=" + Number +
                ", Name='" + Name + '\'' +
                ", File='" + File + '\'' +
                '}';
    }
}










