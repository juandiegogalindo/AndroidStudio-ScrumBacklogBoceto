package co.edu.unipiloto.scrumbacklog;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.unipiloto.scrumbacklog.Spinner.SimpleItemSelected;
import co.edu.unipiloto.scrumbacklog.database.DatabaseHelper;

public class ControlInventarioActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private LinearLayout layoutInventario, layoutHistorial;
    private Spinner spFiltroCombustible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_inventario);

        db = new DatabaseHelper(this);

        layoutInventario = findViewById(R.id.layoutInventario);
        layoutHistorial = findViewById(R.id.layoutHistorial);
        spFiltroCombustible = findViewById(R.id.spFiltroCombustible);

        // Spinner de filtro
        String[] combustibles = {"Todos", "Corriente", "Extra", "Diesel"};
        spFiltroCombustible.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, combustibles));

        // Actualizar inventario e historial al abrir
        mostrarInventario();
        mostrarHistorial();

        // Filtrar por combustible si se cambia el spinner
        spFiltroCombustible.setOnItemSelectedListener(new SimpleItemSelected(this::refrescarVista));
    }

    private void refrescarVista() {
        mostrarInventario();
        mostrarHistorial();
    }

    private void mostrarInventario() {
        layoutInventario.removeAllViews();
        String filtro = spFiltroCombustible.getSelectedItem().toString();

        String[] combustibles = filtro.equals("Todos") ? new String[]{"Corriente","Extra","Diesel"} : new String[]{filtro};

        for (String tipo : combustibles) {
            double cantidad = db.obtenerInventario(tipo);

            // TextView con nombre y cantidad
            TextView tv = new TextView(this);
            tv.setText(tipo + ": " + cantidad + " galones");
            tv.setTextSize(16f);

            // ProgressBar para nivel visual (asumiendo máximo 10000 galones)
            ProgressBar pb = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            pb.setMax(10000);
            pb.setProgress((int) cantidad);
            pb.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40));

            // Cambiar color según nivel
            if (cantidad >= 5000) pb.getProgressDrawable().setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
            else if (cantidad >= 2000) pb.getProgressDrawable().setColorFilter(Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
            else pb.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

            layoutInventario.addView(tv);
            layoutInventario.addView(pb);
        }
    }

    private void mostrarHistorial() {
        layoutHistorial.removeAllViews();
        ArrayList<String> movimientos = db.obtenerMovimientos();

        // Solo mostrar los últimos 10 movimientos
        int count = 0;
        for (String mov : movimientos) {
            if (count >= 10) break;
            TextView tv = new TextView(this);
            tv.setText(mov);
            layoutHistorial.addView(tv);
            count++;
        }
    }
}