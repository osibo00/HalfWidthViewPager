package productions.darthplagueis.halfwidthviewpager;

import android.support.v7.widget.CardView;

public interface CardFragmentAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int index);

    int getCount();
}
