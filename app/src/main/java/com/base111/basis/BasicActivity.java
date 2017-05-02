package com.base111.basis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BasicActivity extends AppCompatActivity {

    String[] titles = {"Maths","English","Igbo","Science"};
    String[] desc = {"Maths is not evil","Learn rudiments of English",
                       "Basics of ancient language","Foundations of Science"};
    int[] images = {R.drawable.math_icon,R.drawable.eng_icon,
                     R.drawable.igbo_icon,R.drawable.sci_icon};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        lv = (ListView)findViewById(R.id.idListView);

        MyAdapter adapter = new MyAdapter(getApplicationContext(),titles,desc,images);
        lv.setAdapter(adapter);

        //set on click listener for list view
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int posn, long id) {
                if (posn==0){
                    Intent math = new Intent(BasicActivity.this,MathActivity.class);
                    startActivity(math);
                }
            }
        });
    }// end of on create
}//end of base activity class

   //adapter class
   class MyAdapter extends ArrayAdapter {
       int[] imageArray;
       String[] titleArray;
       String[] descArray;

       //override default constructor of array adapter
       public MyAdapter(Context context,String[] titleArray,
                        String[] descArray,int[] imageArray){
           super(context,R.layout.custom_id_listview,R.id.idTitle,titleArray);
           this.imageArray=imageArray;
           this.titleArray=titleArray;
           this.descArray=descArray;
       }//end of constructor override

       @NonNull
       @Override
       public View getView(int position, View convertView,
                           ViewGroup parent){
           //inflate layout
           LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View row = inflater.inflate(R.layout.custom_id_listview,parent,false);

           //get reference to view objs
           ImageView myImage = (ImageView) row.findViewById(R.id.idPic);
           TextView myTitle = (TextView) row.findViewById(R.id.idTitle);
           TextView myDesc = (TextView) row.findViewById(R.id.idDescription);

           //provide element of array by posn
           myImage.setImageResource(imageArray[position]);
           myTitle.setText(titleArray[position]);
           myDesc.setText(descArray[position]);
           return row;
       }
   }
