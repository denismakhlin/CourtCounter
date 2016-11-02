package android.makhlind.courtcounter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView dennisView3;
    private int text3;
    private TextView dennisView6;
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dennisView3 = (TextView)findViewById(R.id.dennisView3);
        text3=0;
        dennisView3.setText("0");
        dennisView6 = (TextView)findViewById(R.id.dennisView6);
        dennisView6.setText("0");
    }
    public void textClick3(View view){
        text3++;
        dennisView3.setText("" + text3);
    }
}