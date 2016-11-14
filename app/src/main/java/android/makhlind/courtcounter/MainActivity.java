package android.makhlind.courtcounter;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int denisTeam = 0;
    private int otherTeam = 0;
    EditText teamName1View;
    EditText teamName2View;

    AlertDialog gameOverAlert;

    private MediaPlayer mediaPlayer;
    public String team1Name;
    public String team2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamName1View = (EditText) findViewById(R.id.denisedit1);
        teamName2View = (EditText) findViewById(R.id.denisedit2);
    }

    public void displayForTeamDenis(int score) {
        TextView denisTeam = (TextView) findViewById(R.id.denisedit1);
        if (denisTeam != null) {
            denisTeam.setText(String.valueOf(score));
        }
    }

    public void displayForTeamOther(int score) {
        TextView otherTeam = (TextView) findViewById(R.id.denisedit2);
        if (otherTeam != null) {
            otherTeam.setText(String.valueOf(score));
        }
    }

    public void addOneForTeamDenis(View view) {
        int step = 1;
        denisTeam += step;
        mediaPlayer = MediaPlayer.create(this, R.raw.nice);
        mediaPlayer.start();
        displayForTeamDenis(denisTeam);
    }

    public void subtractOneForDenis(View view) {
        int step = 1;
        denisTeam -= step;
        displayForTeamDenis(denisTeam);
    }

    public void addOneForTeamOther(View view) {
        int step = 1;
        otherTeam += step;
        displayForTeamOther(otherTeam);
    }

    public void subtractOneForTeamOther(View view) {
        int step = 1;
        otherTeam -= step;
        displayForTeamOther(otherTeam);
    }

    public void resetScore(View view) {
        mediaPlayer.start();
        gameOverAlert = new AlertDialog.Builder(MainActivity.this).create();
        String team1Name = teamName1View.getText().toString();
        String team2Name = teamName2View.getText().toString();
        gameOverAlert.setTitle("Game Over");

        gameOverAlert.setMessage("Game Over");

        if (denisTeam > otherTeam) {
            gameOverAlert.setMessage(team1Name + "wins");
        }

        if (denisTeam < otherTeam) {
            gameOverAlert.setMessage(team2Name + "wins");

        }


        if (denisTeam == otherTeam) {
            gameOverAlert.setMessage("It's a draw");
        }

        gameOverAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        gameOverAlert.show();
        denisTeam = 0;
        otherTeam = 0;
        displayForTeamDenis(denisTeam);
        displayForTeamOther(otherTeam);


    }
}



