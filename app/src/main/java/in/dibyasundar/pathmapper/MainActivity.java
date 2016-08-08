package in.dibyasundar.pathmapper;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private TableRow tableRow;
    private EditText editTextRows, editTextColumns;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("How big map?");
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View dialogView = layoutInflater.inflate(R.layout.dialog, null);
        builder.setView(dialogView);
        editTextRows = (EditText) dialogView.findViewById(R.id.editTextRows);
        editTextColumns = (EditText) dialogView.findViewById(R.id.editTextColumns);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void onClick(DialogInterface dialog, int id) {

                int rows = Integer.parseInt(String.valueOf(editTextRows.getText()));
                int cols = Integer.parseInt(String.valueOf(editTextColumns.getText()));

                for(int i = 0; i < rows; i++) {
                    tableRow = new TableRow(getApplicationContext());
                    for (int j = 0; j < cols; j++) {
                        checkbox = new CheckBox(getApplicationContext());
                        checkbox.setButtonTintList(ColorStateList.valueOf(Color.BLACK));
                        tableRow.addView(checkbox);
                    }
                    tableLayout.addView(tableRow);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
