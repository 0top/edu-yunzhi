package com.yunzhi.edu.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yunzhi.edu.dao.CourseMapper;
import com.yunzhi.edu.dao.CourseNoticeMapper;
import com.yunzhi.edu.dao.CourseTaskMapper;
import com.yunzhi.edu.dao.SchoolTeacherMapper;
import com.yunzhi.edu.domain.TaskActor;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseNotice;
import com.yunzhi.edu.entity.CourseTask;
import com.yunzhi.edu.entity.SchoolTeacher;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.web.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private CourseMapper courseDao;
	
	@Resource
	private CourseTaskMapper taskDao;
	
	@Resource
	private CourseNoticeMapper courseNoticeDao;
	
	@Resource
	private SchoolTeacherMapper teacherDao;
	
	Gson gson = new Gson();
	
	@Override
	public List<Course> listCourse(String teacherId) {
		
		if(null == teacherId)
			return null;
		
		Course course = new Course();
		course.setTeacherId(teacherId);
		
		return courseDao.listCourseSelective(course);
	}

	@Override
	public SchoolTeacher findTeacherByStaffNum(String staffNum) {
		
		SchoolTeacher teacher = new SchoolTeacher();
		teacher.setStaffNum(staffNum);
		return teacherDao.selectTeacherSelective(teacher);
	}
	
	
	public SchoolTeacher selectByStaffNumAuthentication(String staffNum, String orgCode){
		
		if(staffNum == null || staffNum.equals("")||orgCode == null || orgCode.equals("")){
			return null;
		}
		return teacherDao.selectByStaffNumAuthentication(staffNum, orgCode);
	}
	
	public int insertTask(CourseTask task){
		
		if(null ==  task)
			return 0;
		
		if(null != task.getId()){
			return taskDao.updateByPrimaryKeySelective(task);
		}
		
		task.setCreateTime(new Date());
		task.setTaskId(RandomId.createId());
		return taskDao.insertSelective(task);
		
	}

	public List<CourseTask> listCourseTask(String teacherId){
		
		CourseTask tempTask = new CourseTask();
		tempTask.setSendFromId(teacherId);
		List<CourseTask> tasklist = taskDao.listCourseTask(tempTask);
		
		for(CourseTask task: tasklist){
			task.setTotleActor(courseDao.selectCourseCourseUser(task.getCourseId()));
			if(null != task.getActor()){
				List<TaskActor> actorlist = gson.fromJson(task.getActor(), new TypeToken<List<TaskActor>>() {}.getType());
				if(null != actorlist){
					task.setHasFinish(actorlist.size());
				}
			}
		}
		
		return tasklist; 
		
	}
	
	public int deleteTask(Long id){
		return taskDao.deleteByPrimaryKey(id);
	}
	
	public int insertCourseNotice(CourseNotice notice){
		if(null !=  notice){
			return courseNoticeDao.insertSelective(notice);
		}
		return 0;
	}
	
	public int deleteCourseNoticeById(Long id){
		return courseNoticeDao.deleteByPrimaryKey(id);
	}
	
	public List<CourseNotice> listCourseNotice(String courseId){
		
		return courseNoticeDao.listCourseNotice(courseId);
	}
	
}
