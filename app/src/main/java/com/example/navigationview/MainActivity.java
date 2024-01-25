package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            boolean fragmentTransaction = false;

        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.menu_nuevo_grupo) {
            fragment = new FragmentNuevoGrupo();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_nuevo_chat) {
            fragment = new FragmentNuevoChat();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_nuevo_canal) {
            fragment = new FragmentNuevoCanal();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_contactos) {
            fragment = new FragmentContacto();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_llamadas) {
            fragment = new FragmentLlamada();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_guardados) {
            fragment = new FragmentMensajesGuardados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_ajustes) {
            fragment = new FragmentAjustes();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_invitar) {
            fragment = new FragmentInvitarAmigos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_preguntas) {
            fragment = new FragmentPreguntas();
            fragmentTransaction = true;
        }
        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}