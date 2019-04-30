package br.com.meganordeste.qualdehoje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {

    Button btnCalcular, btnSair,btnLimpar;
    TextView txtControle, txtNivel;
    CalendarView calendario;
    int dia, mes, ano, resultadoNivel, resultadoControle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnCalcular=findViewById(R.id.btnCalcular);
    btnSair = findViewById(R.id.btnSair);
    btnLimpar = findViewById(R.id.btnLimpar);

    txtControle = findViewById(R.id.txtControle);
    txtNivel = findViewById(R.id.txtNivel);
    calendario = findViewById(R.id.calendarView);



    calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int day) {

            dia = day;
            mes = month+1;
            ano = year;

        }
    });



    btnLimpar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            txtControle.setText("");
            txtNivel.setText("");
        }
    });


    btnSair.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.this.finish();
        }
    });



    btnCalcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar cal = Calendar.getInstance();


            if (dia ==0 && mes ==0 && ano ==0){

                dia = cal.get(Calendar.DAY_OF_MONTH);
                mes = cal.get(Calendar.MONTH) + 1;
                ano = cal.get(Calendar.YEAR);


               // Toast.makeText(MainActivity.this, "dia: " + String.valueOf(dia ) +" mes: " +  String.valueOf(mes) + " ano: "+ String.valueOf(ano) , Toast.LENGTH_SHORT).show();
                resultadoControle = ((dia * ano) + (dia * mes) + (ano - mes -dia));
                txtControle.setText(String.valueOf(resultadoControle));

                resultadoNivel = ((dia * mes ) + ano + 5);
                txtNivel.setText(String.valueOf(resultadoNivel));

            }else {

                resultadoControle = ((dia * ano) + (dia * mes) + (ano - mes -dia));
                txtControle.setText(String.valueOf(resultadoControle));

                resultadoNivel = ((dia * mes ) + ano + 5);
                txtNivel.setText(String.valueOf(resultadoNivel));


            }


        }
    });

    }
}
