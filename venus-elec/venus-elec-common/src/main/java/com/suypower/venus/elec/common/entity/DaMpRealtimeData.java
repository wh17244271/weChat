package com.suypower.venus.elec.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maofukai
 * @date   2019-07-12
 * 测点实时数据
 */
public class DaMpRealtimeData extends DaMpBaseInfo {

    /**
     * 实时数据集合
     */

    private List<DaDataItem> data = new ArrayList<>();

    public List<DaDataItem> getData() {
        return data;
    }

    public void setData(List<DaDataItem> data) {
        this.data = data;
    }

    public void addDataItem(DaDataItem daDataItem){
        this.data.add(daDataItem);
    }

    public void removeDataItem(DaDataItem daDataItem){
        this.data.remove(daDataItem);

       // this.addDataItem(new DaDataItem(Index.Ia, Maths.digits(Math.random()*100D,2)));
    }


}
