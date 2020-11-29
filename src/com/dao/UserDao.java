package com.dao;

import com.model.Coordinate;
import com.model.User;
import com.model.UserData;
import com.model.heatMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<UserData> QueryLocInfo(){
        String sql = "Select * from userdata";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rst = pstmt.executeQuery();
            ArrayList<UserData> userdata = new ArrayList<UserData>();
            while (rst.next()){
                UserData ud = new UserData();
                ud.setImsi(rst.getString("imsi"));
                ud.setTimestamp(rst.getString("timestamp"));
                ud.setTimestamp2(rst.getString("timestamp1"));
                ud.setLng(rst.getDouble("longitude"));
                ud.setLat(rst.getDouble("latitude"));
                userdata.add(ud);
            }
            return userdata;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

}
