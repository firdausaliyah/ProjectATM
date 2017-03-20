package id.sch.smktelkom_mlg.www.appberatbadan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6;
    EditText editnama, edittinggi, editberat, hasildeal, hasilket1, hasilket2;
    RadioButton rdbLaki, rdbPerempuan;
    Button btncek, btnexit, btnclear;
    RadioGroup radioGroup;
    int ti, h1, bt;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncek = (Button) findViewById(R.id.btncek);
        btnexit = (Button) findViewById(R.id.btnexit);
        editnama = (EditText) findViewById(R.id.editnama);
        editberat = (EditText) findViewById(R.id.editberat);
        edittinggi = (EditText) findViewById(R.id.edittinggi);
        hasildeal = (EditText) findViewById(R.id.hasildeal);
        hasilket1 = (EditText) findViewById(R.id.hasilket1);
        hasilket2 = (EditText) findViewById(R.id.hasilket2);
        rdbLaki = (RadioButton) findViewById(R.id.rdbLaki);
        rdbPerempuan = (RadioButton) findViewById(R.id.rdbPerempuan);
        btnclear = (Button) findViewById(R.id.btnclear);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        btncek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses();
            }

            private void proses() {
                int ti = Integer.parseInt(String.valueOf(edittinggi.getText()));
                int bt = Integer.parseInt(String.valueOf(editberat.getText()));

                if (rdbLaki.isSelected()) {
                    h1 = (ti - 100);
                } else if (rdbPerempuan.isSelected()) {
                    h1 = (ti - 104);
                }
                temp = Integer.toString(h1);

                if (h1 < bt) {
                    hasildeal.setText("Berat badan ideal anda" + temp);
                    hasilket1.setText("Maaf" + editnama.getText() + ", Sepertinya anda Overweight");
                    hasilket2.setText("Banyaklah berolahraga dan hindari makanan berkolesterol");
                } else if (h1 > bt) {
                    hasildeal.setText("Berat badan ideal anda" + temp);
                    hasilket1.setText("Maaf" + editnama.getText() + ", Sepertinya anda Underweight");
                    hasilket2.setText("Banyaklah berolahraga dan hindari makanan berkarbohidrat");
                } else {
                    hasildeal.setText("Berat badan ideal anda" + temp);
                    hasilket1.setText("Hallo" + editnama.getText() + ", Berat badan anda sudah ideal");
                    hasilket2.setText("Lanjutkan pola makan teratur dan gaya hidup sehat");
                }
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editnama.setText("");
                edittinggi.setText("");
                editberat.setText("");
                hasildeal.setText("");
                hasilket1.setText("");
                hasilket2.setText("");
                radioGroup.clearCheck();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }
}