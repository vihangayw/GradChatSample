package com.populo.gradchat.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

import com.populo.gradchat.adapters.PagerAdapter;
import com.populo.gradchat.utils.BadgeDrawable;
import com.populo.gradchat.adapters.ExploreAdapter;
import com.populo.gradchat.adapters.PopularAdapter;
import vyw.example.sample.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public RecyclerView rvPlpularCards;
    public PopularAdapter adpaterPopular;
    public RecyclerView rvCardExplare;
    public ExploreAdapter adpaterExplore;
    private Timer timerTimers;
    private static boolean isAdapterSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        startCardInit();
    }

    private void startCardInit() {
        final Handler mainHandler = new Handler(this.getMainLooper());

        final Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                if (!isAdapterSet) {
                    refreshAdapter();
                }
            }
        };
        timerTimers = new Timer();

        timerTimers.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mainHandler.post(myRunnable);
            }
        }, 1500, 1000);
    }

    private void initComponent() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adpaterPopular = new PopularAdapter(this);
        adpaterExplore = new ExploreAdapter(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("POPULAR"));
        tabLayout.addTab(tabLayout.newTab().setText("EXPLORE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adpaterPopulars = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adpaterPopulars);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void refreshAdapter() {

        rvPlpularCards = (RecyclerView) findViewById(R.id.my_recycler_view);
        if (rvPlpularCards != null) {
            rvPlpularCards.setAdapter(adpaterPopular);
            rvPlpularCards.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rvPlpularCards.setHasFixedSize(true);
            rvPlpularCards.setItemAnimator(new DefaultItemAnimator());
            rvCardExplare = (RecyclerView) findViewById(R.id.my_recycler_view2);
            rvCardExplare.setAdapter(adpaterExplore);
            rvCardExplare.setLayoutManager(new LinearLayoutManager(this));
            rvCardExplare.setHasFixedSize(true);
            rvCardExplare.setItemAnimator(new DefaultItemAnimator());

            isAdapterSet = true;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        BadgeDrawable badge = new BadgeDrawable(this);
        badge.setCount(10);

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_donate) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
