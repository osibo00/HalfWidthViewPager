package productions.darthplagueis.halfwidthviewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private CardFragmentAdapter cardFragmentAdapter;

    private float lastOffset;

    public ShadowTransformer(ViewPager viewPager, CardFragmentAdapter cardFragmentAdapter) {
        this.cardFragmentAdapter = cardFragmentAdapter;
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = cardFragmentAdapter.getBaseElevation();
        float realOffset;
        boolean goingLeft = lastOffset > positionOffset;

        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        if (nextPosition > cardFragmentAdapter.getCount() - 1
                || realCurrentPosition > cardFragmentAdapter.getCount() - 1) {
            return;
        }

        CardView currentCard = cardFragmentAdapter.getCardViewAt(realCurrentPosition);
        if (currentCard != null) {
            currentCard.setCardElevation((baseElevation + baseElevation
                    * (CardFragmentAdapter.MAX_ELEVATION_FACTOR - 1) * (realOffset)));
        }

        CardView nextCard = cardFragmentAdapter.getCardViewAt(nextPosition);
        if (nextCard != null) {
            nextCard.setCardElevation((baseElevation + baseElevation
                    * (CardFragmentAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset)));
        }

        lastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void transformPage(@NonNull View page, float position) {

    }
}
