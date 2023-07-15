package cl.samf.individual6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.samf.individual6.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements AdapterImage.OnItemClickListener {
    private FragmentFirstBinding binding;
    private List<ImageList> listaImagenes;

    private AdapterImage adapter;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
        public void onViewCreated (View view, Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);



            listaImagenes = new ArrayList<>();

            listaImagenes.add(new ImageList("https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640", "Zhuo Cheng you"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/pNoPqVwBFQ/download?force=true&w=640", "billow926"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640", "Philipp Deiß"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640", "Huper by Joshua Earle"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640", "Melnychuk Nataliya"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640", "Teagan Maddux"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640", "Chen Liu"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/iNqJxVOceI/download?force=true&w=640", "John Fornander"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640", "Parker Coffman"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640", "XPS"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640", "Daniel J. Schwarz"));
            listaImagenes.add(new ImageList("https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640", "Wesley Armstrong"));

            adapter = new AdapterImage(listaImagenes);
            binding.RecyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(this);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL);
            binding.RecyclerView.addItemDecoration(dividerItemDecoration);
        }

    public void onItemClick(ImageList item) {
        String imageUrl = item.getImagenUrl();
        String text = item.getTexto();
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        args.putString("text", text);
        secondFragment.setArguments(args);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView2, secondFragment)
                .addToBackStack(null)
                .commit();
    }


}
