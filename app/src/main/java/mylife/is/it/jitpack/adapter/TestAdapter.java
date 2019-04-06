package mylife.is.it.jitpack.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mylife.is.it.jitpack.R;
import mylife.is.it.jitpack.room.TestBean;

public class TestAdapter extends PagedListAdapter<TestBean, TestAdapter.TestViewHolder> {

    public TestAdapter() {
        super(new DiffUtil.ItemCallback<TestBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull TestBean testBean, @NonNull TestBean t1) {
                return testBean.userID == t1.userID;
            }

            @Override
            public boolean areContentsTheSame(@NonNull TestBean testBean, @NonNull TestBean t1) {
                return testBean.equals(t1);
            }
        });
    }


    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder testViewHolder, int i) {
        testViewHolder.age.setText(getItem(i).getAge());
        testViewHolder.name.setText(getItem(i).getName());
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {

        private TextView name, age;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            age = itemView.findViewById(R.id.text_age);
        }
    }
}
