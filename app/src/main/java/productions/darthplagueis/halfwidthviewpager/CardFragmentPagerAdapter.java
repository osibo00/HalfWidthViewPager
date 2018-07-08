package productions.darthplagueis.halfwidthviewpager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardFragmentAdapter {

    private List<BaseFragment> fragmentList;

    private float baseElevation;

    public CardFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList, float baseElevation) {
        super(fm);
        this.fragmentList = fragmentList;
        this.baseElevation = baseElevation;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int index) {
        return fragmentList.get(index).getCardView();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragmentList.set(position, (BaseFragment) fragment);
        return fragment;
    }

    @Override
    public float getPageWidth(int position) {
        if (position != 1) return 0.5f;
        else return super.getPageWidth(position);
    }
}
