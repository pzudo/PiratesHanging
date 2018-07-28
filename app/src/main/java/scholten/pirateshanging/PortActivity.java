package scholten.pirateshanging;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import scholten.pirateshanging.fragments.GallowsFragment;
import scholten.pirateshanging.fragments.HomeFragment;
import scholten.pirateshanging.fragments.TavernFragment;

public class PortActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_tavern:
                    fragment = new TavernFragment();
                    break;
                case R.id.navigation_gallows:
                    fragment = new GallowsFragment();
                    break;
                case R.id.navigation_notifications:
                    fragment = new HomeFragment();
                    break;
            }

            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port);

        // Define which fragment to start when activity is called
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        // And remember to select the correct bottom menu item here
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
