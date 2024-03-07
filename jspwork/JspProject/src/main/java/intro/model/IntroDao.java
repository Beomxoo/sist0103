package intro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysql.db.DbConnect;
import team.model.TeamDto;


public class IntroDao {
	DbConnect db=new DbConnect();
	   
	   //insert
	   public void insertIntro(IntroDto dto)
	   {
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      
	      //4개의 값을 인서트
	      String sql="insert into intro(name,age,birthday,hometown,hobby,memo) values(?,?,?,?,?,?)";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, dto.getName());
	         pstmt.setString(2, dto.getAge());
	         pstmt.setString(3, dto.getBirthday());
	         pstmt.setString(4, dto.getHometown());
	         pstmt.setString(5, dto.getHobby());
	         pstmt.setString(6, dto.getMemo());
	         
	         
	         //실행
	         pstmt.execute();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         db.dbClose(pstmt, conn);
	      }
	   }
	   
	   //전체조회
	   public ArrayList<IntroDto> getAllDatas()
	   {
		  ArrayList<IntroDto> list = new ArrayList<IntroDto>();
		  
		  Connection conn=db.getConnection();
		  PreparedStatement pstmt=null;
		  ResultSet rs=null;
		  
		  String sql="select * from intro order by num";
		  
		  try {
			  pstmt= conn.prepareStatement(sql);
			  rs=pstmt.executeQuery();
			  
			  while(rs.next()) {
				  IntroDto dto=new IntroDto();
				  dto.setNum(rs.getString("num"));
				  dto.setName(rs.getString("name"));
				  dto.setBirthday(rs.getString("birthday"));
				  dto.setHobby(rs.getString("hobby"));
				  dto.setHometown(rs.getString("hometown"));
				  dto.setAge(rs.getString("age"));
				  dto.setMemo(rs.getString("memo"));
				  
				  //list에 추가
				  list.add(dto);
				  
			  }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		  return list;
	   }
	   
	   //detailView..num에 해당하는 하나의 dto반환
	   public IntroDto getOneData(String num) {
		   IntroDto dto=new IntroDto();
		   Connection conn=db.getConnection();
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   
		   String sql="select * from intro where num=?";
		   
		   try {
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, num);
			   rs=pstmt.executeQuery();
			   
			   if(rs.next()) {
				      dto.setNum(rs.getString("num"));
					  dto.setName(rs.getString("name"));
					  dto.setBirthday(rs.getString("birthday"));
					  dto.setHobby(rs.getString("hobby"));
					  dto.setHometown(rs.getString("hometown"));
					  dto.setAge(rs.getString("age"));
					  dto.setMemo(rs.getString("memo"));
			   }
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		   return dto;
	   }
	
	   //삭제(시퀀스에 해당 하는 db삭제)
	   public void deleteIntro(String num) {
		   Connection conn=db.getConnection();
		   PreparedStatement pstmt=null;
		   
		   String sql="delete from intro where num=?";
		   
		   try {
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, num);
			   pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		   
		   
	   }
	   
}
