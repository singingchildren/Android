package com.wangzijie.nutrition_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangZequan
 * @time 2019/4/21 22:50
 * @describe /自定义设置侧滑菜单ListView的Adapter
 */
public class DrawerAdapter extends BaseAdapter {
    //存储侧滑菜单中的各项的数据
    List<TuiCoolMenuItem> MenuItems = new ArrayList<TuiCoolMenuItem>();
    //构造方法中传过来的activity
    Context context;
    //构造方法
    public DrawerAdapter(Context context) {

        this.context = context;
        MenuItems.add(new TuiCoolMenuItem("设置", R.color.red));
    }

    @Override
    public int getCount() {

        return MenuItems.size();

    }

    @Override
    public TuiCoolMenuItem getItem(int position) {

        return MenuItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.menudrawer_item, parent, false);
            ((TextView) view).setText(getItem(position).menuTitle);
            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getItem(position).menuIcon, 0, 0, 0);
        }
        return view;
    }

    /**
     * 定义菜单项类
     */
    class TuiCoolMenuItem {
        String menuTitle;
        int menuIcon;

        //构造方法
        public TuiCoolMenuItem(String menuTitle, int menuIcon) {
            this.menuTitle = menuTitle;
            this.menuIcon = menuIcon;
        }

    }

}
