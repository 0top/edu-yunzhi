package com.yunzhi.edu.web.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yunzhi.edu.dao.CourseChapterExamMapper;
import com.yunzhi.edu.dao.CourseChapterMapper;
import com.yunzhi.edu.dao.CourseCommentMapper;
import com.yunzhi.edu.dao.CourseFileMapper;
import com.yunzhi.edu.dao.CourseMapper;
import com.yunzhi.edu.dao.CourseQAMapper;
import com.yunzhi.edu.dao.CourseWareMapper;
import com.yunzhi.edu.dao.UserCourseMapper;
import com.yunzhi.edu.domain.ExamAnswer;
import com.yunzhi.edu.domain.UserCourseChapterDetail;
import com.yunzhi.edu.domain.UserCourseDetail;
import com.yunzhi.edu.domain.UserCourseExamDetail;
import com.yunzhi.edu.domain.UserCourseWareDetail;
import com.yunzhi.edu.entity.Course;
import com.yunzhi.edu.entity.CourseChapter;
import com.yunzhi.edu.entity.CourseWare;
import com.yunzhi.edu.entity.UserCourse;
import com.yunzhi.edu.util.RandomId;
import com.yunzhi.edu.entity.CourseChapterExam;
import com.yunzhi.edu.entity.CourseComment;
import com.yunzhi.edu.entity.CourseFile;
import com.yunzhi.edu.entity.CourseQA;
import com.yunzhi.edu.web.exception.UnknowSystemException;
import com.yunzhi.edu.web.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseDao;

	@Autowired
	private CourseChapterMapper courseChapterDao;

	@Autowired
	private CourseWareMapper coursewareDao;

	@Autowired
	private CourseChapterExamMapper examDao;

	@Autowired
	private CourseQAMapper courseQADao;

	@Autowired
	private CourseFileMapper courseFileDao;

	@Autowired
	private UserCourseMapper userCourseDao;

	@Autowired
	private CourseCommentMapper commentDao;

	Gson gson = new Gson();

	/**********************
	 * 
	 * 课程操作
	 * 
	 *********************/

	@Override
	// 添加课程-同时添加默认章节
	public int insertCourse(Course course) {

		if (course == null) {
			return 0;
		}

		courseDao.insertSelective(course);

		CourseChapter chapter = new CourseChapter();
		chapter.setChapterId(System.currentTimeMillis() + "");
		chapter.setCourseId(course.getCourseId());
		chapter.setChapterName("期末章节");
		courseChapterDao.insertSelective(chapter);

		return 1;
	}

	// 批量添加课程
	public int insertCourseList(List<Course> courseList) {

		if (courseList == null) {
			return 0;
		}

		for (Course course : courseList) {
			courseDao.insertSelective(course);
			CourseChapter chapter = new CourseChapter();
			chapter.setChapterId(System.currentTimeMillis() + "");
			chapter.setCourseId(course.getCourseId());
			chapter.setChapterName("期末考核");
			courseChapterDao.insertSelective(chapter);
		}
		return 1;
	}

	@Override
	public List<Course> listCourseList(Course course) {

		if (course == null) {
			return null;
		}

		List<Course> courses = courseDao.listCourseSelective(course);
		return courses;
	}

	public Course getCourse(Long id) {

		System.out.println("--------------getcourse-----------");

		Course course = (Course) courseDao.selectByPrimaryKey(id);

		if (course == null) {
			return null;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");

		// 验证是否有权限查看课程内容
		// 比如未开课/或者非本校学生.
		dateFormat.format(course.getStartTime());

		CourseWare courseware = new CourseWare();
		courseware.setCourseId(course.getCourseId());
		List<CourseWare> coursewares = coursewareDao.listCourseWareList(courseware);

		CourseChapterExam exam = new CourseChapterExam();
		exam.setCourseId(course.getCourseId());
		List<CourseChapterExam> exams = examDao.listCourseChapterExamList(exam);

		List<CourseChapter> chapters = courseChapterDao.listChapterSelective(course.getCourseId());

		List<CourseFile> courseFileList = courseFileDao.listCourseFile(course.getCourseId());
		course.setFiles(courseFileList);

		CourseQA qa = new CourseQA();
		qa.setCourseId(course.getCourseId());
		List<CourseQA> courseqaList = courseQADao.listCourseQA(qa);
		course.setCourseqalist(courseqaList);

		for (CourseChapter c : chapters) {
			c.setCoursewares(new ArrayList<CourseWare>());
			c.setExams(new ArrayList<CourseChapterExam>());
			for (CourseWare cw : coursewares) {
				if (cw.getChapterId().equals(c.getChapterId())) {
					c.getCoursewares().add(cw);
				}
			}
			for (CourseChapterExam e : exams) {
				if (e.getChapterId().equals(c.getChapterId())) {
					c.getExams().add(e);
				}
			}
		}
		course.setChapters(chapters);

		return course;
	}

	@Override
	public int deleteCourseById(Long id) {

		// 验证身份

		// 删除课程所有章节
		courseChapterDao.deleteByPrimaryKey(id);
		// 删除课程所有课件
		coursewareDao.deleteByPrimaryKey(id);
		// 删除所有考试
		examDao.deleteByPrimaryKey(id);

		// 最后删除考试
		courseDao.deleteByPrimaryKey(id);

		return 0;
	}

	/********************
	 * 
	 * 课程章节操作
	 * 
	 ********************/
	// 插入--或者更新
	@Override
	public List<CourseChapter> insertCourseChapterList(List<CourseChapter> chapters) {

		for (CourseChapter chapter : chapters) {
			if (null == chapter.getId()) {
				chapter.setChapterId(RandomId.createId());
				courseChapterDao.insertSelective(chapter);
			} else {
				courseChapterDao.updateByPrimaryKeySelective(chapter);
			}
		}

		return courseChapterDao.listChapterSelective(chapters.get(0).getCourseId());
	}

	@Override
	public List<CourseChapter> listCourseChapterList(CourseChapter chapter) {

		if (chapter == null) {
			return null;
		}

		return courseChapterDao.listChapterSelective(chapter.getCourseId());
	}

	public CourseChapter getCourseChapterById(Long id) {

		return courseChapterDao.selectByPrimaryKey(id);

	}

	/*********************
	 * 
	 * 课程课件操作
	 * 
	 *********************/

	// 操作课件 --查/添加
	@Override
	public int insertCourseWareList(List<CourseWare> coursewares) {

		if (coursewares == null) {
			return 0;
		}
		for (CourseWare courseware : coursewares) {
			if (null == courseware.getCoursewareId() || courseware.getCoursewareId().equals("")) {
				courseware.setCoursewareId(RandomId.createId());
			}
			if (null == courseware.getId()) {
				coursewareDao.insertSelective(courseware);
			} else {
				coursewareDao.updateByPrimaryKeySelective(courseware);
			}
		}
		return 1;
	}

	public int deleteCourseWareById(long id) {

		return coursewareDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<CourseWare> listCourseWareList(CourseWare courseware) {

		if (courseware == null) {
			return null;
		}

		return coursewareDao.listCourseWareList(courseware);
	}

	/*************************
	 * 
	 * 操作章节考试
	 *
	 *************************/
	@Override
	public int insertCourseChapterExam(CourseChapterExam exam) {

		if (exam == null) {
			return 0;
		}
		if (null == exam.getExamId() || exam.getExamId().equals("")) {
			exam.setExamId(RandomId.createId());
		}
		return examDao.insertSelective(exam);
	}

	@Override
	public CourseChapterExam getCourseChapterExamById(Long id) {

		return examDao.selectByPrimaryKey(id);
	}

	@Override
	public List<CourseChapterExam> listCourseChapterExam(CourseChapterExam exam) {
		if (exam == null) {
			return null;
		}

		return examDao.listCourseChapterExamList(exam);
	}

	@Override
	public int updateExam(CourseChapterExam exam) {

		if (exam != null) {
			return 0;
		}

		examDao.updateByPrimaryKeySelective(exam);

		return 1;
	}

	@Override
	public Map<String, Object> commitCapterExam(Long id, String userId, String courseId, List<ExamAnswer> answerlist)
			throws UnknowSystemException {

		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("--------------------commit exam------------------");

		UserCourse usercourse = new UserCourse();
		usercourse.setCourseId(courseId);
		usercourse.setUserId(userId);
		System.out.println(usercourse.toString());

		usercourse = userCourseDao.getUserCourse(usercourse);
		// 用户没有此课程--------创建课程
		if (null == usercourse) {

			UserCourse userCourse = new UserCourse();
			userCourse.setCourseId(courseId);
			userCourse.setUserId(userId);
			this.insertUserCourse(userCourse);
		}
		System.out.println(usercourse.toString());

		// 有用户课程----
		usercourse.setCourseId(courseId);
		usercourse.setUserId(userId);
		usercourse = userCourseDao.getUserCourse(usercourse);

		if (null == usercourse) {
			System.out.println("-------------------------出轨问题-------------------------------");

			return null;
		}

		System.out.println(usercourse.toString());

		UserCourseDetail usercourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);

		int chapternum = 0;
		int examnum = 0;
		List<UserCourseChapterDetail> usercoursechapterdetaillist = usercourseDetail.getChapters();

		System.out.println(" usercoursedetail  " + usercourseDetail.toString());

		boolean bflag = false;
		for (int i = 0; i < usercoursechapterdetaillist.size(); i++) {
			for (int j = 0; j < usercoursechapterdetaillist.get(i).getExams().size(); j++) {
				if (usercoursechapterdetaillist.get(i).getExams().get(j).getId() == id) {
					chapternum = i;
					examnum = j;
					bflag = true;
					break;
				}
			}
			if (bflag) {
				break;
			}
		}
		// 如果没有当前考试，更新用户-课程信息后再次查找
		// 如果查找失败则返回null
		if (!bflag) {

			usercourse = this.updateOldUserCourse(userId, courseId);
			usercourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);
			usercoursechapterdetaillist = usercourseDetail.getChapters();

			for (int i = 0; i < usercoursechapterdetaillist.size(); i++) {
				for (int j = 0; j < usercoursechapterdetaillist.get(i).getExams().size(); j++) {
					if (usercoursechapterdetaillist.get(i).getExams().get(j).getId() == id) {
						chapternum = i;
						examnum = j;
						bflag = true;
						break;
					}
				}
				if (bflag) {
					break;
				}
			}
			if (!bflag) {
				throw new UnknowSystemException("系统错误。。。程序员正在加紧解决");
			}
		}

		CourseChapterExam exam = examDao.selectByPrimaryKey(id);
		int sum = 0;
		int icount = 0;
		if (null != exam.getAnswer()) {

			System.out.println(exam.getAnswer());
			List<ExamAnswer> anslist = new ArrayList<ExamAnswer>();
			JsonArray jsonArray = new JsonParser().parse(exam.getAnswer()).getAsJsonArray();
			System.out.println("-----------jsonObject-----");
			for (JsonElement c : jsonArray) {
				anslist.add(gson.fromJson(c.toString(), ExamAnswer.class));
			}
			map.put("anslist", anslist);
			sum = anslist.size();

			for (int i = 0; i < anslist.size(); i++) {
				for(int j=0;j < answerlist.size();j++){
					if(anslist.get(i).getNum() == answerlist.get(j).getNum()){
						sum ++;
						if(anslist.get(i).getAns().get(0).length() > 1){
							icount += 5;
							break;
						}
						if(anslist.get(i).getAns().get(0).equals(answerlist.get(j).getAns().get(0))){
							icount += 5;
							break;
						}
					}
				}
			}
		}

		System.out.println(usercourseDetail.getChapters().get(chapternum));

		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setAns(answerlist);
		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setCorrectSum(icount);
		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setDone(true);
		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setSum(sum);
		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setErrorSum(sum - icount);
		usercourseDetail.getChapters().get(chapternum).getExams().get(examnum).setScore(icount);
		int k = usercourseDetail.getExamCount();
		usercourseDetail.setExamCount(k + 1);
		if (usercourseDetail.getExamSum() > 0) {
			usercourseDetail.setExamPercent(usercourseDetail.getExamCount() / usercourseDetail.getExamSum());
		}
		usercourseDetail.setLastmodifiedTime(new Date());
		// 更新用户课程信息
		usercourse.setExamPercent(BigDecimal.valueOf(usercourseDetail.getExamPercent()));
		usercourse.setLastModify(new Date());
		usercourse.setDetail(gson.toJson(usercourseDetail));
		usercourse.setCourseId(courseId);
		usercourse.setUserId(userId);
		this.updateUserCourse(usercourse);

		map.put("sum", sum * 5);
		map.put("score", icount);
		map.put("uanslist", answerlist);

		return map;

	}

	/*************************
	 * 
	 * 课程答疑节考试
	 *
	 *************************/
	@Override
	public List<CourseQA> listCourseQA(CourseQA qa) {

		if (qa != null) {
			return courseQADao.listCourseQA(qa);
		}

		return null;
	}

	@Override
	public int insertCourseQA(CourseQA qa) {

		return courseQADao.insertSelective(qa);
	}

	@Override
	public int updateCourseQA(CourseQA qa) {

		return courseQADao.updateByPrimaryKeySelective(qa);
	}

	/*************************
	 * 
	 * 课程文件操作
	 *
	 *************************/
	@Override
	public int insertCourseFile(CourseFile file) {

		if (null == file.getMediaId() || file.getMediaId().equals("")) {
			file.setMediaId(RandomId.createId());
		}
		file.setCreateTime(new Date());

		return courseFileDao.insertSelective(file);
	}

	@Override
	public int insertCourseFileList(List<CourseFile> fileList) {
		if (null != fileList && fileList.size() > 0) {
			for (CourseFile file : fileList) {
				if (null == file.getId()) {
					if (null == file.getMediaId() || file.getMediaId().equals("")) {
						file.setMediaId(RandomId.createId());
					}
					file.setCreateTime(new Date());
					courseFileDao.insertSelective(file);
				} else {
					courseFileDao.updateByPrimaryKeySelective(file);
				}
			}
		}

		return 0;
	}

	/*************************
	 * 
	 * 课程操作----------用户
	 *
	 *************************/
	// 获取用户课程
	public List<Course> listUserHasSelectedCourse(String userId) {

		List<Course> courselist = new ArrayList<Course>();

		if (userId.equals("")) {
			return null;
		}
		UserCourse usercourse = new UserCourse();
		usercourse.setUserId(userId);
		List<UserCourse> usercourselist = userCourseDao.listUserCourse(usercourse);

		for (UserCourse ucourse : usercourselist) {
			courselist.add(courseDao.selectCourseBaseByCourseId(ucourse.getCourseId()));
		}

		return courselist;
	}

	@Override
	public UserCourse getUserCourse(String userId, String courseId) {

		UserCourse userCourse = new UserCourse();
		userCourse.setCourseId(courseId);
		userCourse.setUserId(userId);

		return userCourseDao.getUserCourse(userCourse);
	}

	@Override
	public List<UserCourse> listUserCourse(String userId) {

		UserCourse usercourse = new UserCourse();
		usercourse.setUserId(userId);
		return userCourseDao.listUserCourse(usercourse);
	}

	// 前端更新
	@Override
	public int updateUserCourse(UserCourse userCourse) {

		return userCourseDao.updateByPrimaryKeySelective(userCourse);
	}

	/*************************
	 * 
	 * 课程评论操作
	 *
	 *************************/
	@Override
	public int insertCourseComment(CourseComment comment) {

		if (null == comment) {
			return 0;
		}
		commentDao.insertSelective(comment);

		return 0;
	}

	@Override
	public List<CourseComment> listCourseComment(CourseComment comment) {

		if (null == comment)
			return null;

		// 如果comment.getContent()中存在敏感词，则不能添加评论

		return commentDao.listCourseComment(comment);
	}

	/*************************************************************************
	 * 
	 * 扩展操作
	 *
	 *************************************************************************/

	@Override
	public UserCourse insertUserCourse(UserCourse userCourse) {

		Course course = courseDao.selectCourseBaseByCourseId(userCourse.getCourseId());
		userCourse.setThumbnail(course.getThumbnail());
		userCourse.setTitle(course.getTitle());

		UserCourseDetail userCourseDetail = new UserCourseDetail();
		userCourseDetail.setCoursewareSum(0);
		userCourseDetail.setExamCount(0);

		int coursewareSum = 0;
		int examSum = 0;

		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		System.out.println("--userCourse---" + userCourse.getCourseId());

		try {
			chapters = courseChapterDao.listChapterSelective(userCourse.getCourseId());
		} catch (Exception e) {
			System.out.println(userCourse.getCourseId() + "----获取课程章节失败-----");
			e.printStackTrace();
		}
		if (null == chapters) {
			System.out.println(userCourse.getCourseId() + "课内未设置章节");

		} else {
			System.out.println("---- 课程章节-----");
			System.out.println(chapters.toString());

			CourseWare courseware = new CourseWare();

			List<UserCourseChapterDetail> chapterDetail = new ArrayList<UserCourseChapterDetail>();

			for (CourseChapter chapter : chapters) {

				System.out.println("-----------------------chapter---------------------------");

				UserCourseChapterDetail chapterdetail = new UserCourseChapterDetail();
				chapterdetail.setId(chapter.getId());

				List<CourseWare> coursewares = new ArrayList<CourseWare>();
				courseware.setCourseId(userCourse.getCourseId());
				courseware.setChapterId(chapter.getChapterId());
				System.out.println(courseware.toString());
				coursewares = coursewareDao.listCourseWareList(courseware);

				System.out.println("               -----------courseware---------            ");
				List<UserCourseWareDetail> coursewareDetail = new ArrayList<UserCourseWareDetail>();
				for (CourseWare coursew : coursewares) {
					UserCourseWareDetail usercourseware = new UserCourseWareDetail();
					usercourseware.setId(coursew.getId());
					usercourseware.setSee(false);
					System.out.println(usercourseware.toString());
					coursewareDetail.add(usercourseware);
					coursewareSum++;
				}
				chapterdetail.setCoursewares(coursewareDetail);

				List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
				CourseChapterExam exam = new CourseChapterExam();
				exam.setChapterId(chapter.getChapterId());
				exam.setCourseId(userCourse.getCourseId());
				exams = examDao.listCourseChapterExamList(exam);

				System.out.println("               -----------courseexam--------            ");
				List<UserCourseExamDetail> examDetail = new ArrayList<UserCourseExamDetail>();
				for (CourseChapterExam chapterExam : exams) {
					UserCourseExamDetail examdetail = new UserCourseExamDetail();
					examdetail.setId(chapterExam.getId());
					// List<ExamAnswer> ans =
					// gson.fromJson(chapterExam.getAnswer(),ExamAnswer.class);
					// if(ans != null){
					// examdetail.setAns(ans);
					// }
					examdetail.setDone(false);
					// 设置总分
					// examdetail.setScore(score);
					System.out.println(examdetail.toString());
					examDetail.add(examdetail);
					examSum++;
				}
				chapterdetail.setExams(examDetail);
				
				
				chapterDetail.add(chapterdetail);
			}
			
			userCourseDetail.setChapters(chapterDetail);
		}

		List<CourseQA> qas = new ArrayList<CourseQA>();
		CourseQA qa = new CourseQA();
		qa.setCourseId(userCourse.getCourseId());
		qa.setUserId(userCourse.getUserId());
		qas = courseQADao.listCourseQA(qa);

		int qaSum = 0;
		int qaHasProcess = 0;
		for (CourseQA q : qas) {
			if (q.getIsProcess() == true)
				qaHasProcess++;
			qaSum++;
		}
		userCourseDetail.setQaSum(qaSum);
		userCourseDetail.setQaHasProcess(qaHasProcess);

		
		userCourseDetail.setCoursewareSum(coursewareSum);
		userCourseDetail.setExamSum(examSum);
		userCourseDetail.setUserId(userCourse.getUserId());
		userCourseDetail.setCourseId(userCourse.getCourseId());
		userCourseDetail.setLastmodifiedTime(new Date());

		userCourse.setLastModify(new Date());
		userCourse.setDetail(gson.toJson(userCourseDetail));

		try {
			userCourseDao.insertSelective(userCourse);
			return userCourse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public UserCourse updateOldUserCourse(String userId, String courseId) {

		System.out.println("-------------更新usercourse----------------------");
		UserCourse usercourse = new UserCourse();

		usercourse.setCourseId(courseId);
		usercourse.setUserId(userId);
		usercourse = userCourseDao.getUserCourse(usercourse);

		if (null == usercourse) {
			return null;
		}
		UserCourseDetail usercourseDetail = gson.fromJson(usercourse.getDetail(), UserCourseDetail.class);

		List<CourseChapter> chapters = new ArrayList<CourseChapter>();
		chapters = courseChapterDao.listChapterSelective(usercourse.getCourseId());
		CourseWare courseware = new CourseWare();

		List<UserCourseChapterDetail> usercourseChapterDetail = new ArrayList<UserCourseChapterDetail>();

		int temp = 0;
		for (CourseChapter chapter : chapters) {
			temp = 0;
			for (int i = 0; i < usercourseDetail.getChapters().size(); i++) {
				if (usercourseDetail.getChapters().get(i).getId() == chapter.getId()) {
					temp = i;
					break;
				}
			}
			//不存在章节
			if (temp == 0) {
				UserCourseChapterDetail uc = new UserCourseChapterDetail();
				uc.setId(chapter.getId());

				List<UserCourseWareDetail> uwd = new ArrayList<UserCourseWareDetail>();
				List<CourseWare> coursewares = new ArrayList<CourseWare>();
				courseware.setCourseId(usercourse.getCourseId());
				courseware.setChapterId(chapter.getChapterId());
				coursewares = coursewareDao.listCourseWareList(courseware);
				for (CourseWare ware : coursewares) {
					UserCourseWareDetail cw = new UserCourseWareDetail();
					cw.setId(ware.getId());
					cw.setSee(false);
					uwd.add(cw);
					int k = usercourseDetail.getCoursewareSum();
					usercourseDetail.setChapterSum(k + 1);
				}
				uc.setCoursewares(uwd);

				List<UserCourseExamDetail> uced = new ArrayList<UserCourseExamDetail>();
				List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
				CourseChapterExam exam = new CourseChapterExam();
				exam.setChapterId(chapter.getChapterId());
				exam.setCourseId(usercourse.getCourseId());
				exams = examDao.listCourseChapterExamList(exam);
				for (CourseChapterExam em : exams) {
					UserCourseExamDetail ed = new UserCourseExamDetail();
					ed.setDone(false);
					ed.setId(em.getId());
					uced.add(ed);
					int k = usercourseDetail.getExamSum();
					usercourseDetail.setExamSum(k + 1);
				}
				uc.setExams(uced);
				usercourseChapterDetail.add(uc);
				continue;
			}

			// 更新章节课件
			List<CourseWare> coursewares = new ArrayList<CourseWare>();
			courseware.setCourseId(usercourse.getCourseId());
			courseware.setChapterId(chapter.getChapterId());
			coursewares = coursewareDao.listCourseWareList(courseware);
			if (coursewares.size() != usercourseDetail.getChapters().get(temp).getCoursewares().size()) {
				int flag = 0;
				for (CourseWare ware : coursewares) {
					flag = 0;
					for (UserCourseWareDetail cw : usercourseDetail.getChapters().get(temp).getCoursewares()) {
						if (ware.getId() == cw.getId()) {
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						UserCourseWareDetail cw = new UserCourseWareDetail();
						cw.setId(ware.getId());
						cw.setSee(false);
						usercourseDetail.getChapters().get(temp).getCoursewares().add(cw);
						int k = usercourseDetail.getCoursewareSum();
						usercourseDetail.setChapterSum(k + 1);
					}
				}
			}

			// 更新章节考试
			List<CourseChapterExam> exams = new ArrayList<CourseChapterExam>();
			CourseChapterExam exam = new CourseChapterExam();
			exam.setChapterId(chapter.getChapterId());
			exam.setCourseId(usercourse.getCourseId());
			exams = examDao.listCourseChapterExamList(exam);
			if (exams.size() != usercourseDetail.getChapters().get(temp).getExams().size()) {
				int flag = 0;
				for (CourseChapterExam ex : exams) {
					flag = 0;
					for (UserCourseExamDetail ce : usercourseDetail.getChapters().get(temp).getExams()) {
						if (ce.getId() == ex.getId()) {
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						UserCourseExamDetail ed = new UserCourseExamDetail();
						ed.setDone(false);
						ed.setId(ex.getId());
						usercourseDetail.getChapters().get(temp).getExams().add(ed);
						int k = usercourseDetail.getExamSum();
						usercourseDetail.setExamSum(k + 1);
					}
				}
			}

		}

		if (usercourseChapterDetail.size() > 0) {
			for (UserCourseChapterDetail uccd : usercourseChapterDetail)
				usercourseDetail.getChapters().add(uccd);
		}
		usercourseDetail.setLastmodifiedTime(new Date());
		usercourse.setDetail(gson.toJson(usercourseDetail));
		usercourse.setLastModify(new Date());

		try {
			userCourseDao.updateByPrimaryKeySelective(usercourse);
			return usercourse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
