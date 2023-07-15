package cl.samf.individual6;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import cl.samf.individual6.databinding.FragmentSecondBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private String imageUrl;
    private String text;

    public SecondFragment(){

    }
    public static SecondFragment newInstance(String imageUrl, String text) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
        }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            imageUrl = args.getString("imageUrl");
            text = args.getString("text");
        }
        Glide.with(requireContext())
                .load(imageUrl)
                .into(binding.imageViewSecond);
        binding.textViewSecond.setText(text);
        }
    }

