package productions.darthplagueis.halfwidthviewpager;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.halfwidthviewpager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<BaseFragment> baseFragments = new ArrayList<>();
        baseFragments.add(new LeftFragment());
        baseFragments.add(new MainFragment());
        baseFragments.add(new RightFragment());

        CardFragmentPagerAdapter fragmentPagerAdapter =
                new CardFragmentPagerAdapter(getSupportFragmentManager(), baseFragments, dpToPixels(2, this));

        ViewPager viewPager = mainBinding.viewPager;
        ShadowTransformer shadowTransformer = new ShadowTransformer(viewPager, fragmentPagerAdapter);

        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setPageTransformer(false, shadowTransformer);
        viewPager.setCurrentItem(1);
    }

    public float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
