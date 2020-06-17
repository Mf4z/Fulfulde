package com.example.mf4z.fulfulde;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    boolean mIsTwitterInstalled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mIsTwitterInstalled = isTwitterInstalled();

    }


    //Launch Twitter to Follow
    public void gotoTwitter(View view){

        if(mIsTwitterInstalled) {
            Intent intent = null;
            try {
                // get the Twitter app if possible
                this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=Mf4z"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Twitter app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Mf4z"));
            }
            this.startActivity(intent);
        }
        else {

            String url = "https://twitter.com/Mf4z";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
    }


    public void gotoGitHub(View view){

        String url = "https://github.com/Mf4z";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }




    public void gotoLinkedIn(View view){

        String url = "https://www.linkedin.com/in/marwan-mai-5a4975164/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void sendMail(View view){


        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "emef4z@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "I love your Fulfulde App");
        email.putExtra(Intent.EXTRA_TEXT, "Hello Marwan,");

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Send email"));
    }






    //Check if Twitter is installed
    private boolean isTwitterInstalled() {
        try {
            boolean twitterInstalled = false;
            PackageInfo packageInfo = getPackageManager().getPackageInfo("com.twitter.android", 0);
            String getPackageName = packageInfo.toString();
            if (getPackageName.equals("com.twitter.android")) {
               // Toast.makeText(this, "Twitter App is installed on device!", Toast.LENGTH_LONG).show();
                twitterInstalled = true;
                return  twitterInstalled;
            }
        } catch (PackageManager.NameNotFoundException e) {
           // Toast.makeText(this, "Twitter App not found on device!", Toast.LENGTH_LONG).show();

        }

        return false;
    }
}
