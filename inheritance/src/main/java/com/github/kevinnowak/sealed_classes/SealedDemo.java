package com.github.kevinnowak.sealed_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

sealed interface JSONValue {

    default String type() {
        return switch (this) {
            case JSONArray _ -> "array";
            case JSONObject _ -> "object";
            case JSONNumber _ -> "number";
            case JSONString _ -> "string";
            case JSONBoolean _ -> "boolean";
            case JSONNull _ -> "null";
        };
    }
}

final class JSONArray extends ArrayList<JSONValue> implements JSONValue { }

final class JSONObject extends HashMap<String, JSONValue> implements JSONValue {

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map.Entry<String, JSONValue> entry : entrySet()) {
            if (result.length() > 1) {
                result.append(",");
            }

            result.append(" \"");
            result.append(entry.getKey());
            result.append("\":");
            result.append(entry.getValue());
        }

        result.append(" }");

        return result.toString();
    }
}

sealed interface JSONPrimitive extends JSONValue permits JSONNumber, JSONString, JSONBoolean, JSONNull {}

record JSONNumber(double value) implements JSONPrimitive {

    @Override
    public String toString() {
        return "" + value;
    }
}

record JSONString(String value) implements JSONPrimitive {

    @Override
    public String toString() {
        return "\"" + value.translateEscapes() + "\"";
    }
}

enum JSONBoolean implements JSONPrimitive {

    FALSE,
    TRUE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}

enum JSONNull implements JSONPrimitive {

    INSTANCE;

    @Override
    public String toString() {
        return "null";
    }
}

class SealedDemo {

    void main() {
        JSONObject obj = new JSONObject();
        obj.put("name", new JSONString("Harry"));
        obj.put("salary", new JSONNumber(90_000));
        obj.put("married", JSONBoolean.FALSE);
        JSONArray arr = new JSONArray();
        arr.add(new JSONNumber(13));
        arr.add(JSONNull.INSTANCE);

        obj.put("luckyNumbers", arr);
        IO.println(obj);
        IO.println(obj.type());
    }
}
