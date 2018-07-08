package productions.darthplagueis.halfwidthviewpager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import productions.darthplagueis.halfwidthviewpager.databinding.FragmentMainBinding;

public class MainFragment extends BaseFragment {

    private FragmentMainBinding mainBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding = FragmentMainBinding.inflate(inflater, container, false);
        mainBinding.mainCard.setMaxCardElevation(mainBinding.mainCard.getCardElevation() * CardFragmentAdapter.MAX_ELEVATION_FACTOR);
        return mainBinding.getRoot();
    }

    @Override
    public CardView getCardView() {
        return mainBinding.mainCard;
    }
}
