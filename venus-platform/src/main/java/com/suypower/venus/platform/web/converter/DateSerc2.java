package com.suypower.venus.platform.web.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DateSerc2 extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
       // super.serialize(value,gen,serializers);
       int i =0;
      // gen.writeEmbeddedObject("sd");
//        Map<String,Object> d = new HashMap<String,Object>();
//        d.put("s","dsd");
//       gen.writeObjectField("ds",d);
    }
}
