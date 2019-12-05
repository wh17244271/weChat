package com.suypower.venus.platform.web.converter;

import com.suypower.venus.platform.share.entity.IEnum;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;


@Component
public class EnumConverterFactory implements ConverterFactory<String, IEnum> {

    @Override
    public <T extends IEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToIEum<>(targetType);
    }

    @SuppressWarnings("all")
    private static class StringToIEum<T extends IEnum> implements Converter<String, T> {
        private Class<T> targerType;
        public StringToIEum(Class<T> targerType) {
            this.targerType = targerType;
        }

        @Override
        public T convert(String source) {
            if (Strings.isEmpty(source)) {
                return null;
            }
            return (T) EnumConverterFactory.getIEnum(this.targerType, source);
        }
    }

    public static <T extends IEnum> Object getIEnum(Class<T> targetType, String source) {
        for (T enumObj : targetType.getEnumConstants()) {
            if (source.equals(String.valueOf(enumObj.getId()))) {
                return enumObj;
            }
        }
        return null;
    }
}
