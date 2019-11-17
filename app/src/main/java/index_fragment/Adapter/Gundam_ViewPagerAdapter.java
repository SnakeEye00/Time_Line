package index_fragment.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import index_fragment.Gundam_fragments.Gundam_Fragment;

public class Gundam_ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Gundam_Fragment> fragmentList;
    public Gundam_ViewPagerAdapter(FragmentManager fm, List<Gundam_Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }
    //根据对应的位置返回对应的fragment
    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
