package com.example.project1.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.models.Models;
import com.like.LikeButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {
    ImageView imageView;
    Spinner spinner;

    private HomeViewModel homeViewModel;
    private MainAdapter adapter;
    private List<Models> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        spinner= view.findViewById(R.id.main_spinner);
        test();
        setupSort();


    }

    private void test() {
        list.add(new Models(
                "https://media.issyk-kul.pro/CACHE/images/hotel/3/3/7b9dd0da-83f8-4cd5-91e5-8f8a6f1f2531/6de5fdc268a37fe5ecaba0b7d6ee6d16.jpg",
                "Голубой Иссык куль",
                "Чолпон - ата",
                "круглый год, лечебный",
                2000, 7.0f ));
        list.add(new Models(
                "https://total.kz/storage/96/9656e07cf91c06b07f1696cc77d91b95.jpg",
                "Золотые пески",
                "Бостери",
                "молодежный",
                3000 , 6.0f));
        list.add(new Models(
                "https://media.issyk-kul.pro/CACHE/images/hotel/4/42/d9324d5e-6786-48f5-be00-e8b1722fe637/e391e238f369848649365f4836eebab4.jpg",
                "Аврора",
                "Аврора",
                "лечебный",
                2500, 5.0f ));
    }


    private void setupSort() {
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.sort,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){
                    case 0:
                        sortByRating();
                        break;
                    case 1:
                        sortByName();
                        break;
                    case 2:
                        sortByPrice();
                        break;
                }
                
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void sortByName() {
        Collections.sort(list,  (l1, l2) -> l1.getName().compareTo(l2.getName()));
        adapter.notifyDataSetChanged();
    }

    private void sortByPrice() {
        Collections.sort(list, (l1, l2) -> {
            if (l1.getCost() > l2.getCost()) {
                return 1;
            } else if (l1.getCost() < l2.getCost()) {
                return -1;
            } else {
                return 0;
            }
        });
        adapter.notifyDataSetChanged();
    }
    private void sortByRating() {
        Collections.sort(list, (l1, l2) -> {
            if (l1.getRatingBar() > l2.getRatingBar()) {
                return -1;
            } else if (l1.getRatingBar() < l2.getRatingBar()) {
                return 1;
            } else {
                return 0;
            }
        });
        adapter.notifyDataSetChanged();
    }
}