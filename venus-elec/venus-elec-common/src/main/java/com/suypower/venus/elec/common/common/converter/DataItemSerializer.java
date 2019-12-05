package com.suypower.venus.elec.common.common.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.entity.DaDataItem;

import java.io.IOException;

public class DataItemSerializer extends JsonSerializer<DaDataItem> {

    @Override
    public void serialize(DaDataItem value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        String indBNo = null,symbol =null,name= null,classify=null;
        if(value.getIndex()!=null) {
            Index index  = value.getIndex();
            indBNo     = index.getIndBNo();
            symbol     = index.getSymbol();
            name       = index.getName();
            classify   = index.getClassify();
        }
        gen.writeStringField("indBNo", indBNo);
        gen.writeStringField("symbol", symbol);
        gen.writeStringField("name", name);
        gen.writeStringField("classify", classify);
        gen.writeNumberField("value",value.getValue());
        gen.writeEndObject();
    }
}
