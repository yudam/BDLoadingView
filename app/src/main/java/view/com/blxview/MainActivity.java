package view.com.blxview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    private SeekBar seekbar;

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity=this;

        image= (ImageView) findViewById(R.id.image);

        seekbar= (SeekBar) findViewById(R.id.seekbar);
    }

    public void mainClick(View view){


    }


}

