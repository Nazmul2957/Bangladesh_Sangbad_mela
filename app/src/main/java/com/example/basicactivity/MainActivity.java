package com.example.basicactivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    FloatingActionButton fab;

    String
            home_url = "https://www.bdsangbadmela.com/" ,

            national_url = "https://www.bdsangbadmela.com/category/%E0%A6%9C%E0%A6%BE%E0%A6%A4%E0%A7%80%E0%A7%9F/" ,

            politics_url = "https://www.bdsangbadmela.com/category/%E0%A6%B0%E0%A6%BE%E0%A6%9C%E0%A6%A8%E0%A7%80%E0%A6%A4%E0%A6%BF/",

            economics_url = "https://www.bdsangbadmela.com/category/%E0%A6%85%E0%A6%B0%E0%A7%8D%E0%A6%A5%E0%A6%A8%E0%A7%80%E0%A6%A4%E0%A6%BF/",

            sports_url = "https://www.bdsangbadmela.com/category/%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC%E0%A6%95%E0%A6%BE%E0%A6%AA-%E0%A6%AB%E0%A7%81%E0%A6%9F%E0%A6%AC%E0%A6%B2/",

            capital_url = "https://www.bdsangbadmela.com/category/%E0%A6%B0%E0%A6%BE%E0%A6%9C%E0%A6%A7%E0%A6%BE%E0%A6%A8%E0%A7%80/",

            law_url="https://www.bdsangbadmela.com/category/%E0%A6%95%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%87%E0%A6%AE-%E0%A6%A8%E0%A6%BF%E0%A6%89%E0%A6%9C/",

            science_url = "https://www.bdsangbadmela.com/category/%E0%A6%AC%E0%A6%BF%E0%A6%9C%E0%A7%8D%E0%A6%9E%E0%A6%BE%E0%A6%A8-%E0%A6%93-%E0%A6%9F%E0%A7%87%E0%A6%95/",

            entertainment_url = "https://www.bdsangbadmela.com/category/%E0%A6%AC%E0%A6%BF%E0%A6%A8%E0%A7%8B%E0%A6%A6%E0%A6%A8-%E0%A6%B8%E0%A6%82%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A7%83%E0%A6%A4%E0%A6%BF/",

            international_url = "https://www.bdsangbadmela.com/category/%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC-%E0%A6%B8%E0%A6%82%E0%A6%AC%E0%A6%BE%E0%A6%A6/",

            ak_alip="https://www.bdsangbadmela.com/category/%E0%A6%8F%E0%A6%95-%E0%A6%B8%E0%A7%8D%E0%A6%B2%E0%A6%BF%E0%A6%AA/",

            country_url = "https://www.bdsangbadmela.com/category/%E0%A6%B8%E0%A6%BE%E0%A6%B0%E0%A6%BE%E0%A6%A6%E0%A7%87%E0%A6%B6/",

            education_url = "https://www.bdsangbadmela.com/category/%E0%A6%B6%E0%A6%BF%E0%A6%95%E0%A7%8D%E0%A6%B7%E0%A6%BE%E0%A6%99%E0%A7%8D%E0%A6%97%E0%A6%A8/",

            media_url="https://www.bdsangbadmela.com/category/%E0%A6%AE%E0%A6%BF%E0%A6%A1%E0%A6%BF%E0%A7%9F%E0%A6%BE-%E0%A6%A8%E0%A6%BF%E0%A6%89%E0%A6%9C/",

            health_url="https://www.bdsangbadmela.com/category/%E0%A6%B8%E0%A7%8D%E0%A6%AC%E0%A6%BE%E0%A6%B8%E0%A7%8D%E0%A6%A5%E0%A7%8D%E0%A6%AF/",

            football_url="https://www.bdsangbadmela.com/category/%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC%E0%A6%95%E0%A6%BE%E0%A6%AA-%E0%A6%AB%E0%A7%81%E0%A6%9F%E0%A6%AC%E0%A6%B2/",

            corporate_url="https://www.bdsangbadmela.com/category/%E0%A6%95%E0%A6%B0%E0%A7%8D%E0%A6%AA%E0%A7%8B%E0%A6%B0%E0%A7%87%E0%A6%9F-%E0%A6%A8%E0%A6%BF%E0%A6%89%E0%A6%9C/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //find view id

        gridView = findViewById(R.id.gridView);
        fab = findViewById(R.id.fab);



        CustomAdaptar adaptar = new CustomAdaptar(this,getData());
        gridView.setAdapter(adaptar);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    if(checkInternet()){

                        Intent electricianIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        electricianIntent.putExtra("home_key", home_url);
                        startActivity(electricianIntent);
                    }
                    else{

                    }

                }else if(position == 1){

                    if(checkInternet()){
                        Intent automobilemechanicIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        automobilemechanicIntent.putExtra("national_key", national_url);
                        startActivity(automobilemechanicIntent);
                    }
                    else {
                    }
                }
                else if(position == 2){

                    if(checkInternet()){
                        Intent electronicsmechanicIntent = new Intent(MainActivity.this,DetailsActivity.class);
                        electronicsmechanicIntent.putExtra("politics_key", politics_url);
                        startActivity(electronicsmechanicIntent);
                    }
                    else{
                    }
                }
                else if(position == 3){

                    if(checkInternet()){
                        Intent carpenterIntent = new Intent(MainActivity.this,DetailsActivity.class);
                        carpenterIntent.putExtra("economics_key", economics_url);
                        startActivity(carpenterIntent);
                    }
                    else{
                    }
                }
                else if(position == 4){

                    if(checkInternet()){
                        Intent housepainterIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        housepainterIntent.putExtra("sports_key", sports_url);
                        startActivity(housepainterIntent);
                    }
                    else{
                    }
                }
                else if(position == 5){

                    if(checkInternet()){
                        Intent ac_fridegemechanicIntent = new Intent(MainActivity.this,DetailsActivity.class);
                        ac_fridegemechanicIntent.putExtra("capital_key", capital_url);
                        startActivity(ac_fridegemechanicIntent);
                    }
                    else{
                    }
                }
                else if(position == 6){

                    if(checkInternet()){
                        Intent measonIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        measonIntent.putExtra("law_url", law_url);
                        startActivity(measonIntent);
                    }
                    else{
                    }
                }
                else if(position == 7) {
                    if (checkInternet()) {
                        Intent plumberaIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        plumberaIntent.putExtra("science_key", science_url);
                        startActivity(plumberaIntent);
                    } else {

                    }
                }
                    else if (position==8){
                        if (checkInternet()){
                            Intent plumberXIntent = new Intent(MainActivity.this,DetailsActivity.class);
                            plumberXIntent.putExtra("entertainment_key",entertainment_url);
                            startActivity(plumberXIntent);
                        }
                        else{

                        }
                    }

                    else if(position == 9){

                    if(checkInternet()){
                        Intent plumbertIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        plumbertIntent.putExtra("international_key", international_url);
                        startActivity(plumbertIntent);
                    }
                    else{
                    }
                }
                else if(position == 10){

                    if(checkInternet()){
                        Intent plumberrIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        plumberrIntent.putExtra("akslip_key", ak_alip);
                        startActivity(plumberrIntent);
                    }
                    else {
                    }
                }
                else if(position == 11){

                    if(checkInternet()){
                        Intent plumberyIntent = new Intent(MainActivity.this,DetailsActivity.class);
                        plumberyIntent.putExtra("country_key", country_url);
                        startActivity(plumberyIntent);
                    }
                    else{
                    }
                }
                else if(position == 12){

                    if(checkInternet()){
                        Intent plumbertyIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        plumbertyIntent.putExtra("education_key", education_url);
                        startActivity(plumbertyIntent);
                    }
                    else{
                    }
                }
                else if(position == 13){

                    if(checkInternet()){
                        Intent plumberXIntent = new Intent(MainActivity.this, DetailsActivity.class);
                        plumberXIntent.putExtra("media_key", media_url);
                        startActivity(plumberXIntent);
                    }
                   else{
                    }
                }
                else if (position==14){
                        if (checkInternet()){
                            Intent plumberXIntent = new Intent(MainActivity.this,DetailsActivity.class);
                            plumberXIntent.putExtra("health_key",health_url);
                            startActivity(plumberXIntent);
                        }
                        else {
                        }
                    }
                    else if (position==15){
                        if (checkInternet()){
                            Intent plumberXIntent = new Intent(MainActivity.this,DetailsActivity.class);
                            plumberXIntent.putExtra("football_key",football_url);
                            startActivity(plumberXIntent);
                        }
                        else {

                        }
                    }
                    else if (position==16){
                        if (checkInternet()){
                            Intent plumberXIntent = new Intent(MainActivity.this,DetailsActivity.class);
                            plumberXIntent.putExtra("corporate_key",corporate_url);
                            startActivity(plumberXIntent);
                        }
                        else{
                        }
                    }
            }

        });


       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,ListviewActivity.class);
               startActivity(intent);

           }
       });

    }


            ///////GET DATA METHOD

    private ArrayList getData()
    {
        ArrayList<Model> models = new ArrayList<>();

        Model s=new Model();
        s.setName(getString(R.string.home));
        s.setImage(R.drawable.home_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.jatio));
        s.setImage(R.drawable.national_ico);
        models.add(s);


        s=new Model();
        s.setName(getString(R.string.rajniti));
        s.setImage(R.drawable.politics_ico);
        models.add(s);


        s=new Model();
        s.setName(getString(R.string.orthoniti));
        s.setImage(R.drawable.economy_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.kheladhula));
        s.setImage(R.drawable.sports_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.rajdhani));
        s.setImage(R.drawable.capital_logo);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.law));
        s.setImage(R.drawable.law);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.bigan));
        s.setImage(R.drawable.science_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.binodon));
        s.setImage(R.drawable.entertainment_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.bishosongbad));
        s.setImage(R.drawable.intenationa_news_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.ekslip));
        s.setImage(R.drawable.lifestyle_logo);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.saradesh));
        s.setImage(R.drawable.country_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.sikshaongon));
        s.setImage(R.drawable.education_ico);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.media));
        s.setImage(R.drawable.media_icon);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.health));
        s.setImage(R.drawable.health);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.football));
        s.setImage(R.drawable.football);
        models.add(s);

        s=new Model();
        s.setName(getString(R.string.corporate));
        s.setImage(R.drawable.corporate);
        models.add(s);


        return models;
    }

            ////CHECKINTERNET METHOD


    public boolean checkInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
