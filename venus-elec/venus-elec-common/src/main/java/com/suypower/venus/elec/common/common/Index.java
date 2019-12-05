package com.suypower.venus.elec.common.common;

import com.fasterxml.jackson.annotation.JsonValue;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.platform.share.entity.IEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-09 系统指标定义
 */
public enum Index implements IEnum<String> {

    Ua("01010001", "ua", "A相电压", "0101"),
    Ub("01010002", "ub", "B相电压", "0101"),
    Uc("01010003", "uc", "C相电压", "0101"),
    Uapc("01010004", "Uapc", "A相电压偏差", "0101"),
    Ubpc("01010005", "Ubpc", "B相电压偏差", "0101"),
    Ucpc("01010006", "Ucpc", "C相电压偏差", "0101"),
    AB("01010007", "AB", "AB线电压", "0101"),
    BC("01010008", "BC", "BC线电压", "0101"),
    CA("01010009", "CA", "CA线电压", "0101"),
    Uab("01010010", "Uab", "Uab线电压偏差", "0101"),
    Ubc("01010011", "Ubc", "Ubc线电压偏差", "0101"),
    Uca("01010012", "Uca", "Uca线电压偏差", "0101"),
    Ubph("01010013", "Ubph", "电压不平衡度", "0101"),
    UaUb("01010014", "UaUb", "Ua、Ub相位角", "0101"),
    UbUc("01010015", "UbUc", "Ub、Uc相位角", "0101"),
    UcUa("01010016", "UcUa", "Uc、Ua相位角", "0101"),

    Ia("01020001", "ia", "A相电流", "0102"),
    Ib("01020002", "ib", "B相电流", "0102"),
    Ic("01020003", "ic", "C相电流", "0102"),
    Ibph("01020004", "Ibph", "电流不平衡度", "0102"),
    IaIb("01020005", "IaIb", "Ia、Ib相位角", "0102"),
    IbIc("01020006", "IbIc", "IbIc相位角", "0102"),
    IcIa("01020007", "IcIa", "Ic、Ia相位角", "0102"),
    Ilx("01020008", "ic", "零序电流", "0102"),
    Ild("01020009", "ic", "漏电电流", "0102"),

    Pa("01030001", "pa", "A相有功功率", "0103"),
    Pb("01030002", "pb", "B相有功功率", "0103"),
    Pc("01030003", "pc", "C相有功功率", "0103"),
    P("01030004", "p", "总有功功率 ", "0103"),
    Pasz("01030005", "Pasz", "A相视在功率 ", "0103"),
    Pbsz("01030006", "Pbsz", "B相视在功率 ", "0103"),
    Pcsz("01030007", "pcsz", "C相视在功率 ", "0103"),
    Psz("01030008", "Psz", "总视在功率 ", "0103"),
    Pawg("01030009", "Pawg", "A相无功功率 ", "0103"),
    Pbwg("01030010", "Pbwg", "B相无功功率 ", "0103"),
    Pcwg("01030011", "Pcwg", "C相无功功率 ", "0103"),
    Pwg("01030012", "Pwg", "总无功功率 ", "0103"),
    Pagl("01030013", "Pagl", "A相功率因数 ", "0103"),
    Pbgl("01030014", "Pbgl", "B相功率因数 ", "0103"),
    Pcgl("01030015", "Pcgl", "C相功率因数 ", "0103"),
    Pgl("01030016", "Pgl", "总功率因数 ", "0103"),

    SPZW("01040001", "spzw", "正向有功电能示值 ", "0104"),
    fxyg("01040002", "fxyg", "反向有功电能示值 ", "0104"),
    zxwg("01040003", "zxwg", "正向无功电能示值 ", "0104"),
    fxwg("01040004", "fxwg", "反向无功电能示值 ", "0104"),
    zxygz("01040005", "zxygz", "正向有功总电量 ", "0104"),
    zxygj("01040006", "zxygj", "正向有功尖电量 ", "0104"),
    zxygf("01040007", "zxygf", "正向有功峰电量 ", "0104"),
    zxygg("01040008", "zxygg", "正向有功谷电量 ", "0104"),
    zxygp("01040009", "zxygp", "正向有功平电量 ", "0104"),
    zxwgz("01040010", "zxwgz", "正向无功总电量 ", "0104"),
    zxwgj("01040011", "zxwgj", "正向无功尖电量 ", "0104"),
    zxwgf("01040012", "zxwgf", "正向无功峰电量 ", "0104"),
    zxwgg("01040013", "zxwgg", "正向无功谷电量 ", "0104"),
    zxwgp("01040014", "zxwgp", "正向无功平电量 ", "0104"),
    fxygz("01040015", "fxygz", "反向有功总电量 ", "0104"),
    fxygj("01040016", "fxygj", "反向有功尖电量 ", "0104"),
    fxygf("01040017", "fxygf", "反向有功峰电量 ", "0104"),
    fxygg("01040018", "fxygg", "反向有功谷电量 ", "0104"),
    fxygp("01040019", "fxygp", "反向有功平电量 ", "0104"),
    fxwgz("01040020", "fxwgz", "反向无功总电量 ", "0104"),
    fxwgj("01040021", "fxwgj", "反向无功尖电量 ", "0104"),
    fxwgf("01040022", "fxwgf", "反向无功峰电量 ", "0104"),
    fxwgg("01040023", "fxwgg", "反向无功谷电量 ", "0104"),
    fxwgp("01040024", "fxwgp", "反向无功平电量 ", "0104"),
    zxygdla("01040025", "zxygdla", "正向有功电量A相 ", "0104"),
    zxygdlb("01040026", "zxygdlb", "正向有功电量B相 ", "0104"),
    zxygdlc("01040027", "zxygdlc", "正向有功电量C相 ", "0104"),
    fxygdla("01040028", "fxygdla", "反向有功电量A相 ", "0104"),
    fxygdlb("01040029", "fxygdlb", "反向有功电量B相 ", "0104"),
    fxygdlc("01040030", "fxygdlc", "反向有功电量C相 ", "0104"),
    zxwgdla("01040031", "zxwgdla", "正向无功电量A相 ", "0104"),
    zxwgdlb("01040032", "zxwgdlb", "正向无功电量B相 ", "0104"),
    zxwgdlc("01040033", "zxwgdlc", "正向无功电量C相 ", "0104"),
    fxwgdla("01040034", "fxwgdla", "反向无功电量A相 ", "0104"),
    fxwgdlb("01040035", "fxwgdlb", "反向无功电量B相 ", "0104"),
    fxwgdlc("01040036", "fxwgdlc", "反向无功电量C相 ", "0104"),

    zxygxl("01050001", "zxygxl", "正向有功需量 ", "0105"),
    fxygxl("01050002", "fxygxl", "反向有功需量 ", "0105"),
    zxwgxl("01050003", "zxwgxl", "正向无功需量 ", "0105"),
    fxwgxl("01050004", "fxwgxl", "反向无功需量 ", "0105"),
    zxszxl("01050005", "zxszxl", "正向视在需量 ", "0105"),
    fxszxl("01050006", "fxszxl", "反向视在需量 ", "0105"),

    jbzyggl("01060001", "jbzyg", "基波总有功功率 ", "0106"),
    xbzyggl("01060002", "xbzyggl", "谐波总有功功率 ", "0106"),
    Iajbyxz("01060003", "Iajbyxz", "A相电流基波有效值 ", "0106"),
    Ibjbyxz("01060004", "Ibjbyxz", "B相电流基波有效值 ", "0106"),
    Icjbyxz("01060005", "Icjbyxz", "C相电流基波有效值 ", "0106"),
    Paxbdljbl("01060006", "Paxbdljbl", "A相总谐波电流畸变率 ", "0106"),
    Pbxbdljbl("01060007", "Pbxbdljbl", "B相总谐波电流畸变率 ", "0106"),
    Pcxbdljbl("01060008", "Pcxbdljbl", "C相总谐波电流畸变率 ", "0106"),
    Iajcxbdljbl("01060009", "Iajcxbdljbl", "A相奇次谐波电流畸变率 ", "0106"),
    Ibjcxbdljbl("01060010", "Ibjcxbdljbl", "B相奇次谐波电流畸变率 ", "0106"),
    Icjcxbdljbl("01060011", "Icjcxbdljbl", "C相奇次谐波电流畸变率 ", "0106"),

    Aocxbdljbl("01060012", "Aocxbdljbl", "A相偶次谐波电流畸变率 ", "0106"),
    Bocxbdljbl("01060013", "Bocxbdljbl", "B相偶次谐波电流畸变率 ", "0106"),
    Cocxbdljbl("01060014", "Cocxbdljbl", "C相偶次谐波电流畸变率 ", "0106"),
    Iaxbhyl2("01060015", "Iaxbhyl2", "A相电流2次谐波含有率 ", "0106"),
    Iaxbhyl3("01060016", "Iaxbhyl3", "A相电流3次谐波含有率 ", "0106"),
    Iaxbhyl4("01060017", "Iaxbhyl4", "A相电流4次谐波含有率 ", "0106"),
    Iaxbhyl5("01060018", "Iaxbhyl5", "A相电流5次谐波含有率 ", "0106"),
    Iaxbhyl6("01060019", "Iaxbhyl6", "A相电流6次谐波含有率 ", "0106"),
    Iaxbhyl7("01060020", "Iaxbhyl7", "A相电流7次谐波含有率 ", "0106"),
    Iaxbhyl8("01060021", "Iaxbhyl8", "A相电流8次谐波含有率 ", "0106"),
    Iaxbhyl9("01060022", "Iaxbhyl9", "A相电流9次谐波含有率 ", "0106"),
    Iaxbhyl10("01060023", "Iaxbhyl10", "A相电流10次谐波含有率 ", "0106"),
    Iaxbhyl11("01060024", "Iaxbhyl11", "A相电流11次谐波含有率 ", "0106"),
    Iaxbhyl12("01060025", "Iaxbhyl12", "A相电流12次谐波含有率 ", "0106"),
    Iaxbhyl13("01060026", "Iaxbhyl13", "A相电流13次谐波含有率 ", "0106"),
    Iaxbhyl14("01060027", "Iaxbhyl14", "A相电流14次谐波含有率 ", "0106"),
    Iaxbhyl15("01060028", "Iaxbhyl15", "A相电流15次谐波含有率 ", "0106"),
    Iaxbhyl16("01060029", "Iaxbhyl16", "A相电流16次谐波含有率 ", "0106"),
    Iaxbhyl17("01060030", "Iaxbhyl17", "A相电流17次谐波含有率 ", "0106"),
    Iaxbhyl18("01060031", "Iaxbhyl18", "A相电流18次谐波含有率    ", "0106"),
    Iaxbhyl19("01060032", "Iaxbhyl19", "A相电流19次谐波含有率 ", "0106"),
    Iaxbhyl20("01060033", "Iaxbhyl20", "A相电流20次谐波含有率 ", "0106"),
    Iaxbhyl21("01060034", "Iaxbhyl21", "A相电流21次谐波含有率 ", "0106"),

    Ibxbhyl2("01060035", "Ibxbhyl", "B相电流2次谐波含有率 ", "0106"),
    Ibxbhyl3("01060036", "Ibxbhyl", "B相电流3次谐波含有率 ", "0106"),
    Ibxbhyl4("01060037", "Ibxbhyl", "B相电流4次谐波含有率 ", "0106"),
    Ibxbhyl5("01060038", "Ibxbhyl", "B相电流5次谐波含有率 ", "0106"),
    Ibxbhyl6("01060039", "Ibxbhyl", "B相电流6次谐波含有率 ", "0106"),
    Ibxbhyl7("01060040", "Ibxbhyl", "B相电流7次谐波含有率 ", "0106"),
    Ibxbhyl8("01060041", "Ibxbhyl", "B相电流8次谐波含有率 ", "0106"),
    Ibxbhyl9("01060042", "Ibxbhyl", "B相电流9次谐波含有率 ", "0106"),
    Ibxbhyl10("01060043", "Ibxbhyl", "B相电流10次谐波含有率 ", "0106"),
    Ibxbhyl11("01060044", "Ibxbhyl", "B相电流11次谐波含有率 ", "0106"),
    Ibxbhyl12("01060045", "Ibxbhyl", "B相电流12次谐波含有率 ", "0106"),
    Ibxbhyl13("01060046", "Ibxbhyl", "B相电流13次谐波含有率 ", "0106"),
    Ibxbhyl14("01060047", "Ibxbhyl", "B相电流14次谐波含有率 ", "0106"),
    Ibxbhyl15("01060048", "Ibxbhyl", "B相电流15次谐波含有率 ", "0106"),
    Ibxbhyl16("01060049", "Ibxbhyl", "B相电流16次谐波含有率 ", "0106"),
    Ibxbhyl17("01060050", "Ibxbhyl", "B相电流17次谐波含有率 ", "0106"),
    Ibxbhyl18("01060051", "Ibxbhyl", "B相电流18次谐波含有率 ", "0106"),
    Ibxbhyl19("01060052", "Ibxbhyl", "B相电流19次谐波含有率 ", "0106"),
    Ibxbhyl20("01060053", "Ibxbhyl", "B相电流20次谐波含有率 ", "0106"),
    Ibxbhyl21("01060054", "Ibxbhyl", "B相电流21次谐波含有率 ", "0106"),

    Icxbhyl2("01060055", "Icxbhyl2", "C相电流2次谐波含有率 ", "0106"),
    Icxbhyl3("01060056", "Icxbhyl3", "C相电流3次谐波含有率 ", "0106"),
    Icxbhyl4("01060057", "Icxbhyl4", "C相电流4次谐波含有率 ", "0106"),
    Icxbhyl5("01060058", "Icxbhyl5", "C相电流5次谐波含有率 ", "0106"),
    Icxbhyl6("01060059", "Icxbhyl6", "C相电流6次谐波含有率 ", "0106"),
    Icxbhyl7("01060060", "Icxbhyl7", "C相电流7次谐波含有率 ", "0106"),
    Icxbhyl8("01060061", "Icxbhyl8", "C相电流8次谐波含有率 ", "0106"),
    Icxbhyl9("01060062", "Icxbhyl9", "C相电流9次谐波含有率 ", "0106"),
    Icxbhyl10("01060063", "Icxbhyl10", "C相电流10次谐波含有率 ", "0106"),
    Icxbhyl11("01060064", "Icxbhyl11", "C相电流11次谐波含有率 ", "0106"),
    Icxbhyl12("01060065", "Icxbhyl12", "C相电流12次谐波含有率 ", "0106"),
    Icxbhyl13("01060066", "Icxbhyl13", "C相电流13次谐波含有率 ", "0106"),
    Icxbhyl14("01060067", "Icxbhyl14", "C相电流14次谐波含有率 ", "0106"),
    Icxbhyl15("01060068", "Icxbhyl15", "C相电流15次谐波含有率 ", "0106"),
    Icxbhyl16("01060069", "Icxbhyl16", "C相电流16次谐波含有率 ", "0106"),
    Icxbhyl17("01060070", "Icxbhyl17", "C相电流17次谐波含有率 ", "0106"),
    Icxbhyl18("01060071", "Icxbhyl18", "C相电流18次谐波含有率 ", "0106"),
    Icxbhyl19("01060072", "Icxbhyl19", "C相电流19次谐波含有率 ", "0106"),
    Icxbhyl20("01060073", "Icxbhyl20", "C相电流20次谐波含有率 ", "0106"),
    Icxbhyl21("01060074", "Icxbhyl21", "C相电流21次谐波含有率 ", "0106"),

    Uajbyxz("01060075", "Uajbyxz", "A相电压基波有效值 ", "0106"),
    Ubjbyxz("01060076", "Ubjbyxz", "B相电压基波有效值 ", "0106"),
    Ucjbyxz("01060077", "Ucjbyxz", "C相电压基波有效值 ", "0106"),
    Uazxbjbl("01060078", "Uazxbjbl", "A相总谐波电压畸变率 ", "0106"),
    Ubzxbjbl("01060079", "Ubzxbjbl", "B相总谐波电压畸变率 ", "0106"),
    Uczxbjbl("01060080", "Uczxbjbl", "C相总谐波电压畸变率 ", "0106"),
    Uajcxbjbl("01060081", "Uajcxbjbl", "A相奇次谐波电压畸变率 ", "0106"),
    Ubjcxbjbl("01060082", "Ubjcxbjbl", "B相奇次谐波电压畸变率 ", "0106"),
    Ucjcxbjbl("01060083", "Ucjcxbjbl", "C相奇次谐波电压畸变率 ", "0106"),
    Uaocxbjbl("01060084", "Uaocxbjbl", "A相偶次谐波电压畸变率 ", "0106"),
    Ubocxbjbl("01060085", "Ubocxbjbl", "B相偶次谐波电压畸变率 ", "0106"),
    Ucocxbjbl("01060086", "Ucocxbjbl", "C相偶次谐波电压畸变率 ", "0106"),

    Uaxbhyl2("01060087", "Uaxbhyl2", "A相电压2次谐波含有率 ", "0106"),
    Uaxbhyl3("01060088", "Uaxbhyl3", "A相电压3次谐波含有率 ", "0106"),
    Uaxbhyl4("01060089", "Uaxbhyl4", "A相电压4次谐波含有率 ", "0106"),
    Uaxbhyl5("01060090", "Uaxbhyl5", "A相电压5次谐波含有率 ", "0106"),
    Uaxbhyl6("01060091", "Uaxbhyl6", "A相电压6次谐波含有率 ", "0106"),
    Uaxbhyl7("01060092", "Uaxbhyl7", "A相电压7次谐波含有率 ", "0106"),
    Uaxbhyl8("01060093", "Uaxbhyl8", "A相电压8次谐波含有率 ", "0106"),
    Uaxbhyl9("01060094", "Uaxbhyl9", "A相电压9次谐波含有率 ", "0106"),
    Uaxbhyl10("01060095", "Uaxbhyl10", "A相电压10次谐波含有率 ", "0106"),
    Uaxbhyl11("01060096", "Uaxbhyl11", "A相电压11次谐波含有率 ", "0106"),
    Uaxbhyl12("01060097", "Uaxbhyl12", "A相电压12次谐波含有率 ", "0106"),
    Uaxbhyl13("01060098", "Uaxbhyl13", "A相电压13次谐波含有率 ", "0106"),
    Uaxbhyl14("01060099", "Uaxbhyl14", "A相电压14次谐波含有率 ", "0106"),
    Uaxbhyl15("01060100", "Uaxbhyl15", "A相电压15次谐波含有率 ", "0106"),
    Uaxbhyl16("01060101", "Uaxbhyl16", "A相电压16次谐波含有率 ", "0106"),
    Uaxbhyl17("01060102", "Uaxbhyl17", "A相电压17次谐波含有率 ", "0106"),
    Uaxbhyl18("01060103", "Uaxbhyl18", "A相电压18次谐波含有率 ", "0106"),
    Uaxbhyl19("01060104", "Uaxbhyl19", "A相电压19次谐波含有率 ", "0106"),
    Uaxbhyl20("01060105", "Uaxbhyl20", "A相电压20次谐波含有率 ", "0106"),
    Uaxbhyl21("01060106", "Uaxbhyl21", "A相电压21次谐波含有率 ", "0106"),

    Ubxbhyl2("01060107", "Ubxbhyl2", "B相电压2次谐波含有率", "0106"),
    Ubxbhyl3("01060108", "Ubxbhyl3", "B相电压3次谐波含有率 ", "0106"),
    Ubxbhyl4("01060109", "Ubxbhyl4", "B相电压4次谐波含有率 ", "0106"),
    Ubxbhyl5("01060110", "Ubxbhyl5", "B相电压5次谐波含有率 ", "0106"),
    Ubxbhyl6("01060111", "Ubxbhyl6", "B相电压6次谐波含有率 ", "0106"),
    Ubxbhyl7("01060112", "Ubxbhyl7", "B相电压7次谐波含有率 ", "0106"),
    Ubxbhyl8("01060113", "Ubxbhyl8", "B相电压8次谐波含有率 ", "0106"),
    Ubxbhyl9("01060114", "Ubxbhyl9", "B相电压9次谐波含有率 ", "0106"),
    Ubxbhyl10("01060115", "Ubxbhyl10", "B相电压10次谐波含有率 ", "0106"),
    Ubxbhyl11("01060116", "Ubxbhyl11", "B相电压11次谐波含有率 ", "0106"),
    Ubxbhyl12("01060117", "Ubxbhyl12", "B相电压12次谐波含有率 ", "0106"),
    Ubxbhyl13("01060118", "Ubxbhyl13", "B相电压13次谐波含有率 ", "0106"),
    Ubxbhyl14("01060119", "Ubxbhyl14", "B相电压14次谐波含有率 ", "0106"),
    Ubxbhyl15("01060120", "Ubxbhyl15", "B相电压15次谐波含有率 ", "0106"),
    Ubxbhyl16("01060121", "Ubxbhyl16", "B相电压16次谐波含有率 ", "0106"),
    Ubxbhyl17("01060122", "Ubxbhyl17", "B相电压17次谐波含有率 ", "0106"),
    Ubxbhyl18("01060123", "Ubxbhyl18", "B相电压18次谐波含有率 ", "0106"),
    Ubxbhyl19("01060124", "Ubxbhyl19", "B相电压19次谐波含有率 ", "0106"),
    Ubxbhyl20("01060125", "Ubxbhyl20", "B相电压20次谐波含有率 ", "0106"),
    Ubxbhyl21("01060126", "Ubxbhyl21", "B相电压21次谐波含有率 ", "0106"),

    Ucxbhyl2("01060127", "Ucxbhyl2", "C相电压2次谐波含有率 ", "0106"),
    Ucxbhyl3("01060128", "Ucxbhyl3", "C相电压3次谐波含有率 ", "0106"),
    Ucxbhyl4("01060129", "Ucxbhyl4", "C相电压4次谐波含有率 ", "0106"),
    Ucxbhyl5("01060130", "Ucxbhyl5", "C相电压5次谐波含有率 ", "0106"),
    Ucxbhyl6("01060131", "Ucxbhyl6", "C相电压6次谐波含有率 ", "0106"),
    Ucxbhyl7("01060132", "Ucxbhyl7", "C相电压7次谐波含有率 ", "0106"),
    Ucxbhyl8("01060133", "Ucxbhyl8", "C相电压8次谐波含有率 ", "0106"),
    Ucxbhyl9("01060134", "Ucxbhyl9", "C相电压9次谐波含有率 ", "0106"),
    Ucxbhyl10("01060135", "Ucxbhyl10", "C相电压10次谐波含有率 ", "0106"),
    Ucxbhyl11("01060136", "Ucxbhyl11", "C相电压11次谐波含有率 ", "0106"),
    Ucxbhyl12("01060137", "Ucxbhyl12", "C相电压12次谐波含有率 ", "0106"),
    Ucxbhyl13("01060138", "Ucxbhyl13", "C相电压13次谐波含有率 ", "0106"),
    Ucxbhyl14("01060139", "Ucxbhyl14", "C相电压14次谐波含有率 ", "0106"),
    Ucxbhyl15("01060140", "Ucxbhyl15", "C相电压15次谐波含有率 ", "0106"),
    Ucxbhyl16("01060141", "Ucxbhyl16", "C相电压16次谐波含有率 ", "0106"),
    Ucxbhyl17("01060142", "Ucxbhyl17", "C相电压17次谐波含有率 ", "0106"),
    Ucxbhyl18("01060143", "Ucxbhyl18", "C相电压18次谐波含有率 ", "0106"),
    Ucxbhyl19("01060144", "Ucxbhyl19", "C相电压19次谐波含有率 ", "0106"),
    Ucxbhyl20("01060145", "Ucxbhyl20", "C相电压20次谐波含有率 ", "0106"),
    Ucxbhyl21("01060146", "Ucxbhyl21", "C相电压21次谐波含有率 ", "0106"),

    F("01990001", "f", "频率 ", "0199"),
    FD("01990002", "fd", "频率偏差 ", "0199"),
    LD("01990003", "ld", "负荷率 ", "0199"),
    HD("99010001", "hd", "湿度 ", "9901"),
    TT("99010002", "tt", "温度 ", "9901"),

    SWZW("11040001", "swzw", "用水示数 ", "1104"),
    SGZW("12040001", "sgzw", "用气示数 ", "1204"),
    SHZW("13040001", "shzw", "用热示数 ", "1304");


    /**
     * 获取指标编码
     */
    private String indBNo;

    /**
     * 获取指标符号
     */
    private String symbol;

    /**
     * 获取指标名称
     */
    private String name;
    /**
     * 获取指标分类
     */
    private String classify;

    Index(String indBNo, String symbol, String name, String classify) {
        this.indBNo = indBNo;
        this.symbol = symbol;
        this.name = name;
        this.classify = classify;
    }

    /**
     * 获取指标编码
     *
     * @return
     */
    @JsonValue
    public String getIndBNo() {
        return indBNo;
    }

    /**
     * 获取指标符号
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 获取指标名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取指标分类
     *
     * @return
     */
    public String getClassify() {
        return classify;
    }


    static Index[] list(Index... indexes) {
        return indexes;
    }

    public static Index[] parseOf(String... values) {
        List<Index> newIndexes = new ArrayList();
        Index[] indexes = values();
        for (String value : values) {
            for (Index index : indexes) {
                if (index.getIndBNo().equals(value)) {
                    newIndexes.add(index);
                    break;
                }
            }
        }
        return newIndexes.toArray(new Index[0]);
    }

    /**
     * 通过编号获取 Index
     *
     * @param value
     * @return
     */
    public static Index parse(String value) {
        Index find = null;
        Index[] indexes = values();
        for (Index index : indexes) {
            if (index.getIndBNo().equals(value)) {
                find = index;
                break;
            }
        }
        return find;
    }

    /**
     * 判断指标编号是否存在，并转化成 Index[]数组形式
     *
     * @param values
     * @return
     */
    public static Index[] parseOf(String values) {
        if (StringUtils.isEmpty(values)) return null;
        List<Index> newIndexes = new ArrayList();
        Index[] indexes = values();
        String[] valueses = values.split(",");
        boolean isExist = false; //判断指标编号是否存在，不存在则抛异常
        for (String value : valueses) {
            for (Index index : indexes) {
                if (index.getIndBNo().equals(value)) {
                    newIndexes.add(index);
                    isExist = true;
                    break;
                }
            }
            Assert.isFalse(isExist, "该指标编号不存在");
//            if (!isExist) {
//                throw new VenusResponseException(value + ":该指标编号不存在");
//            }
            isExist = false;
        }
        return newIndexes.toArray(new Index[0]);
    }


    @Override
    public String getId() {
        return getIndBNo();
    }

}
