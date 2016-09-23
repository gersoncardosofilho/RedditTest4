package br.com.gersoncardoso.reddittest4.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.gersoncardoso.reddittest4.Fragment.ControversialFragment;
import br.com.gersoncardoso.reddittest4.Fragment.GildedFragment;
import br.com.gersoncardoso.reddittest4.Fragment.HotFragment;
import br.com.gersoncardoso.reddittest4.Fragment.NewFragment;
import br.com.gersoncardoso.reddittest4.Fragment.PromotedFragment;
import br.com.gersoncardoso.reddittest4.Fragment.RisingFragment;
import br.com.gersoncardoso.reddittest4.Fragment.TopFragment;
import br.com.gersoncardoso.reddittest4.Fragment.WikiFragment;

/**
 * Created by gersoncardoso on 22/09/2016.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public TabsAdapter(FragmentManager supportFragmentManager, int numberOfTabs)
    {
        super(supportFragmentManager);
        this.numberOfTabs = numberOfTabs;
    }




    @Override
    public Fragment getItem(int position) {

            switch (position){
                case 0:
                    HotFragment tab1 = new HotFragment();
                    tab1.newInstance("askreddit");
                    return tab1;
                case 1:
                    NewFragment tab2 = new NewFragment();
                    tab2.newInstance("askreddit");
                    return tab2;
                case 2:
                    RisingFragment tab3 = new RisingFragment();
                    return tab3;
                case 3:
                    ControversialFragment tab4 = new ControversialFragment();
                    return tab4;
                case 4:
                    TopFragment tab5 = new TopFragment();
                    return tab5;
                case 5:
                    GildedFragment tab6 = new GildedFragment();
                    return tab6;
                case 6:
                    WikiFragment tab7 = new WikiFragment();
                    return tab7;
                case 7:
                    PromotedFragment tab8 = new PromotedFragment();
                    return tab8;
                default:
                    return null;
            }

    }

    @Override
    public int getCount() {
        //Quantidade de tabs = 8
        return numberOfTabs;
    }

    /*@Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Hot";
            case 1:
                return "New";
            case 2:
                return "Rising";
            case 3:
                return "Controversial";
            case 4:
                return "Top";
            case 5:
                return "Gilded";
            case 6:
                return "Wiki";
            case 7:
                return "Promoted";
            default:
                return null;
        }
    }*/
}
