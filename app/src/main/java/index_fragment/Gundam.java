package index_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.time_line.R;

import java.util.ArrayList;
import java.util.List;

import index_fragment.Adapter.Gundam_ViewPagerAdapter;
import index_fragment.Gundam_fragments.Gundam_Fragment;
import index_fragment.Gundam_fragments.Gundam_geng;
import index_fragment.Gundam_fragments.Jiti;
import index_fragment.Gundam_fragments.Piolt;
import index_fragment.Gundam_fragments.Serise;

public class Gundam extends Fragment {
    private Context context;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getContext();
        return inflater.inflate(R.layout.fragment_gundam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=view.findViewById(R.id.Gundam_viewpager);
        List<Gundam_Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new Serise());
        fragmentList.add(new Jiti());
        fragmentList.add(new Piolt());
        fragmentList.add(new Gundam_geng());
        tabLayout=view.findViewById(R.id.Gundam_tablayout);
        Gundam_ViewPagerAdapter adapter=new Gundam_ViewPagerAdapter(getActivity().getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
