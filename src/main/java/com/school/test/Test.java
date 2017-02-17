package com.school.test;

import com.school.db.country.State;
import com.school.db.country.Country;
import com.school.db.exam.ExamType;
import com.school.db.school.Classes;
import com.school.db.school.Stage;
import com.school.db.setting.HibernateDriver;
import com.school.db.user.FamilyInformation;
import com.school.db.user.Nationality;
import com.school.db.user.PersonalInfo;
import com.school.db.user.Student;
import com.school.db.user.Stuff;
import com.school.dao.UserDAO;
import com.school.dao.UserImplement;
import com.school.db.school.RowsOFStage;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salah Atwa
 */
public class Test extends HibernateDriver{
    
    
    /**
     * Insert Exam Type
     */
    public void insertExamType()
    {
        openSession();
        ExamType quizType=new ExamType();
        quizType.setTypeName("Quiz exam");
        getSession().save(quizType);
        
        ExamType halfTermType=new ExamType();
        halfTermType.setTypeName("Half term exam");
        getSession().save(halfTermType);
        
        ExamType finalTerm=new ExamType();
        finalTerm.setTypeName("Final term exam");
        getSession().save(finalTerm);
        
        closeSession();
    }
    
    /**
     * Insert new Student
     */
    public void insertStudent()
    {
        openSession();
        
        Country country=new Country();
        country.setCountryName("Egypt");
        
        Set<State> cityies=new LinkedHashSet<State>();
        State city=new State();
        city.setCityName("Cairo");
        cityies.add(city);
        city.setCityName("Giza");
        cityies.add(city);
        city.setCityName("Alex");
        cityies.add(city);
        
        country.setCities(cityies);
        
        PersonalInfo personalInfo=new PersonalInfo();
        personalInfo.setFname("Salah");
        personalInfo.setLname("Atwa");
        personalInfo.setGender("male");
        personalInfo.setPhone("01091687523");
        personalInfo.setPassword("3889735");
        personalInfo.setEmail("atwa@gmail.com");
        personalInfo.setBirthDate(new Date());
        personalInfo.setReligion("Muslims");
        personalInfo.setCountry(country);
        
        Set<Nationality> nationalities = new LinkedHashSet<Nationality>();
        Nationality nationality=new Nationality();
        nationality.setNationality("Egyptian");
        nationalities.add(nationality);
        
        Stage stage=new Stage();
        stage.setStageName("First primary stage");
        stage.setStageYear("2017");
        
        FamilyInformation familyInfo=new FamilyInformation();
        familyInfo.setFatherAddress("mostafa street");
        familyInfo.setFatherEmail("father@gmail.com");
        familyInfo.setFatherJob("polician");
        familyInfo.setFatherPhone("01091687523");
        
        
        Classes classes=new Classes();
        classes.setClassName("First class");
        classes.setClassNum(1);
        
        
        
        Student student=new Student();
        student.setPersonalInfo(personalInfo);
        student.setNationalities(nationalities);
        student.setStage(stage);
        student.setFamilyInfo(familyInfo);
        student.setClassNum(classes);
        
        
        getSession().save(student);
        
        closeSession();
    }
    
    public void insertAdmin()
    {
        openSession();
        
        Country country=new Country();
        country.setCountryName("Egypt");
        
        Set<State> cityies=new LinkedHashSet<State>();
        State city=new State();
        city.setCityName("Cairo");
        cityies.add(city);
        city.setCityName("Giza");
        cityies.add(city);
        city.setCityName("Alex");
        cityies.add(city);
        
        country.setCities(cityies);
        
        PersonalInfo personalInfo=new PersonalInfo();
        personalInfo.setFname("hadeel");
        personalInfo.setLname("family name");
        personalInfo.setAddress("COLMIA Street");
         personalInfo.setEmail("atwa@gmail.com");
        personalInfo.setPassword("01091687523");
        personalInfo.setCountry(country);
        personalInfo.setGender("Female");
//        
//        getSession().save(admin);
        
        Stuff user=new Stuff();
        user.setPersonalInfo(personalInfo);
        
        getSession().save(user);
        
        closeSession();
    }

    public void getUser()
    {
//        Country country=new Country();
//        country.setCountryName("Egypt");
//        
//        Set<City> cityies=new LinkedHashSet<City>();
//        State city=new State();
//        city.setCityName("Cairo");
//        cityies.add(city);
//        city.setCityName("Giza");
//        cityies.add(city);
//        city.setCityName("Alex");
//        cityies.add(city);
//        
//        country.setCities(cityies);
//        
//        PersonalInfo personalInfo=new PersonalInfo();
//        personalInfo.setFname("Salah Sayed atwa Mohamed");
//        personalInfo.setLname("family name");
//        personalInfo.setAddress("COLMIA Street");
//        personalInfo.setEmail("atwa@gmail.com");
//        personalInfo.setPassword("01091687523");
//        personalInfo.setCountry(country);
//        personalInfo.setGender("Male");
//        Admin admin=new Admin();
//        admin.setPersonalInfo(personalInfo);
        
//        HibernateDriver hibernateDriver = (HibernateDriver) context.getBean("hibernate");
//        Session session = (Session) context.getBean("hibernateSession");
//        Transaction transaction=(Transaction) context.getBean("hibernateTransaction");
//        hibernateDriver.setSession(session);
//        hibernateDriver.setTransaction(transaction);
        openSession();
        
        UserDAO userDAO = new UserImplement();
//        UserImplement userDAO=new UserImplement();
//        userImpl.setHibernateDriver(hibernateDriver);
//        userDAO.
//        userDAO.updateUser(admin);
        Stuff user=userDAO.getUser("atwa@gmail.com", "01091687523");
        
        System.out.println(user.getUser_type()+"\t"+user.getId());
        closeSession();
//        System.out.println(user.getId());
    }
    
    public void testDataBase()
    {
        openSession();
        
//        StudentNotes studentNotes=new StudentNotes();
//        studentNotes.setNoteText("IS BAD");
//        getSession().save(studentNotes);
//        System.out.println("Success");
        
        closeSession();
    }
    public static void main(String[] args) {
        
     
      
      Test test =  new Test();
//      test.testDataBase();
//      test.testDataBase();
//      test.insertExamType();
//      test.insertStudent();
//      test.insertAdmin();
      test.insertStage();
//       test.getUser();
    }
    
    public void insertStage()
    {
        openSession();
        
        RowsOFStage rowsOFStage=new RowsOFStage();
        rowsOFStage.setRowName("First class Name");
        
        Set<RowsOFStage> ss=new LinkedHashSet<>();
        ss.add(rowsOFStage);
        
        Stage stage=new Stage();
        stage.setStageName("Console Stage");
        stage.setStageYear("2105");
        stage.setStageRowses(ss);
        
        getSession().save(stage);
        
        closeSession();
    }
    
}
