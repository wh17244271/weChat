package com.suypower.venus.elec.common.common.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.suypower.venus.elec.common.common.UnitType;

import java.io.IOException;

public class UnitTypeSerializer extends JsonSerializer<UnitType> {

    @Override
    public void serialize(UnitType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("unitTypeNo",   value.getUnitTypeNo());
        gen.writeStringField("unitTypeName", value.getUnitTypeName());
        gen.writeNumberField("sort",         value.getSort());
        gen.writeEndObject();
    }
}
