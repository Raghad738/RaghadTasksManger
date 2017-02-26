package raghad_12_1_2016.topspy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 12/18/2016.
 */
public class MyTelephonyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            //to get sms informations
            Bundle bundle=intent.getExtras();
            Object[] pdus=(Object[])bundle.get("pdus");
            String smsInfo="";
            String inPhoneNum="";
            for (int i=0;i<pdus.length;i++){
                SmsMessage smsMsg=SmsMessage.createFromPdu((byte[])pdus[i]);
                inPhoneNum=smsMsg.getDisplayOriginatingAddress();//incoming number
                smsInfo+="Body:"+smsMsg.getDisplayMessageBody()+"\n"+"Form:"+inPhoneNum;
            }
            Log.d("MyTelephony","SMS_RECEIED:"+smsInfo);
            Toast.makeText(context,"SMS_RECEIVED:"+smsInfo,Toast.LENGTH_LONG).show();
        }

    }


}
