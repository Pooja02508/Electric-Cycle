package electric.cycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.ProductViewHolder> {

    private Context mCtx;
    private ItemClickListener mClickListener;
    private List<BikeModel> bikeList;

    public BikeAdapter(Context mCtx, List<BikeModel> bikeList) {
        this.mCtx = mCtx;
        this.bikeList = bikeList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.bike_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        BikeModel product = bikeList.get(position);

        holder.bikeName.setText(product.getBike_name());
        holder.bikeImage.setImageDrawable(mCtx.getResources().getDrawable(product.getBike_image()));
    }

    @Override
    public int getItemCount() {
        return bikeList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bikeName;
        ImageView bikeImage;

        public ProductViewHolder(View itemView) {
            super(itemView);

            bikeName = itemView.findViewById(R.id.bikeName);
            bikeImage = itemView.findViewById(R.id.bikeImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
