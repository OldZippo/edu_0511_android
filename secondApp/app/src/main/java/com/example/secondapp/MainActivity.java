 package com.example.secondapp;

 import android.os.Bundle;
 //import android.support.v7.app.AppCompatActivity;
 import android.util.Log;
 import android.view.LayoutInflater;
 import android.view.ViewGroup;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;
 //import androidx.appcompat.app.AppCompatActivity;

 import java.util.List;

 public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Users users = new Users();
        List<String> userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
        Log.d("SYSTEM INFO: ", "Конструктор onCreate() запущен");
    }
    // UserHolder отвечает за каждый элемент списка по отдельности
    // Именно сдесь мы будем наполнять нашу activity_item контекстом
    private class UserHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.activity_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);
            Log.d("SYSTEM INFO: ", "Конструктор UserHolder() запущен");
        }
        public  void bind(String username){
            itemTextView.setText(username);
            Log.d("SYSTEM INFO: ", "Метод bind() запущен");
        }
    }
    // UserAdapter нужен для того, чтобы разместить элементы на RecyclerView
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        List<String> userList;
        public UserAdapter(List<String> userList) {
            Log.d("SYSTEM INFO: ", "Конструктор UserAdapter() запущен");
            this.userList = userList;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            //inflater - наполнитель
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            Log.d("SYSTEM INFO: ", "Метод onCreateViewHolder() запущен");
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            String userName = userList.get(position);
            userHolder.bind(userName);
            Log.d("SYSTEM INFO: ", "Метод onBindViewHolder() запущен");
        }

        @Override
        public int getItemCount() {
            Log.d("SYSTEM INFO: ", "Метод getItemCount() запущен");
            return userList.size();
        }
    }
 }