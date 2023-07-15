package cl.samf.individual6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cl.samf.individual6.databinding.ItemBinding;

public class AdapterImage extends RecyclerView.Adapter<AdapterImage.ViewHolder> {
    @NonNull
    @Override
    public AdapterImage.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterImage.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View

            .OnClickListener{

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
