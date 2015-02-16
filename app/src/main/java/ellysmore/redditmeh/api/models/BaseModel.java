package ellysmore.redditmeh.api.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class BaseModel {

    public static <T extends BaseModel> T buildFromJson(InputStream in, Class<T> tClass,
            boolean shouldUseExposeAnnotations) {
        GsonBuilder builder = new GsonBuilder();
        if (shouldUseExposeAnnotations) {
            builder.excludeFieldsWithoutExposeAnnotation();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        JsonReader reader = new JsonReader(new BufferedReader(inputStreamReader));
        Gson gson = builder.create();
        return gson.fromJson(reader, tClass);
    }

    public static <T extends BaseModel> ArrayList<T> buildFromJson(JSONArray jsonArray,
            Class<T> tClass, Type type) {
        ArrayList<T> results = new ArrayList<T>();
        if (jsonArray != null) {
            results = new Gson().fromJson(jsonArray.toString(), type);
        }
        return results;
    }
}
