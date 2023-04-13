package com.alvonellos.interview.Interviews.Google;

import java.util.List;

public class Solution {
    String[] topics = {"DataWarehousing: Fact N Dimension Tables, Star Schema",
                        "snowflake schema, slowly changing dimensions"};


    String[] sqlTopics = {"SQL analytic functions", "Apache Beam"};



    /**
     * Table A
     * Val
     * 1
     * 2
     * 3
     * 4
     * 5
     */

    //write two queries
    //1). select sum
    //2). select second from max; select * from (select val, row_number() over (order by val desc) as rn from a) where rn = 2
    //3).
    //select max(val) from a where val not in (select max(val) from a)



}
