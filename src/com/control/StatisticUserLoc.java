package com.control;

import com.alibaba.fastjson.JSON;
import com.dao.UserDao;
import com.model.UserData;
import com.model.heatMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet({"/StatisticUserLoc"})
public class StatisticUserLoc extends HttpServlet    {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<UserData> userData = dao.QueryLocInfo();
        ArrayList<heatMap> heatMaps = new ArrayList<heatMap>();
        String time="2018-10-03 10:00:00";

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(time);

            Long time2 = date.getTime();
            System.out.println("time2"+time2);
            System.out.println(Long.valueOf(userData.get(0).getTimestamp()));
            System.out.println(Long.valueOf(userData.get(0).getTimestamp2()));
            for(int i = 0;i<userData.size();i++){
                Long t1 = Long.valueOf(userData.get(i).getTimestamp())-600*1000;
//                System.out.println("t1"+t1);
                Long t2 = Long.valueOf(userData.get(i).getTimestamp2())+600*1000;
//                System.out.println("t2"+t2);
                if(time2> t1 && time2<t2 ){
                    heatMap heatMap = new heatMap();
                    heatMap.setCnt(1);
                    heatMap.setLng(userData.get(i).getLng());
                    heatMap.setLat(userData.get(i).getLat());
                    heatMaps.add(heatMap);
                }
            }
            String json = JSON.toJSONString(heatMaps);
            System.out.println(json);
            File file = new File("D://heatmapjs.json");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(json);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        System.out.println(json);
//        out.println(JSON.toJSONString(heatMaps));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
