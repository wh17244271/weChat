package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.Index;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IndexMappingMpTables {
    private static  Map<Index,String>  indexTable = new HashMap<>();
    private final static  String DA_MP_GATHER_DATA_LOAD = "DA_MP_GATHER_DATA_LOAD";
    private final static  String DA_MP_GATHER_DATA = "DA_MP_GATHER_DATA";

    static {
        //负荷表
        indexTable.put(Index.Ua,DA_MP_GATHER_DATA_LOAD);
        indexTable.put(Index.Ub,DA_MP_GATHER_DATA_LOAD);
        indexTable.put(Index.Uc,DA_MP_GATHER_DATA_LOAD);
        indexTable.put(Index.Ia,DA_MP_GATHER_DATA_LOAD);
        indexTable.put(Index.Ib,DA_MP_GATHER_DATA_LOAD);
        indexTable.put(Index.Ic,DA_MP_GATHER_DATA_LOAD);
        //有功表
        indexTable.put(Index.Pa,DA_MP_GATHER_DATA);
        indexTable.put(Index.Pb,DA_MP_GATHER_DATA);
        indexTable.put(Index.Pc,DA_MP_GATHER_DATA);
        indexTable.put(Index.P,DA_MP_GATHER_DATA);
        indexTable.put(Index.SPZW,DA_MP_GATHER_DATA);

    }

    public static Map<String, Set<Index>> parseIndex(Index[] indexNo){

        Map<String, Set<Index>>  newMap = new HashMap<>();
        if(StringUtils.isEmpty(indexNo)){
            newMap.put(DA_MP_GATHER_DATA_LOAD,null);
            newMap.put(DA_MP_GATHER_DATA,null);
            return newMap;
        }
        Set<Index> indexList = null;
        for(Index index : indexNo){
            String tableName = indexTable.get(index);

            if(newMap.containsKey(tableName)){
                indexList = newMap.get(tableName);
            }else{
                indexList = new TreeSet<>();
            }
            indexList.add(index);
            newMap.put(tableName,indexList);

        }
        if(newMap.isEmpty()){
            newMap.put(DA_MP_GATHER_DATA_LOAD,null);
            newMap.put(DA_MP_GATHER_DATA,null);
        }
        return newMap;

    }

    public static void main(String[] args) {
        Index[] indexes = {/*Index.SPZW,Index.Ia,Index.Pb,Index.Ib,Index.Ib*/}; //01010001
        Map<String, Set<Index>> stringListMap = IndexMappingMpTables.parseIndex(indexes);
        System.out.println(stringListMap.toString());

    }

}
