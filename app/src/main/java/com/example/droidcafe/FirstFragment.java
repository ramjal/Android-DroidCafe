package com.example.droidcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.droidcafe.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private FragmentFirstBinding binding;
    private String mOrderMessage = "Nothing ordered yet!";

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(this);
        binding.donut.setOnClickListener(this);
        binding.icecream.setOnClickListener(this);
        binding.froyo.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        int ID = v.getId();
        switch (ID) {
            case R.id.fab:
                if (!"".equals(mOrderMessage)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(EXTRA_MESSAGE, mOrderMessage);
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
                } else {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);

                }
                break;
            case R.id.donut:
                mOrderMessage = getString(R.string.donut_order_message);
                displayToast(mOrderMessage);
                break;
            case R.id.icecream:
                mOrderMessage = getString(R.string.ice_cream_order_message);
                displayToast(mOrderMessage);
                break;
            case R.id.froyo:
                mOrderMessage = getString(R.string.froyo_order_message);
                displayToast(mOrderMessage);
                break;
        }

    }

    public void displayToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}