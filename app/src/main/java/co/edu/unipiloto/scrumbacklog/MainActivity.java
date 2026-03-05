package co.edu.unipiloto.scrumbacklog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnConsulta, btnInventario, btnSalidas, btnNotificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsulta = findViewById(R.id.btnConsulta);
        btnInventario = findViewById(R.id.btnInventario);
        btnSalidas = findViewById(R.id.btnSalidas);
        btnNotificador = findViewById(R.id.btnNotificador);


        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConsultaActivity.class);
                startActivity(intent);
            }
        });

        btnInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InventarioActivity.class);
                startActivity(intent);
            }
        });

        btnSalidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SalidasActivity.class);
                startActivity(intent);
            }
        });

        btnNotificador.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NotificadorActivity.class);
            startActivity(intent);
        });
    }
}