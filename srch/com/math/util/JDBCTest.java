package com.math.util;
 
import java.sql.Connection;

 
public class JDBCTest {
    public static void main(String[] args) {
        //�����������ݿ��Ƿ�ɹ�
        Connection conn = DBHelper.getConnection();
        if(conn != null){
            System.out.println("���ԣ����ݿ����ӳɹ���");
        }else{
            System.out.println("���ԣ����ݿ�����ʧ�ܣ�");
        }
    }
}