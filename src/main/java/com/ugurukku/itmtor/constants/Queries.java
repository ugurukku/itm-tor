package com.ugurukku.itmtor.constants;

public interface Queries {

  String TABLE_INCOMES = "SELECT dd.adi,\n" +
      "       IFNULL(dd.id, '000')             id,\n" +
      "       IFNULL(dd.req, '000')            req,\n" +
      "       IFNULL(dd.seksiya, '0')          seksiya,\n" +
      "       IFNULL(dd.ksetir, '0')           ksetir,\n" +
      "       dd.bosluq,\n" +
      "       IF(d1 = 0, 0, ROUND(dd.d1, 0)) d1,\n" +
      "       IF(d2 = 0, 0, ROUND(dd.d2, 0)) d2,\n" +
      "       IF(d3 = 0, 0, ROUND(dd.d3, 0)) d3,\n" +
      "       IF(d4 = 0, 0, ROUND(dd.d4, 0)) d4,\n" +
      "       IF(d5 = 0, 0, ROUND(dd.d5, 0)) d5,\n" +
      "       IF(dd.req IS NULL, '000', zona1) zona1\n" +
      "FROM (SELECT (case\n" +
      "                  when id is null and req is null and ksetir is null then 'Respublika üzrə'\n" +
      "                  when ksetir is not null then ad\n" +
      "                  when id is not null and req is null then irad\n" +
      "                  when id is not null and req is not null then rad end) adi,\n" +
      "             (case\n" +
      "                  when id is null and req is null and ksetir is null then '0'\n" +
      "                  when ksetir is not null then '3'\n" +
      "                  when id is not null and req is null then '1'\n" +
      "                  when id is not null and req is not null then '2' end) bosluq,\n" +
      "             gg.*\n" +
      "      FROM (SELECT *\n" +
      "            FROM (SELECT zona1,\n" +
      "                         hh.id,\n" +
      "                         hh.irad,\n" +
      "                         hh.rad,\n" +
      "                         hh.ad,\n" +
      "                         hh.req,\n" +
      "                         hh.seksiya,\n" +
      "                         hh.ksetir,\n" +
      "                         SUM(d1) d1,\n" +
      "                         SUM(d2) d2,\n" +
      "                         SUM(d3) d3,\n" +
      "                         SUM(d4) d4,\n" +
      "                         SUM(d5) d5\n" +
      "                  FROM (SELECT zona1,\n" +
      "                               hh.id,\n" +
      "                               hh.irad,\n" +
      "                               hh.rad,\n" +
      "                               hh.ad,\n" +
      "                               hh.req,\n" +
      "                               hh.seksiya,\n" +
      "                               hh.ksetir,\n" +
      "                               SUM(d1) d1,\n" +
      "                               SUM(d2) d2,\n" +
      "                               SUM(d3) d3,\n" +
      "                               SUM(d4) d4,\n" +
      "                               SUM(d5) d5\n" +
      "                        FROM (SELECT zona1,\n" +
      "                                     ir.ID     id,\n" +
      "                                     ir.REQION irad,\n" +
      "                                     r.B       rad,\n" +
      "                                     s.ad,\n" +
      "                                     k.req,\n" +
      "                                     k.seksiya,\n" +
      "                                     k.bolme,\n" +
      "                                     k.ksetir,\n" +
      "                                     k.d1,\n" +
      "                                     k.d2,\n" +
      "                                     k.d3,\n" +
      "                                     k.d4,\n" +
      "                                     k.d5\n" +
      "                              FROM (select d1,\n" +
      "                                           d2,\n" +
      "                                           b.d3,\n" +
      "                                           b.d4,\n" +
      "                                           b.d5,\n" +
      "                                           b.ksetir,\n" +
      "                                           b.seksiya,\n" +
      "                                           b.bolme,\n" +
      "                                           b.req\n" +
      "                                    from tr_2022 b\n" +
      "                                    WHERE b.bolme = 1) k\n" +
      "                                       LEFT JOIN setirler s ON k.ksetir = s.ksetir\n" +
      "                                       LEFT JOIN region r ON k.req = r.ZONA\n" +
      "                                       LEFT JOIN iregion ir ON r.ID_IQTISADI_RAYON = ir.ID) hh\n" +
      "                        GROUP BY ksetir, ID, req\n" +
      "                        WITH ROLLUP) hh\n" +
      "                  GROUP BY ID, req, ksetir\n" +
      "                  WITH ROLLUP) kk\n" +
      "            GROUP BY kk.id, req, ksetir) gg) dd\n" +
      "order by dd.id, dd.req, dd.ksetir;";


  String TABLE_FINANCIAL_CONDITION = "SELECT dd.adi,\n" +
      "       IFNULL(dd.id, '000')             id,\n" +
      "       IFNULL(dd.req, '000')            req,\n" +
      "       IFNULL(dd.seksiya, '0')          seksiya,\n" +
      "       IFNULL(dd.ksetir, '0')           ksetir,\n" +
      "       dd.bosluq,\n" +
      "       IF(d1 = 0, '0', ROUND(dd.d1, 0)) d1,\n" +
      "       IF(d2 = 0, '0', ROUND(dd.d2, 0)) d2,\n" +
      "       IF(d3 = 0, '0', ROUND(dd.d3, 0)) d3,\n" +
      "       IF(d4 = 0, '0', ROUND(dd.d4, 0)) d4,\n" +
      "       IF(d5 = 0, '0', ROUND(dd.d5, 0)) d5,\n" +
      "       IF(dd.req IS NULL, '000', zona1) zona1\n" +
      "FROM (SELECT (case\n" +
      "                  when id is null and req is null and ksetir is null then 'Respublika üzrə'\n" +
      "                  when ksetir is not null then ad\n" +
      "                  when id is not null and req is null then irad\n" +
      "                  when id is not null and req is not null then rad end) adi,\n" +
      "             (case\n" +
      "                  when id is null and req is null and ksetir is null then '0'\n" +
      "                  when ksetir is not null then '3'\n" +
      "                  when id is not null and req is null then '1'\n" +
      "                  when id is not null and req is not null then '2' end) bosluq,\n" +
      "             gg.*\n" +
      "      FROM (SELECT *\n" +
      "            FROM (SELECT zona1,\n" +
      "                         hh.id,\n" +
      "                         hh.irad,\n" +
      "                         hh.rad,\n" +
      "                         hh.ad,\n" +
      "                         hh.req,\n" +
      "                         hh.seksiya,\n" +
      "                         hh.ksetir,\n" +
      "                         SUM(d1) d1,\n" +
      "                         SUM(d2) d2,\n" +
      "                         SUM(d3) d3,\n" +
      "                         SUM(d4) d4,\n" +
      "                         SUM(d5) d5\n" +
      "                  FROM (SELECT zona1,\n" +
      "                               hh.id,\n" +
      "                               hh.irad,\n" +
      "                               hh.rad,\n" +
      "                               hh.ad,\n" +
      "                               hh.req,\n" +
      "                               hh.seksiya,\n" +
      "                               hh.ksetir,\n" +
      "                               SUM(d1) d1,\n" +
      "                               SUM(d2) d2,\n" +
      "                               SUM(d3) d3,\n" +
      "                               SUM(d4) d4,\n" +
      "                               SUM(d5) d5\n" +
      "                        FROM (SELECT zona1,\n" +
      "                                     ir.ID     id,\n" +
      "                                     ir.REQION irad,\n" +
      "                                     r.B       rad,\n" +
      "                                     s.ad,\n" +
      "                                     k.req,\n" +
      "                                     k.seksiya,\n" +
      "                                     k.bolme,\n" +
      "                                     k.ksetir,\n" +
      "                                     k.d1,\n" +
      "                                     k.d2,\n" +
      "                                     k.d3,\n" +
      "                                     k.d4,\n" +
      "                                     k.d5\n" +
      "                              FROM (select d1,\n" +
      "                                           d2,\n" +
      "                                           b.d3,\n" +
      "                                           b.d4,\n" +
      "                                           b.d5,\n" +
      "                                           b.ksetir,\n" +
      "                                           b.seksiya,\n" +
      "                                           b.bolme,\n" +
      "                                           b.req\n" +
      "                                    from tr_2022 b\n" +
      "                                    WHERE b.bolme = 3) k\n" +
      "                                       LEFT JOIN setirler s ON k.ksetir = s.ksetir\n" +
      "                                       LEFT JOIN region r ON k.req = r.ZONA\n" +
      "                                       LEFT JOIN iregion ir ON r.ID_IQTISADI_RAYON = ir.ID) hh\n" +
      "                        GROUP BY ksetir, ID, req\n" +
      "                        WITH ROLLUP) hh\n" +
      "                  GROUP BY ID, req, ksetir\n" +
      "                  WITH ROLLUP) kk\n" +
      "            GROUP BY kk.id, req, ksetir) gg) dd\n" +
      "order by dd.id, dd.req, dd.ksetir;";

  String TABLE_CONSUMPTION_STRUCTURE =
      "SELECT ff.adi, ff.ksetir, ff.d1, ff.d2 d3, ROUND(ff.d1 / tt.d1 * 100, 1) d2, ROUND(ff.d2 / tt.d2 * 100, 1) d4 \n" +
          "FROM (SELECT dd.adi,\n" +
          "             IFNULL(dd.id, '000')                id,\n" +
          "             IFNULL(dd.req, '000')               req,\n" +
          "             IFNULL(dd.seksiya, '0')             seksiya,\n" +
          "             IFNULL(dd.ksetir, '500')            ksetir,\n" +
          "             dd.bosluq,\n" +
          "             IF(dd.d1 = 0, '-', ROUND(dd.d1, 0)) d1,\n" +
          "             IF(dd.d2 = 0, '-', ROUND(dd.d2, 0)) d2,\n" +
          "             IF(dd.d3 = 0, '-', ROUND(dd.d3, 0)) d3,\n" +
          "             IF(dd.d4 = 0, '-', ROUND(dd.d4, 0)) d4,\n" +
          "             IF(dd.d5 = 0, '-', ROUND(dd.d5, 0)) d5\n" +
          "              ,\n" +
          "             IF(dd.req IS NULL, '000', dd.zona1) zona1\n" +
          "      FROM (SELECT (case\n" +
          "                        when id is null and req is null and ksetir is null then 'Respublika üzrə cəm'\n" +
          "                        when ksetir is not null then ad\n" +
          "                        when id is not null and req is null then CONCAT(irad, ' cəm')\n" +
          "                        when id is not null and req is not null then CONCAT(rad, ' cəm') end) adi,\n" +
          "                   (case\n" +
          "                        when id is null and req is null and ksetir is null then '0'\n" +
          "                        when ksetir is not null then '3'\n" +
          "                        when id is not null and req is null then '1'\n" +
          "                        when id is not null and req is not null then '2' end)                 bosluq,\n" +
          "                   gg.*\n" +
          "            FROM (SELECT *\n" +
          "                  FROM (SELECT zona1,\n" +
          "                               hh.id,\n" +
          "                               hh.irad,\n" +
          "                               hh.rad,\n" +
          "                               hh.ad,\n" +
          "                               hh.req,\n" +
          "                               hh.seksiya,\n" +
          "                               hh.ksetir,\n" +
          "                               SUM(d1) d1,\n" +
          "                               SUM(d2) d2,\n" +
          "                               SUM(d3) d3,\n" +
          "                               SUM(d4) d4,\n" +
          "                               SUM(d5) d5\n" +
          "                        FROM (SELECT zona1,\n" +
          "                                     hh.id,\n" +
          "                                     hh.irad,\n" +
          "                                     hh.rad,\n" +
          "                                     hh.ad,\n" +
          "                                     hh.req,\n" +
          "                                     hh.seksiya,\n" +
          "                                     hh.ksetir,\n" +
          "                                     SUM(d1) d1,\n" +
          "                                     SUM(d2) d2,\n" +
          "                                     SUM(d3) d3,\n" +
          "                                     SUM(d4) d4,\n" +
          "                                     SUM(d5) d5\n" +
          "                              FROM (SELECT zona1,\n" +
          "                                           ir.ID     id,\n" +
          "                                           ir.REQION irad,\n" +
          "                                           r.B       rad,\n" +
          "                                           if(k.ksetir = '1',\n" +
          "                                              'Xammal və material xərcləri,  (sət.126 - sət.110 – sət.219süt.5 + sət.219süt.1)',\n" +
          "                                              s.ad)  ad,\n" +
          "                                           k.req,\n" +
          "                                           k.seksiya,\n" +
          "                                           k.bolme,\n" +
          "                                           k.ksetir,\n" +
          "                                           k.d1,\n" +
          "                                           k.d2,\n" +
          "                                           k.d3,\n" +
          "                                           k.d4,\n" +
          "                                           k.d5\n" +
          "                                    FROM (select d1,\n" +
          "                                                 d2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (131, 134, 135, 136, 138, 139, 143, 144, 145, 148)\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 * 60 / 1000,\n" +
          "                                                 d2 * 60 / 1000,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (137)\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 / 10,\n" +
          "                                                 d2 / 10,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 '140' ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (165)\n" +
          "\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 / 2,\n" +
          "                                                 d2 / 2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (154)\n" +
          "\n" +
          "                                          UNION ALL\n" +
          "                                          select SUM(d1) d1,\n" +
          "                                                 SUM(d2) d2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 '1'     ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from (select d1,\n" +
          "                                                       d2,\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (126)\n" +
          "                                                UNION ALL\n" +
          "                                                select -d1,\n" +
          "                                                       -d2,\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (110)\n" +
          "                                                UNION ALL\n" +
          "                                                select -(d1 + d5),\n" +
          "                                                       -(d1 + d5),\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (219)) b\n" +
          "                                          GROUP BY b.req) k\n" +
          "                                             LEFT JOIN setirler s ON k.ksetir = s.ksetir\n" +
          "                                             LEFT JOIN region r ON k.req = r.ZONA\n" +
          "                                             LEFT JOIN iregion ir ON r.ID_IQTISADI_RAYON = ir.ID) hh\n" +
          "                              GROUP BY ksetir, ID, req\n" +
          "                              WITH ROLLUP) hh\n" +
          "                        GROUP BY ID, req, ksetir\n" +
          "                        WITH ROLLUP) kk\n" +
          "                  GROUP BY kk.id, req, ksetir) gg) dd) ff\n" +
          "         LEFT JOIN\n" +
          "     (SELECT dd.adi,\n" +
          "             IFNULL(dd.id, '000')                id,\n" +
          "             IFNULL(dd.req, '000')               req,\n" +
          "             IFNULL(dd.seksiya, '0')             seksiya,\n" +
          "             IFNULL(dd.ksetir, '500')            ksetir,\n" +
          "             dd.bosluq,\n" +
          "             IF(dd.d1 = 0, '-', ROUND(dd.d1, 0)) d1,\n" +
          "             IF(dd.d2 = 0, '-', ROUND(dd.d2, 0)) d2,\n" +
          "             IF(dd.d3 = 0, '-', ROUND(dd.d3, 0)) d3,\n" +
          "             IF(dd.d4 = 0, '-', ROUND(dd.d4, 0)) d4,\n" +
          "             IF(dd.d5 = 0, '-', ROUND(dd.d5, 0)) d5\n" +
          "              ,\n" +
          "             IF(dd.req IS NULL, '000', dd.zona1) zona1\n" +
          "      FROM (SELECT (case\n" +
          "                        when id is null and req is null and ksetir is null then 'Respublika üzrə'\n" +
          "                        when ksetir is not null then ad\n" +
          "                        when id is not null and req is null then irad\n" +
          "                        when id is not null and req is not null then rad end) adi,\n" +
          "                   (case\n" +
          "                        when id is null and req is null and ksetir is null then '0'\n" +
          "                        when ksetir is not null then '3'\n" +
          "                        when id is not null and req is null then '1'\n" +
          "                        when id is not null and req is not null then '2' end) bosluq,\n" +
          "                   gg.*\n" +
          "            FROM (SELECT *\n" +
          "                  FROM (SELECT zona1,\n" +
          "                               hh.id,\n" +
          "                               hh.irad,\n" +
          "                               hh.rad,\n" +
          "                               hh.ad,\n" +
          "                               hh.req,\n" +
          "                               hh.seksiya,\n" +
          "                               hh.ksetir,\n" +
          "                               SUM(d1) d1,\n" +
          "                               SUM(d2) d2,\n" +
          "                               SUM(d3) d3,\n" +
          "                               SUM(d4) d4,\n" +
          "                               SUM(d5) d5\n" +
          "                        FROM (SELECT zona1,\n" +
          "                                     hh.id,\n" +
          "                                     hh.irad,\n" +
          "                                     hh.rad,\n" +
          "                                     hh.ad,\n" +
          "                                     hh.req,\n" +
          "                                     hh.seksiya,\n" +
          "                                     hh.ksetir,\n" +
          "                                     SUM(d1) d1,\n" +
          "                                     SUM(d2) d2,\n" +
          "                                     SUM(d3) d3,\n" +
          "                                     SUM(d4) d4,\n" +
          "                                     SUM(d5) d5\n" +
          "                              FROM (SELECT zona1,\n" +
          "                                           ir.ID     id,\n" +
          "                                           ir.REQION irad,\n" +
          "                                           r.B       rad,\n" +
          "                                           s.ad,\n" +
          "                                           k.req,\n" +
          "                                           k.seksiya,\n" +
          "                                           k.bolme,\n" +
          "                                           k.ksetir,\n" +
          "                                           k.d1,\n" +
          "                                           k.d2,\n" +
          "                                           k.d3,\n" +
          "                                           k.d4,\n" +
          "                                           k.d5\n" +
          "                                    FROM (select d1,\n" +
          "                                                 d2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (131, 134, 135, 136, 138, 139, 143, 144, 145, 148)\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 * 60 / 1000,\n" +
          "                                                 d2 * 60 / 1000,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (137)\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 / 10,\n" +
          "                                                 d2 / 10,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 '140' ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (165)\n" +
          "\n" +
          "                                          UNION ALL\n" +
          "                                          select d1 / 2,\n" +
          "                                                 d2 / 2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from tr_2022 b\n" +
          "                                          WHERE b.ksetir IN (154)\n" +
          "\n" +
          "                                          UNION ALL\n" +
          "                                          select SUM(d1) d1,\n" +
          "                                                 SUM(d2) d2,\n" +
          "                                                 b.d3,\n" +
          "                                                 b.d4,\n" +
          "                                                 b.d5,\n" +
          "                                                 b.ksetir,\n" +
          "                                                 b.seksiya,\n" +
          "                                                 b.bolme,\n" +
          "                                                 b.req\n" +
          "                                          from (select d1,\n" +
          "                                                       d2,\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (126)\n" +
          "                                                UNION ALL\n" +
          "                                                select -d1,\n" +
          "                                                       -d2,\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (110)\n" +
          "                                                UNION ALL\n" +
          "                                                select -(d1 + d5),\n" +
          "                                                       -(d1 + d5),\n" +
          "                                                       b.d3,\n" +
          "                                                       b.d4,\n" +
          "                                                       b.d5,\n" +
          "                                                       b.ksetir,\n" +
          "                                                       b.seksiya,\n" +
          "                                                       b.bolme,\n" +
          "                                                       b.req\n" +
          "                                                from tr_2022 b\n" +
          "                                                WHERE b.ksetir IN (219)) b\n" +
          "                                          GROUP BY b.req) k\n" +
          "                                             LEFT JOIN setirler s ON k.ksetir = s.ksetir\n" +
          "                                             LEFT JOIN region r ON k.req = r.ZONA\n" +
          "                                             LEFT JOIN iregion ir ON r.ID_IQTISADI_RAYON = ir.ID) hh\n" +
          "                              GROUP BY ksetir, ID, req\n" +
          "                              WITH ROLLUP) hh\n" +
          "                        GROUP BY ID, req, ksetir\n" +
          "                        WITH ROLLUP) kk\n" +
          "                  GROUP BY kk.id, req, ksetir) gg) dd\n" +
          "      WHERE dd.bosluq != 3) tt ON ff.id = tt.id AND ff.req = tt.req\n" +
          "order by ff.id, ff.req, ff.ksetir;";

}
