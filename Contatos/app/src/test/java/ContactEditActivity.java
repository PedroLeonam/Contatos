import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ContactEditActivity extends AppCompatActivity {
    private EditText nameEditText;
    private Button addPhoneButton;
    private Button saveButton;
    private DatabaseHelper databaseHelper;
    private String contactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        nameEditText = findViewById(R.id.nameEditText);
        addPhoneButton = findViewById(R.id.addPhoneButton);
        saveButton = findViewById(R.id.saveButton);
        databaseHelper = new DatabaseHelper(this);

        contactName = getIntent().getStringExtra("contact_name");

        if (contactName != null) {
            // Modo de edição
            setTitle("Editar Contato");
            // Carregar os dados do contato do banco de dados e preencher os campos
        } else {
            // Modo de adição
            setTitle("Adicionar Contato");
        }

        addPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicionar um campo de telefone dinamicamente
                addPhoneField();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Salvar as alterações ou adicionar um novo contato
                saveContact();
            }
        });
    }

    private void addPhoneField() {
        // Implemente o código para adicionar um campo de telefone dinamicamente
    }

    private void saveContact() {
        // Implemente o código para salvar as alterações ou adicionar um novo contato
    }
}