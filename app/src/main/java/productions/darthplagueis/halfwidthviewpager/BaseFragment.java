package productions.darthplagueis.halfwidthviewpager;

import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;

public abstract class BaseFragment extends Fragment {

    public abstract CardView getCardView();

    public BaseFragment() {
        // Required empty public constructor
    }
}
