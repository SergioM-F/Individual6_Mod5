package cl.samf.individual6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.samf.individual6.databinding.ItemBinding;

public class AdapterImage extends RecyclerView.Adapter<AdapterImage.ViewHolder> {


    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(ImageList item);
    }

    private List<ImageList> listaImagenes;

    public AdapterImage(List<ImageList> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public AdapterImage.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterImage.ViewHolder holder, int position) {
        ImageList item = listaImagenes.get(position);
        holder.mostarImagen(item);
    }

    @Override
    public int getItemCount() {
        return listaImagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemBinding itemBinding;
        private OnItemClickListener viewHolderListener;

        public ViewHolder(ItemBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.itemBinding = binding;
            this.viewHolderListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && viewHolderListener != null) {
                ImageList item = listaImagenes.get(position);
                viewHolderListener.onItemClick(item);
            }
        }

        public void mostarImagen(ImageList item) {
            Glide.with(itemBinding.getRoot().getContext()).load(item.getImagenUrl()).centerCrop().into(itemBinding.imageViewItem);
            itemBinding.textViewItem.setText(item.getTexto());
        }
    }
}
