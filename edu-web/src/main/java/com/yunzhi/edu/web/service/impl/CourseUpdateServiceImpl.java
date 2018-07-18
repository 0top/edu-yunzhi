package com.yunzhi.edu.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yunzhi.edu.dao.CourseChapterExamMapper;
import com.yunzhi.edu.dao.CourseChapterMapper;
import com.yunzhi.edu.dao.CourseCommentMapper;
import com.yunzhi.edu.dao.CourseFileMapper;
import com.yunzhi.edu.dao.CourseMapper;
import com.yunzhi.edu.dao.CourseQAMapper;
import com.yunzhi.edu.dao.CourseWareMapper;
import com.yunzhi.edu.dao.UserCourseMapper;
import com.yunzhi.edu.domain.UserCourseChapterDetail;
import com.yunzhi.edu.domain.UserCourseDetail;
import com.yunzhi.edu.domain.UserCourseExamDetail;
import com.yunzhi.edu.domain.UserCourseWareDetail;
import com.yunzhi.edu.entity.CourseChapter;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.CourseQA;
import com.yunzhi.edu.entity.CourseWare;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.web.service.CourseUpdateService;

@Service
public class CourseUpdateServiceImpl implements CourseUpdateService{
	
	@Autowired
	private CourseChapterMapper courseChapterDao;
	
	@Autowired
	private CourseWareMapper coursewareDao;
	
	@Autowired
	private CourseChapterExamMapper examDao;
	
	@Autowired
	private CourseQAMapper courseQADao;
	
	@Autowired
	private UserCourseMapper userCourseDao;
	
	Gson gson = new Gson();
	
	/***************************************************
	 * 
	 * 辅助更新usercourse
	 * 
	 ****************************************************/
	@Override
	public UserCourse updateUserCourse(String userId, String courseId){
		
		UserCourse usercourse = new UserCourse(); 
		usercourse.setCourseId(courseId);
		usercourse.setUserId(userId);
		usercourse = userCourseDao.getUserCourse(usercourse);
		
		if(null == usercourse){
			return null;
		}
		
		UserCourseDetail usercourseDetail = gson.fromJson(usercourse.getDetail(),UserCourseDetail.class);
		
		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		chapters = courseChapterDao.listChapterSelective(usercourse.getCourseId());
		CourseWare courseware = new CourseWare();
		
		List<UserCourseChapterDetail> usercourseChapterDetail = new ArrayList<UserCourseChapterDetail>();
		
		int temp = 0;
		for(CourseChapter chapter: chapters){
			temp = 0;
			for(int i=0;i<usercourseDetail.getChapters().size();i++){
				if(usercourseDetail.getChapters().get(i).equals(chapter.getChapterId())){
					temp = i;
					break;
				}
			}
			
			if(temp == 0){
				UserCourseChapterDetail uc = new UserCourseChapterDetail();
				uc.setId(chapter.getId());
				
				List<UserCourseWareDetail> uwd = new ArrayList<UserCourseWareDetail>();
				List<CourseWare> coursewares = new ArrayList<CourseWare>();
				courseware.setCourseId(usercourse.getCourseId());
				courseware.setChapterId(chapter.getChapterId());
				coursewares = coursewareDao.listCourseWareList(courseware);
				for(CourseWare ware: coursewares){
					UserCourseWareDetail cw = new UserCourseWareDetail();
					cw.setId(ware.getId());
					cw.setSee(false);
					uwd.add(cw);
					int k = usercourseDetail.getCoursewareSum();
					usercourseDetail.setChapterSum(k+1);
				}
				uc.setCoursewares(uwd);
				
				List<UserCourseExamDetail> uced = new ArrayList<UserCourseExamDetail>();
				List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
				CourseChapterExam  exam = new CourseChapterExam();
				exam.setChapterId(chapter.getChapterId());
				exam.setCourseId(usercourse.getCourseId());
				exams = examDao.listCourseChapterExamList(exam);
				for(CourseChapterExam em: exams){
					UserCourseExamDetail ed = new UserCourseExamDetail();
					ed.setDone(false);
					ed.setId(em.getId());
					uced.add(ed);
					int k = usercourseDetail.getExamSum();
					usercourseDetail.setExamSum(k+1);
				}
				uc.setExams(uced);
				usercourseChapterDetail.add(uc);
				continue;
			}
			
			//更新章节课件
			List<CourseWare> coursewares = new ArrayList<CourseWare>();
			courseware.setCourseId(usercourse.getCourseId());
			courseware.setChapterId(chapter.getChapterId());
			coursewares = coursewareDao.listCourseWareList(courseware);
			if(coursewares.size() != usercourseDetail.getChapters().get(temp).getCoursewares().size()){
				int flag = 0;
				for(CourseWare ware: coursewares){
					flag = 0;
					for(UserCourseWareDetail cw :usercourseDetail.getChapters().get(temp).getCoursewares()){
						if(ware.getId()==cw.getId()){
							flag = 1;
							break;
						}
					}
					if(flag == 0){
						UserCourseWareDetail cw = new UserCourseWareDetail();
						cw.setId(ware.getId());
						cw.setSee(false);
						usercourseDetail.getChapters().get(temp).getCoursewares().add(cw);
						int k = usercourseDetail.getCoursewareSum();
						usercourseDetail.setChapterSum(k+1);
					}
				}
			}
			
			//更新章节考试
			List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
			CourseChapterExam  exam = new CourseChapterExam();
			exam.setChapterId(chapter.getChapterId());
			exam.setCourseId(usercourse.getCourseId());
			exams = examDao.listCourseChapterExamList(exam);
			if(exams.size() != usercourseDetail.getChapters().get(temp).getExams().size()){
				int flag = 0;
				for(CourseChapterExam ex: exams){
					flag = 0;
					for(UserCourseExamDetail ce :usercourseDetail.getChapters().get(temp).getExams()){
						if(ce.getId()== ex.getId()){
							flag = 1;
							break;
						}
					}
					if(flag == 0){
						UserCourseExamDetail ed = new UserCourseExamDetail();
						ed.setDone(false);
						ed.setId(ex.getId());
						usercourseDetail.getChapters().get(temp).getExams().add(ed);
						int k = usercourseDetail.getExamSum();
						usercourseDetail.setExamSum(k+1);
					}
				}
			}
			
		}
			
		if(usercourseChapterDetail.size()>0){
			for(UserCourseChapterDetail uccd: usercourseChapterDetail)
				usercourseDetail.getChapters().add(uccd);
		}
		usercourse.setDetail(gson.toJson(usercourseDetail));
		return usercourse;
		
	}
	@Override
	public UserCourse createUserCourse(UserCourse userCourse){
		UserCourseDetail userCourseDetail = new UserCourseDetail();
		userCourseDetail.setCoursewareSum(0);
		userCourseDetail.setExamCount(0);
		
		int coursewareSum = 0;
		int examSum = 0;
		
		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		System.out.println(userCourse.getCourseId());
		
		try{
			if(null == courseChapterDao){
				System.out.println("dao is null");
			}
		chapters = courseChapterDao.listChapterSelective(userCourse.getCourseId());
		}catch(Exception e){
			System.out.println(userCourse.getCourseId()+"---------");
			e.printStackTrace();
		}
		if(null == chapters){
			System.out.println(userCourse.getCourseId()+"课内无课件");
		}
		
		CourseWare courseware = new CourseWare();
		
		List<UserCourseChapterDetail> chapterDetail = new ArrayList<UserCourseChapterDetail>();
		
		for(CourseChapter chapter: chapters){
			
			UserCourseChapterDetail chapterdetail = new UserCourseChapterDetail();
			
			List<CourseWare> coursewares = new ArrayList<CourseWare>();
			courseware.setCourseId(userCourse.getCourseId());
			courseware.setChapterId(chapter.getChapterId());
			System.out.println(courseware.toString());
			coursewares = coursewareDao.listCourseWareList(courseware);
			
			
			List<UserCourseWareDetail> coursewareDetail = new ArrayList<UserCourseWareDetail>();
			for(CourseWare coursew : coursewares){
				UserCourseWareDetail usercourseware = new UserCourseWareDetail();
				usercourseware.setId(coursew.getId());
				coursewareDetail.add(usercourseware);
				coursewareSum++;
			}
			chapterdetail.setCoursewares(coursewareDetail);
			
			List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
			CourseChapterExam  exam = new CourseChapterExam();
			exam.setChapterId(chapter.getChapterId());
			exam.setCourseId(userCourse.getCourseId());
			exams = examDao.listCourseChapterExamList(exam);
			
			List<UserCourseExamDetail> examDetail = new ArrayList<UserCourseExamDetail>();
			for(CourseChapterExam chapterExam: exams){
				UserCourseExamDetail examdetail = new UserCourseExamDetail();
				examdetail.setId(chapterExam.getId());
//				List<ExamAnswer> ans = gson.fromJson(chapterExam.getAnswer(),ExamAnswer.class);
//				if(ans != null){
//					examdetail.setAns(ans);
//				}
				examdetail.setDone(false);
				//设置总分
//				examdetail.setScore(score);
				examDetail.add(examdetail);
				examSum ++;
			}
			chapterdetail.setExams(examDetail);
			chapterDetail.add(chapterdetail);
		}
		
		List<CourseQA> qas = new ArrayList<CourseQA>();
		CourseQA qa = new CourseQA();
		qa.setCourseId(userCourse.getCourseId());
		qa.setUserId(userCourse.getUserId());
		qas = courseQADao.listCourseQA(qa);
		
		int qaSum = 0;
		int qaHasProcess = 0;
		for(CourseQA q : qas){
			if(q.getIsProcess()==true)
				qaHasProcess++;
			qaSum++;
		}
		userCourseDetail.setQaSum(qaSum);
		userCourseDetail.setQaHasProcess(qaHasProcess);
		
		userCourseDetail.setChapters(chapterDetail);
		userCourseDetail.setCoursewareSum(coursewareSum);
		userCourseDetail.setExamSum(examSum);
		userCourseDetail.setUserId(userCourse.getUserId());
		userCourseDetail.setCourseId(userCourse.getCourseId());
		userCourseDetail.setLastmodifiedTime(new Date());
		
		userCourse.setDetail(gson.toJson(userCourseDetail));
		
		
		userCourseDao.insertSelective(userCourse);
		return userCourse;
	}

}
