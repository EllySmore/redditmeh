package ellysmore.redditmeh.ui.listing.subreddit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;
import ellysmore.redditmeh.ui.listing.subreddit.widgets.ListingRow;

public class ListingAdapter extends BaseAdapter {

    private ListingDisplayInfo mData;

    @Override
    public int getCount() {
        if (mData != null) {
            return mData.getSize();
        } else {
            return 0;
        }
    }

    @Override
    public Data_ getItem(int position) {
        return mData.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListingRow rowView = (ListingRow) convertView;
        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            rowView = (ListingRow) layoutInflater.inflate(
                    R.layout.row_listing_impl, parent, false);
        }
        rowView.updateUI(mData.getItem(position));
        return rowView;
    }

    public ListingDisplayInfo getData() {
        return mData;
    }

    public void setData(ListingDisplayInfo data) {
        mData = data;
    }

}
