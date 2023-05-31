public class MainActivity extends AppCompatActivity {
    private ListView contactListView;
    private Button addContactButton;
    private DatabaseHelper databaseHelper;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactListView = findViewById(R.id.contactListView);
        addContactButton = findViewById(R.id.addContactButton);
        databaseHelper = new DatabaseHelper(this);
        contactAdapter = new ContactAdapter(this, null);

        contactListView.setAdapter(contactAdapter);

        loadContacts();

        // Configura o clique em um item da lista de contatos
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                String contactName = cursor.getString(cursor.getColumnIndexOrThrow("name"));

                // Abra a tela de edição do contato
                openEditContactActivity(contactName);
            }
        });

        // Configura o clique no botão de adicionar contato
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abra a tela de adição de contato
                openAddContactActivity();
            }
        });
    }

    private void loadContacts() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String[] projection = {"id", "name", "phone_number"};
        String sortOrder = "name ASC";

        Cursor cursor = db.query("contacts", projection, null, null, null, null, sortOrder);
        contactAdapter.changeCursor(cursor);
    }

    private void openEditContactActivity(String contactName) {
        // Implemente o código para abrir a tela de edição do contato com o nome do contato passado como parâmetro
    }

    private void openAddContactActivity() {
        // Implemente o código para abrir a tela de adição de contato
    }
}