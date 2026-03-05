package co.edu.unipiloto.scrumbacklog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import co.edu.unipiloto.scrumbacklog.database.DatabaseHelper;

public class NotificadorActivity extends AppCompatActivity {

    Button btnVerificar;
    Button btnVolver;
    TextView txtAlerta;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificador);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnVolver = findViewById(R.id.btnVolver);
        txtAlerta = findViewById(R.id.txtAlerta);

        dbHelper = new DatabaseHelper(this);

        btnVerificar.setOnClickListener(view -> {

            double diesel = dbHelper.obtenerInventario("Diesel");
            double corriente = dbHelper.obtenerInventario("Corriente");
            double extra = dbHelper.obtenerInventario("Extra");

            String mensaje = "";

            if(diesel < 10000){
                mensaje += "⚠ Diesel en nivel crítico\n";
            }

            if(corriente < 15000){
                mensaje += "⚠ Corriente en nivel crítico\n";
            }

            if(extra < 40){
                mensaje += "⚠ Extra en nivel crítico\n";
            }

            if(mensaje.equals("")){
                mensaje = "Inventario en niveles normales";
            }

            txtAlerta.setText(mensaje);

        });

        btnVolver.setOnClickListener(view -> finish());
    }
}