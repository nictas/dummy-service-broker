package com.sap.broker.budgie;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestUtil {

    public static String toFormattedJson(Object object) {
        return new GsonBuilder().setPrettyPrinting()
            .create()
            .toJson(object);
    }

    public static <T> T loadResourceAsObject(String resourcePath, Class<T> resourceType, Class<?> caller) throws IOException {
        String resourceJson = loadResourceAsString(resourcePath, caller);
        return new Gson().fromJson(resourceJson, resourceType);
    }

    public static String loadResourceAsString(String resourcePath, Class<?> caller) throws IOException {
        InputStream resourceStream = caller.getResourceAsStream(resourcePath);
        String resourceString = IOUtils.toString(resourceStream, StandardCharsets.UTF_8);
        return resourceString.replace("\r", "");
    }

}
