package com.cybertek.orm.cinemaapp.serializer;

import com.cybertek.orm.cinemaapp.annotations.CinemaSerializerAnn;
import com.cybertek.orm.cinemaapp.model.Model;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.hibernate.proxy.HibernateProxyHelper;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CinemaSerializer extends JsonSerializer<Model> {

    private List<String> fields = new ArrayList<>();

    @Override
    public void serialize(Model model, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //Open json start writing
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("id", model.getId());

        Class modelClass = HibernateProxyHelper.getClassWithoutInitializingProxy(model);

        if (modelClass.isAnnotationPresent(CinemaSerializerAnn.class)) {
            Annotation annotation = modelClass.getAnnotation(CinemaSerializerAnn.class);

            CinemaSerializerAnn cinemaSerializerAnn = (CinemaSerializerAnn) annotation;

            fields = Arrays.stream(cinemaSerializerAnn.fields()).collect(Collectors.toList());
        }

        fields.forEach(field -> {
            if (!field.equals("id")) {
                try {
                    Optional<Method> method = getDeclaredMethodForField(model, field);
                    if (method.isPresent()) {
                        Object getNameMethodInvoke = method.get().invoke(model);
                        jsonGenerator.writeObjectField(field, getNameMethodInvoke);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        jsonGenerator.writeEndObject();
    }

    private Optional<Method> getDeclaredMethodForField(Model model, String field) {
        Method method = null;

        // ex: if name is "name" ---> getName;
        String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);

        try {
            method = model.getClass().getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            try {
                method = model.getClass().getSuperclass().getDeclaredMethod(methodName);
            } catch (NoSuchMethodException ignored) {
            }
        }

        return Optional.ofNullable(method);
    }
}
