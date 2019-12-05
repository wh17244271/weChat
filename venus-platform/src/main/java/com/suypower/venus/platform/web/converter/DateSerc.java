package com.suypower.venus.platform.web.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DateSerc extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
       int i =0;
       //gen.writeString("sd");

        Map<String,Object> d = new HashMap<String,Object>();
        d.put("s","dsd");
        gen.writeStartObject();
        gen.writeStringField("323","323");
       // gen.writeObjectFieldStart("dsd");
       // gen.writeString("323");
        gen.writeEndObject();
//       gen.writeObjectField("ds",d);
    }
}
