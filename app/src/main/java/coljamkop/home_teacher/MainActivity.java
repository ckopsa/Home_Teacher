package coljamkop.home_teacher;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import coljamkop.home_teacher.dummy.AppointmentContent;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnListFragmentInteractionListener, AdditionalFragment.AddAppointmentFragmentInteractionListener {

    @Override
    public void onListFragmentInteraction(AppointmentContent.Appointment item) {
        Toast toast = Toast.makeText(getApplicationContext(), item.time, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onListAddAppointmentButtonPress() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new AdditionalFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onAddAppointmentButtonPress(AppointmentContent.Appointment appointment) {
        AppointmentContent.addItem(appointment);
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment nextFragment = new BaseFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, nextFragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // prevent recreation on rotate by checking if null
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getFragments() == null) {
            BaseFragment nextFragment = new BaseFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, nextFragment);
            ft.commit();
        }
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
