package productions.darthplagueis.halfwidthviewpager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import productions.darthplagueis.halfwidthviewpager.databinding.FragmentRightBinding;

public class RightFragment extends BaseFragment {

    private FragmentRightBinding rightBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rightBinding = FragmentRightBinding.inflate(inflater, container, false);
        rightBinding.rightCard.setMaxCardElevation(rightBinding.rightCard.getCardElevation() * CardFragmentAdapter.MAX_ELEVATION_FACTOR);
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    @Override
    public CardView getCardView() {
        return rightBinding.rightCard;
    }
}
