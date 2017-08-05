package esecforte.com.qrscanner.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import esecforte.com.qrscanner.R;
import esecforte.com.qrscanner.model.NewFixtureModel;

/**
 * Created by esec-shiva on 4/8/17.
 */

public class NewFixtureAdapter extends RecyclerView.Adapter<NewFixtureAdapter.ViewHolder> {

	ArrayList<NewFixtureModel> newFixtureModelList;

	public NewFixtureAdapter(ArrayList<NewFixtureModel> newFixtureModelList) {
		this.newFixtureModelList=newFixtureModelList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.single_add_new_fixture, parent, false);

		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		NewFixtureModel newFixtureModel=newFixtureModelList.get(position);
		holder.title.setText(newFixtureModel.getTitle());


	}

	@Override
	public int getItemCount() {
		return newFixtureModelList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView title;
		public ViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.tv_title);

		}
	}
}
