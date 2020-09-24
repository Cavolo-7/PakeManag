//package com.auc.util;
//
//import com.coolin.driver.service.DriverService;
//import com.coolin.entity.Exam;
//import com.coolin.entity.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//
//@Component
//public class ScheduledTask {
//    /**
//     * spring任务定时执行
//     */
////    @Scheduled(initialDelay=1000, fixedDelay = 1000)
////    public void task1() {
////        System.out.println("延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
//
////    @Scheduled(fixedRate = 2000)
////    public void task2() {
////        System.out.println("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
////    }
//
//    @Autowired
//    private DriverService driverService;
//
//
//    //@Scheduled(cron = "*/10 * * * * ?")
//    public void task3() {
//        List<Student> stu = driverService.selectTack();
//        for (int i = 0;i<stu.size();i++){
//            Integer score = Double.valueOf(String.valueOf(stu.get(i).getSubjectOne())).intValue();
//            Student student = new Student(stu.get(i).getStudentId(),stu.get(i).getStudentName(),stu.get(i).getDriverId(),stu.get(i).getCoachId());
//            HashMap hashMap = new HashMap();
//            hashMap.put("studentId",stu.get(i).getStudentId());
//            if (score==100){//-----------科一满足
//                hashMap.put("studentState",2);
//                driverService.studentState(hashMap);
//                student.setExamProject(1);
//                driverService.addExam(student);
//            }else if(score==200){//-----------科二满足
//                hashMap.put("studentState",2);
//                driverService.studentState(hashMap);
//                student.setExamProject(2);
//                driverService.addExam(student);
//            }else if(score==300){//-----------科三满足
//                hashMap.put("studentState",2);
//                driverService.studentState(hashMap);
//                student.setExamProject(3);
//                driverService.addExam(student);
//            }else if(score==400){//-----------科四满足
//                hashMap.put("studentState",2);
//                driverService.studentState(hashMap);
//                student.setExamProject(4);
//                driverService.addExam(student);
//            }
//         }
//    }
//
//}
