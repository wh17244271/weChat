package com.suypower.venus.elec.common.common.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;

import java.io.IOException;

public class IndexSerializer extends JsonSerializer<Index> {

    @Override
    public void serialize(Index value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("indBNo",   value.getIndBNo());
        gen.writeStringField("symbol",   value.getSymbol());
        gen.writeStringField("name",     value.getName());
        gen.writeStringField("classify", value.getClassify());
        gen.writeEndObject();
    }
}
