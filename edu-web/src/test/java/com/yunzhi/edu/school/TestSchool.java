package com.yunzhi.edu.school;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yunzhi.edu.dao.SchoolMapper;
import com.yunzhi.edu.entity.School;
import com.yunzhi.edu.entity.SchoolStudent;
import com.yunzhi.edu.entity.SchoolWithBLOBs;
import com.yunzhi.edu.web.service.SchoolManagerStaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestSchool {
	
	@Autowired
	private SchoolManagerStaffService schoolService;
	
	public TestSchool(){}
	
//	@Test
//	public void TestSelect(){
//		School schools = schoolDao.selectByPrimaryKey((long) 1);
//		System.out.println(schools.toString());
//	}
	
//	@Test
//	public void TestSelectSeletive(){
//		List<School> s1 = schoolDao.listAllSchoolBase();
//		List<SchoolWithBLOBs> s2 = schoolDao.listAllSchool();
//		
//		System.out.println("----------school-------------");
//		for(School school: s1){
//			System.out.println(school.toString());
//		}
//		System.out.println();
//		System.out.println("----------school- with blobs------------");
//		for(School school: s2){
//			System.out.println(school.toString());
//		}
//	}
	
//	@Test
//	public void TestUpdateAuthorizate(){
//		schoolDao.updateAuthorizate("10003");
//		School school = schoolDao.selectByPrimaryKey((long) 2);
//		System.out.println(school.toString());
//	}

}
