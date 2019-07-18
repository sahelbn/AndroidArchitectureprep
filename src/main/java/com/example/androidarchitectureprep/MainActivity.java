package com.example.androidarchitectureprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        JsonplaceHolderApi jsonplaceHolderApi = retrofit.create(JsonplaceHolderApi.class);


        Call<List<Post>> call = jsonplaceHolderApi.getposts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Toast.makeText(getApplicationContext(),"on Response called",Toast.LENGTH_LONG).show();
                if(!response.isSuccessful()){
                    textViewResult.setText("code:" +response.code());
                    return;
                }
                List<Post> posts=response.body();
                for(Post post:posts){
                    String content="";
                    content +="ID:" +post.getId()+"\n";
                    content +="userId:" +post.getUserID() +"\n";
                    content +="title:" +post.getTitle()+"\n";
                    content +="Text:" +post.getText()+ "\n \n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });

    }
}

