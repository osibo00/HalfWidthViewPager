package productions.darthplagueis.halfwidthviewpager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import productions.darthplagueis.halfwidthviewpager.databinding.FragmentLeftBinding;

public class LeftFragment extends BaseFragment {

    private FragmentLeftBinding leftBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        leftBinding = FragmentLeftBinding.inflate(inflater, container, false);
        leftBinding.leftCard.setMaxCardElevation(leftBinding.leftCard.getCardElevation() * CardFragmentAdapter.MAX_ELEVATION_FACTOR);
        return leftBinding.getRoot();
    }

    @Override
    public CardView getCardView() {
        return leftBinding.leftCard;
    }
}
