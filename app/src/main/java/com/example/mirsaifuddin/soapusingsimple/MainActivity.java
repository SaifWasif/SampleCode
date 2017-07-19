package com.example.mirsaifuddin.soapusingsimple;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String SOAP_ACTION = "http://tempuri.org/IConnectPoint_Security/RetrieveSecurityToken";
    private static final String URLLink = "http://rq.connectpoint.uat.radixx.com/ConnectPoint.Security.svc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new runTask().execute();
        //unMarSheller("HEHEHE");
    }

    private class runTask extends AsyncTask<String, String, String> {

        private String response;

        @Override
        protected String doInBackground(String... params) {

            try {

                String body = convertStreamToString(getAssets().open("requestToken.xml"));
                Log.e("body", body);

                try {
                    URL url = new URL(URLLink);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setDefaultUseCaches(false);
                    conn.setRequestProperty("Content-Type", "text/xml");
                    conn.setRequestProperty("SOAPAction", SOAP_ACTION);

                    //push the request to the server address

                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(body);
                    wr.flush();

                    //get the server response

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    String line = null;

                    while ((line = reader.readLine()) != null) {


                        builder.append(line);
                        response = builder.toString();//this is the response, parse it in onPostExecute

                    }


                } catch (Exception e) {

                    e.printStackTrace();
                } finally {

                    try {

                        //reader.close();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }


            } catch (Exception e) {

                e.printStackTrace();
            }

            return response;
        }


        @Override
        protected void onPostExecute(String response) {

            Log.e("response", "answer");
            try {
                Log.e("response", response);
                unMarSheller(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String convertStreamToString(InputStream is) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            return sb.toString();
        }
    }

    private void unMarSheller(String response) {
        Serializer serializerRequest = new Persister();
        Serializer serializerResponse = new Persister();

        com.example.mirsaifuddin.soapusingsimple.model.response.Envelope envelopeRequest = null;
        com.example.mirsaifuddin.soapusingsimple.model.request.Envelope envelopeResponse = null;

        try {
            envelopeRequest = serializerRequest.read(com.example.mirsaifuddin.soapusingsimple.model.response.Envelope.class, getAssets().open("requestToken.xml"), false);
            envelopeResponse = serializerResponse.read(com.example.mirsaifuddin.soapusingsimple.model.request.Envelope.class, response, false);
        } catch (Exception e) {
            Log.e("CATCH", e.toString());
            e.printStackTrace();
        }
        if (envelopeRequest != null) {
            Log.e("Request", envelopeRequest.toString());
        } else {
            Log.e("ERROR", "ERROR");
        }
        if (envelopeResponse != null) {
            Log.e("RESPONSE", envelopeResponse.toString());
        } else {
            Log.e("ERROR", "ERROR");
        }
    }
}
