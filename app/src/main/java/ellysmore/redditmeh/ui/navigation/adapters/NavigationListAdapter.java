package ellysmore.redditmeh.ui.navigation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.models.SubredditType;
import ellysmore.redditmeh.ui.navigation.widgets.NavigationItemRow;

public class NavigationListAdapter extends BaseAdapter {

    private ArrayList<SubredditType> mItems = new ArrayList<>();

    private boolean mShowShortList = true;

    public NavigationListAdapter(ArrayList<SubredditType> mNavItems, boolean showShortList) {
        this.mItems = mNavItems;
        mShowShortList = showShortList;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public SubredditType getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NavigationItemRow rowView = (NavigationItemRow) convertView;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            rowView = (NavigationItemRow) layoutInflater
                    .inflate(R.layout.row_navigation_impl, parent, false);
        }
        rowView.updateUI(mItems.get(position));
        return rowView;
    }
}
