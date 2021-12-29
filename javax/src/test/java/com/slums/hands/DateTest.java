package com.slums.hands;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/27 14:39
 * @version: 1.0
 */
public class DateTest {
    @Test
    public void test() {

//每日拉取增量数据
        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.SEPTEMBER, 26);
//2021-09-25
        while (cal.get(Calendar.YEAR) < 2022 && cal.get(Calendar.MONTH) < 9) {
            String date_str = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
//     spark.sql(s"""
// insert into `spark_cred_r_data_mongo`.`riskevaluatelogdoc_hash_pt_new_back` select `_id`,
// `evaluateContext`,
// `decisionCode`,
// `evaluateType`,
// `businessId`,
// `quotaResult`,
// `productId`,
// `idNumber`,
// `idNumber_md5`,
// `evaluateResult`,
// `evaluateDateTime`,
// `riskId`,
// `department`,
// `flowNo` ,
// `sceneno`,`pt` from spark_cred_r_data_mongo.riskevaluatelogdoc_hash_pt_new where pt = '$date_str'
// """)
            System.out.println(date_str);
            cal.add(Calendar.DATE, 1);
        }
    }
}

