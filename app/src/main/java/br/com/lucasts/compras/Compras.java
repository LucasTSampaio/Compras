package br.com.lucasts.compras;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Compras extends AppCompatActivity {

    CheckBox checkArroz, checkFeijao, checkLeite, checkCarne;
    Button btnTotal;
    EditText etArroz, etFeijao, etLeite, etCarne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        checkArroz = findViewById(R.id.chk_arroz);
        checkFeijao = findViewById(R.id.chk_feijao);
        checkLeite = findViewById(R.id.chk_leite);
        checkCarne = findViewById(R.id.chk_carne);
        btnTotal = findViewById(R.id.btn_total);

        etArroz = findViewById(R.id.qtd_arroz);
        etFeijao = findViewById(R.id.qtd_feijao);
        etLeite = findViewById(R.id.qtd_leite);
        etCarne = findViewById(R.id.qtd_carne);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double qtdArroz, qtdFeijao, qtdLeite, qtdCarne;


                if (etArroz.getText().toString().length() == 0) {
                    qtdArroz = 1;
                } else {
                    qtdArroz = Double.parseDouble(etArroz.getText().toString());
                }

                if (etFeijao.getText().toString().length() == 0) {
                    qtdFeijao = 1;
                } else {
                    qtdFeijao = Double.parseDouble(etArroz.getText().toString());
                }

                if (etLeite.getText().toString().length() == 0) {
                    qtdLeite = 1;
                } else {
                    qtdLeite = Double.parseDouble(etArroz.getText().toString());
                }

                if (etCarne.getText().toString().length() == 0) {
                    qtdCarne = 1;
                } else {
                    qtdCarne = Double.parseDouble(etArroz.getText().toString());
                }


                double total = 0;


                if (checkArroz.isChecked()) {
                    total = total + (2.69 * qtdArroz);
                }
                if (checkFeijao.isChecked()) {
                    total = total + (2.30 * qtdFeijao);
                }
                if (checkLeite.isChecked()) {
                    total = total + (5.00 * qtdLeite);
                }
                if (checkCarne.isChecked()) {
                    total = total + (9.70 * qtdCarne);
                }

                String strTotal = String.format("%.2f", total);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(Compras.this);
                dialogo.setTitle("Lista de Compras");
                dialogo.setMessage("Valor Total: R$ " + strTotal);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }

        });

    }
}
