package com.puactech.fortuneteller2013;

import java.util.Locale;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.*;

public class WantToKnow extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_know);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.want_to_know, menu);
        return true;
    }
    
    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
                case 3:
                    return getString(R.string.title_section4).toUpperCase(l);
				case 4:
                    return getString(R.string.title_section5).toUpperCase(l);
				case 5:
                    return getString(R.string.title_section6).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_want_to_know_dummy, container, false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
            ImageView sectionImage = (ImageView) rootView.findViewById(R.id.section_image);
			//dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            String sectionText = "";
            switch(sectionNumber){
                    case 1:
                            sectionText = getString(R.string.section_text1);
							sectionImage.setImageResource(R.drawable.pickle);
                            break;
                    case 2:
                            sectionText = getString(R.string.section_text2);
   							sectionImage.setImageResource(R.drawable.shay);
   							break;
                    case 3:
                            sectionText = getString(R.string.section_text3);
   							sectionImage.setImageResource(R.drawable.michelle);
							break;
                    case 4:
                            sectionText = getString(R.string.section_text4);
   							sectionImage.setImageResource(R.drawable.shayndmichelle);
							break;
					case 5:
   							sectionText = getString(R.string.section_text5);
  							sectionImage.setImageResource(R.drawable.michellewantspickle);
   							break;
					case 6:
   							sectionText = getString(R.string.section_text6);
   							sectionImage.setImageResource(R.drawable.pregnant);
   							break;
            }
            dummyTextView.setText(sectionText);
            return rootView;
        }
    }

}
