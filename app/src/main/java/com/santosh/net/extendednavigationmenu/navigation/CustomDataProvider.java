package com.santosh.net.extendednavigationmenu.navigation;


import android.content.Context;

import com.santosh.net.extendednavigationmenu.R;

import java.util.ArrayList;
import java.util.List;


/*Created by: Quintus Labs
 *www.quintuslabs.com
 *Created On: 27/04/2018*/

public class CustomDataProvider {

    private static final int MAX_LEVELS = 3;

    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static List<BaseItem> mMenu = new ArrayList<>();
    Context context;

    public static List<BaseItem> getInitialItems() {
        //return getSubItems(new GroupItem("root"));

        List<BaseItem> rootMenu = new ArrayList<>();

        /*
         * ITEM = TANPA CHILD
         * GROUPITEM = DENGAN CHILD
         * */
        rootMenu.add(new Item("Home", R.drawable.ic_home_black_24dp));
        rootMenu.add(new GroupItem("Category", R.drawable.ic_widgets_black_24dp));
        rootMenu.add(new GroupItem("Assignments", R.drawable.ic_assignment_black_24dp));
        rootMenu.add(new Item("Help", R.drawable.ic_help_black_24dp));
        rootMenu.add(new Item("AboutUs", R.drawable.ic_error_black_24dp));
        return rootMenu;
    }

    public static List<BaseItem> getSubItems(BaseItem baseItem) {

        List<BaseItem> result = new ArrayList<>();
        int level = ((GroupItem) baseItem).getLevel() + 1;
        String menuItem = baseItem.getName();
        if (!(baseItem instanceof GroupItem)) {
            throw new IllegalArgumentException("GroupItem required");
        }

        GroupItem groupItem = (GroupItem) baseItem;
        if (groupItem.getLevel() >= MAX_LEVELS) {
            return null;
        }

        /*
         * HANYA UNTUK GROUP-ITEM
         * */
        switch (level) {
            case LEVEL_1:
                switch (menuItem.toUpperCase()) {

                    case "CATEGORY":
                        result = getListCategory();
                        break;
                    case "ASSIGNMENTS":
                        result = getListAssignments();
                        break;

                }
                break;
        }
        return result;
    }

    public static boolean isExpandable(BaseItem baseItem) {
        return baseItem instanceof GroupItem;
    }

    private static List<BaseItem> getListCategory() {
        List<BaseItem> list = new ArrayList<>();
        list.add(new Item("Category1"));
        list.add(new Item("Category2"));
        list.add(new Item("Category3"));


        return list;
    }

    private static List<BaseItem> getListAssignments() {
        List<BaseItem> list = new ArrayList<>();
        list.add(new Item("Assignment1"));
        list.add(new Item("Assignment2"));
        list.add(new Item("Assignment3"));
        list.add(new Item("Assignment4"));
        return list;
    }


}
