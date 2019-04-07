package mylife.is.it.jitpack.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import mylife.is.it.jitpack.R;
import mylife.is.it.jitpack.adapter.TestAdapter;
import mylife.is.it.jitpack.model.TestModel;
import mylife.is.it.jitpack.room.TestBean;

public class FourFragment extends Fragment {

    private TestModel mViewModel;
    private RecyclerView recyclerView;
    private TestAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.four_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new TestAdapter();
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        final Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(button).popBackStack();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TestModel.class);
        // TODO: Use the ViewModel
        mViewModel.build.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                adapter.submitList((PagedList<TestBean>) o);
            }
        });
    }

}
