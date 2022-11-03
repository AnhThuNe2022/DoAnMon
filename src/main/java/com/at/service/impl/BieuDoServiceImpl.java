/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.repository.BieuDoRepository;
import com.at.service.BieuDoService;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class BieuDoServiceImpl implements BieuDoService {

    @Autowired
    BieuDoRepository bieuDoRepository;

    @Override
    public List<Object[]> matDoChuyenXe() {
        return this.bieuDoRepository.matDoChuyenXe();
    }

    @Override
    public Map<Integer, List<BigDecimal>> thongKeDoanhThu(int tk, int y) {

        try {
            List<Object[]> listO = this.bieuDoRepository.doanhThu(tk, y);

            Map<Integer, List<BigDecimal>> map = new HashMap<>();

            Map<Integer, List<BigDecimal>> kq = new HashMap<>();

            for (Object[] o : listO) {
                System.out.println("Tháng: " + o[0] + "Tiền :" + o[1] + " Hủy:" + o[2]);
                List<BigDecimal> money = new ArrayList<>();
                money.add(BigDecimal.valueOf(Double.parseDouble(o[1].toString())));
                if (o[2] == null) {
                    money.add(BigDecimal.valueOf(0));
                } else {
                    money.add(BigDecimal.valueOf(Double.parseDouble(o[2].toString())));
                }
                map.put(Integer.parseInt(o[0].toString()), money);
            }
            if (tk == 0) {
                for (int i = 1; i <= 12; i++) {
                    if (map.containsKey(i)) {
                        kq.put(i, map.get(i));
                    } else {
                        List<BigDecimal> listM = new ArrayList<>();
                        listM.add(BigDecimal.valueOf(0));
                        listM.add(BigDecimal.valueOf(0));
                        kq.put(i, listM);
                    }

                }

            } else if (tk == 2) {

                return map;
            } else if (tk == 1) {

                List<BigDecimal> listM1 = new ArrayList<>();
                listM1.add(BigDecimal.valueOf(0));
                listM1.add(BigDecimal.valueOf(0));
                kq.put(1, listM1);
                kq.put(2, listM1);
                kq.put(3, listM1);
                kq.put(4, listM1);

                for (int i = 1; i <= 12; i++) {

                    if (i <= 3) {

                        if (map.containsKey(i)) {
                            List<BigDecimal> listQuarter1 = new ArrayList<>();
                            listQuarter1.add(kq.get(1).get(0).add(map.get(i).get(0)));
                            listQuarter1.add(kq.get(1).get(1).add(map.get(i).get(1)));
                            kq.put(1, listQuarter1);
                        }
                    } else if (i <= 6) {
                        if (map.containsKey(i)) {
                            List<BigDecimal> listQuarter2 = new ArrayList<>();
                            listQuarter2.add(kq.get(2).get(0).add(map.get(i).get(0)));
                            listQuarter2.add(kq.get(2).get(1).add(map.get(i).get(1)));
                            kq.put(2, listQuarter2);
                        }
                    } else if (i <= 9) {
                        if (map.containsKey(i)) {
                            List<BigDecimal> listQuarter3 = new ArrayList<>();
                            listQuarter3.add(kq.get(3).get(0).add(map.get(i).get(0)));
                            listQuarter3.add(kq.get(3).get(1).add(map.get(i).get(1)));
                            kq.put(3, listQuarter3);
                        }
                    } else {
                        if (map.containsKey(i)) {
                            List<BigDecimal> listQuarter4 = new ArrayList<>();
                            listQuarter4.add(kq.get(4).get(0).add(map.get(i).get(0)));
                            listQuarter4.add(kq.get(4).get(1).add(map.get(i).get(1)));
                            kq.put(4, listQuarter4);
                        }
                    }

                }
            }

            return kq;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
