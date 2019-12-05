package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.service.IDaMpDataService;
import com.suypower.venus.elec.common.service.IDaOrgDataService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("daOrgDataService")
public class DaOrgDataServiceImpl implements IDaOrgDataService {


    @Override
    public List<DaOrgDayData> queryOrgDayData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes) {
        return null;
    }

    @Override
    public List<DaOrgDayMostData> queryOrgDayMostData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes) {
        return null;
    }

    @Override
    public List<DaOrgDayDosageData> queryOrgDayDosageData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes) {
        return null;
    }

    @Override
    public List<DaOrgMonthData> queryOrgMonthData(String orgNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes) {
        return null;
    }

    @Override
    public List<DaOrgMonthDosageData> queryOrgMonthDosageData(String orgNo, String[] dataDates, UnitType[] unitTypes, Index[] indexes) {
        return null;
    }
}
