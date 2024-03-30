package com.example.recyclerview3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView_circle;

    HashMap<String, String> hashMap;
    HashMap<String, String> hashMap2;
    ArrayList<HashMap<String, String>> arrayList;
    ArrayList<HashMap<String, String>> arrayList2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           recyclerView = findViewById(R.id.recycler_view);
           recyclerView_circle = findViewById(R.id.recycler_view_circle);


//for horizontal recycle view

        arrayList2 = new ArrayList<>();

        hashMap2 = new HashMap<>();
        hashMap2.put("c_text", "Hello guys");
        arrayList2.add(hashMap2);

        hashMap2 = new HashMap<>();
        hashMap2.put("c_text", "Whats_app");
        arrayList2.add(hashMap2);


        adapter2 adapter2= new adapter2();
        recyclerView_circle.setAdapter(adapter2);

        recyclerView_circle.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));




//for vertical recycle view
           arrayList = new ArrayList<>();

           hashMap = new HashMap<>();
           hashMap.put("item_type", "ARTICLE");
           hashMap.put("article_name", "Cricket, Badminton, Football");
           arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("item_type", "VIDEO");
        hashMap.put("video_name", "Badsha, hunny Sing, Tahsan");
        arrayList.add(hashMap);



        adapter adapter= new adapter();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }


    //for horizental recycle view
    private class adapter2 extends RecyclerView.Adapter <adapter2.myViewHolder>{


        private class myViewHolder extends RecyclerView.ViewHolder{


            TextView circle_text;
            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                circle_text = itemView.findViewById(R.id.circle_text);


            }
        }


        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();

            View myview = inflater.inflate(R.layout.circle_list, parent, false);

            return new myViewHolder(myview);

        }


        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            hashMap2 =arrayList2.get(position);

            String circle_text = hashMap2.get("c_text");

            holder.circle_text.setText(circle_text);


        }

        @Override
        public int getItemCount() {
            return arrayList2.size();
        }


    }





//for vertical list================================
    private class adapter extends RecyclerView.Adapter{



        int ARTICLE= 0;
        int VIDEO= 1;

        private class articleViewHolder extends RecyclerView.ViewHolder{

            TextView article_list;
            public articleViewHolder(@NonNull View itemView) {
                super(itemView);

                article_list = itemView.findViewById(R.id.article_list);
            }
        }


        private class videoViewHolder extends RecyclerView.ViewHolder{

            TextView video_list;
            public videoViewHolder(@NonNull View itemView) {
                super(itemView);

                video_list = itemView.findViewById(R.id.video_list);
            }
        }








        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();

            if (viewType==ARTICLE){
                View myview = inflater.inflate(R.layout.article, parent, false);
                return new articleViewHolder(myview);
            }else {
                View myview = inflater.inflate(R.layout.video,parent, false);
                return new videoViewHolder(myview);
            }
        }



        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

           if (getItemViewType(position)==ARTICLE){

               articleViewHolder articleViewHolder = (adapter.articleViewHolder) holder;
               hashMap = arrayList.get(position);
               String article_name = hashMap.get("article_name");
               articleViewHolder.article_list.setText(article_name);

           }else{

               videoViewHolder videoViewHolder = (adapter.videoViewHolder) holder;
               hashMap = arrayList.get(position);
               String video_name = hashMap.get("video_name");
               videoViewHolder.video_list.setText(video_name);

           }

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }





        @Override
        public int getItemViewType(int position) {

            hashMap = arrayList.get(position);

            String item_type = hashMap.get("item_type");

            assert item_type != null;

            if (item_type.contains("ARTICLE")){
                return ARTICLE;
            }else {
                return VIDEO;
            }
        }

    }
}