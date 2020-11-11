package com.dao;

import com.model.Coordinate;
import com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends BaseDao{
    public User QueryUserByImsi(String imsi){
        String sqlstr = "Select starttime,longitude,latitude from userdata Where imsi = ? order by starttime";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlstr)) {
            pstmt.setString(1,imsi);
            ResultSet rst = pstmt.executeQuery();
            ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
            while (rst.next()){
                Coordinate tmp = new Coordinate();
                tmp.setLatitude(rst.getFloat("latitude"));
                tmp.setLongitude(rst.getFloat("longitude"));
                tmp.setTime(rst.getString("starttime"));
//                System.out.println(tmp.getTime());
                coordinates.add(tmp);
            }
            User user = new User(coordinates,imsi);
            return user;
        } catch(SQLException e1){
            e1.printStackTrace();
            return null;
        }
    }
}
