package nefersky.converterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConvert(View view) {
        EditText edtValue = (EditText)findViewById(R.id.edtValue);

        if (edtValue.getText().length() < 1) {
            Toast.makeText(getApplicationContext(), "Неверные вводные данные", Toast.LENGTH_SHORT).show();
            return;
        }
        float InValue = Float.parseFloat(edtValue.getText().toString());

        RadioButton rbtnMeters = (RadioButton)findViewById(R.id.rbtnMeters);

        if (rbtnMeters.isChecked()) {
            edtValue.setText(String.valueOf(ConvertToMeters(InValue)));
        } else {
            edtValue.setText(String.valueOf(ConvertToParrots(InValue)));
        }
    }

    private float ConvertToMeters(float InValue) {
        return (float)(InValue / 7.6);
    }

    private float ConvertToParrots(float InValue) {
        return (float)(InValue * 7.6);
    }
}
