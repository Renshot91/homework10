package org.example;

import java.util.*;

//Сформировать SQL запрос:  Вернуть все записи из cars, где параметры равны заданным, используя StringBuilder.
//        Если значение null, то параметр не должен попадать в запрос.
//        {"model", "V-60", "country", "Germany", "city", "Berlin", "year", null, "active", true}
//
//
//        Пример: {"id", 1, "country", null, "city", "Helsinki", "year", null}
//        Результат: SELECT * FROM users WHERE id = '1'  AND city = 'Helsilnki';



public class Main {
    public static void main(String[] args) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("model", "V-60");
        queryParams.put("country", "Germany");
        queryParams.put("city", "Berlin");
        queryParams.put("year", null);
        queryParams.put("active", true);

        String sqlQuery = buildQuery("cars", queryParams);
        System.out.println(sqlQuery);
    }

    public static String buildQuery(String tableName, Map<String, Object> queryParams) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");

        List<String> conditions = new ArrayList<>();
        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value != null) {
                if (value instanceof String) {
                    conditions.add(key + " = '" + value + "'");
                } else {
                    conditions.add(key + " = " + value);
                }
            }
        }

        queryBuilder.append(String.join(" AND ", conditions));
        return queryBuilder.toString();
    }
}
