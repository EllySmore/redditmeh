package ellysmore.redditmeh.ui.listing.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Post;
import ellysmore.redditmeh.api.models.Listing.PostData;
import ellysmore.redditmeh.ui.listing.models.ListingDisplayViewModel;
import ellysmore.redditmeh.ui.listing.widgets.ListingViewHolder;
import ellysmore.redditmeh.util.PicassoHelper;

public class ListingRecyclerAdapter extends RecyclerView.Adapter<ListingViewHolder> {

    private final Context mContext;

    private List<Post> mPosts;

    public ListingRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_listing, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        ListingDisplayViewModel viewModel = new ListingDisplayViewModel(mContext,
                getItem(position));
        holder.mTitle.setText(viewModel.getTitle());
        holder.mSubredditByDomain.setText(mContext.getString(R.string.x_bullet_y,
                viewModel.getSubreddit(), viewModel.getDomain()));
        holder.mTimeByAuthor.setText(mContext.getString(R.string.x_bullet_y,
                viewModel.getDateCreated(), viewModel.getAuthor()));
        holder.mNumberOfCommentButton.setText(String.valueOf(viewModel.getNumberOfComments()));

        if (getItem(position).isOver18()) {
            PicassoHelper.loadImage(holder.mThumbnail, mContext, R.drawable.redditplaceholder_nsfw);
        } else {
            PicassoHelper.loadImage(holder.mThumbnail, mContext, viewModel.getThumbnailUrl());
        }

    }

    @Override
    public int getItemCount() {
        return mPosts == null ? 0 : mPosts.size();
    }

    public PostData getItem(int pos) {
        return mPosts == null ? null : mPosts.get(pos).getData();
    }

    public void setPosts(List<Post> posts) {
        mPosts = posts;
        notifyDataSetChanged();
    }

    public void addPosts(List<Post> posts) {
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }

    public void clear() {
        if (mPosts != null) {
            mPosts.clear();
            notifyDataSetChanged();
        }
    }
}
