package index_fragment.Gundam_fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.time_line.R;

import index_fragment.Adapter.ExpandableListviewAdapter;

public class Serise extends Gundam_Fragment {
    private String title="高达系列";
    private ExpandableListView expand_list_id;
    //Model：定义的数据
    private String[] groups = {"UC", "00", "Seed"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs = {{"0079", "0080", "08MS", "0083","Z_Gundam","ZZ_Gundam","逆袭的夏亚","独角兽"}, {"00", "00第二部", "00剧场版"}, {"Seed HD", "Seed Destiny HD"}};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_serise, container, false);
    }
    public String getTitle(){
        return title;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    private void initView(View view){
        expand_list_id=view.findViewById(R.id.Serise_ExpandListView);
        ExpandableListviewAdapter adapter=new ExpandableListviewAdapter(getContext(),groups,childs);
        expand_list_id.setAdapter(adapter);
        //默认展开第一个数组
        expand_list_id.expandGroup(0);
        //关闭数组某个数组，可以通过该属性来实现全部展开和只展开一个列表功能
        //expand_list_id.collapseGroup(0);
        expand_list_id.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                //showToastShort(groups[groupPosition]);
                return false;
            }
        });
        //子视图的点击事件
        expand_list_id.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                //showToastShort(childs[groupPosition][childPosition]);
                return true;
            }
        });
        //用于当组项折叠时的通知。
        expand_list_id.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //showToastShort("折叠了数据___"+groups[groupPosition]);
            }
        });
        //
        //用于当组项折叠时的通知。
        expand_list_id.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //showToastShort("展开了数据___"+groups[groupPosition]);
            }
        });
    }
}
