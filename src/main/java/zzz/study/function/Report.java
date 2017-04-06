package zzz.study.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shuqin on 17/3/30.
 */
public class Report {

    public static void report(List<String> fields, List<Person> persons) {
        List<String> titles = fields.stream().map(
                field -> FieldConfAccompany.getInstance(field).getTitle()
        ).collect(Collectors.toList());
        String reportTitle = join(titles, ",");

        List<String> rows = persons.stream().map(
                p -> {
                    List<String> row = fields.stream().map(
                            field -> FieldConfAccompany.getInstance(field).getMethod().apply(p)
                    ).collect(Collectors.toList());
                    return join(row, ",");
                }
        ).collect(Collectors.toList());

        System.out.println(reportTitle);
        System.out.println(join(rows,"\n"));

    }

    public static String join(List<String> strs, String sep) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.size() == 0) { return ""; }
        if (strs.size() == 1) {return strs.get(0); }
        sb.append(strs.get(0));
        for (int i=1; i< strs.size(); i++) {
            sb.append(sep); sb.append(strs.get(i));
        }
        return sb.toString();
    }

}