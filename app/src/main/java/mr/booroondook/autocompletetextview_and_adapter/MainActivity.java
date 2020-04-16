package mr.booroondook.autocompletetextview_and_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] lastNames = getResources().getStringArray(R.array.last_names);
        textView = findViewById(R.id.text_view);
        autoCompleteTextView = findViewById(R.id.auto_complete_text_view);

        autoCompleteTextView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, lastNames));
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(autoCompleteTextView.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
