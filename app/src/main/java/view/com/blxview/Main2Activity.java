package view.com.blxview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Log.i("mao","main2="+MessageModel.MSG);
    }

    public void main2Click(View view){

        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
